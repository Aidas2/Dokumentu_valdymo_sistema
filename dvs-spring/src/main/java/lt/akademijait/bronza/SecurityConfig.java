package lt.akademijait.bronza;

import lt.akademijait.bronza.security.SecurityEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityEntryPoint securityEntryPoint;

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // galima pakeisti
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
    }

    //THIS WORKS FOR AUTHENTICATION. DONE NOT BY STASAUSKAS

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
//        http.headers().disable(); //for H2 console
        http.authorizeRequests()
                .antMatchers("/swagger-ui.html","/api**","/files**").authenticated()
                .anyRequest().permitAll() //any requests that are not in antMatchers will be allowed
                .and().formLogin().permitAll()
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request,
                                                        HttpServletResponse response,
                                                        Authentication authentication)
                            throws IOException, ServletException {
                        response.setHeader("Access-Control-Allow-Credentials", "true");
                        response.setHeader("Access-Control-Allow-Origin",
                                request.getHeader("Origin"));
                        response.setHeader("Content-Type",
                                "application/json;charset=UTF-8");
                        response.getWriter().print("{\"username\": \""+
                                SecurityContextHolder.getContext().getAuthentication().getName()
                                +"\"}");
                    }
                })
                .and().logout().permitAll() // leidziam /logout


        ;
    }


//auth.inMemoryAuthentication().withUser("uu")
// .password("pp").roles("USER", "CALC");


//THIS CAN BE USED FOR LOGIN WITHOUT ANY ENRYPTION AND i GUESS NO ROLES
//    @Bean
//    public AuthenticationProvider authenticationProvider (){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//        return provider;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests().anyRequest().authenticated()
//                .and().formLogin()
//                .and().httpBasic();
//    }


//THE MOETHOD FROM STASAUSKAS SLIDES. HOWEVER IT CANNOT ACCEPT THE USERNAME AND PASS FROM DB YET
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//// be saugumo UI dalis ir swaggeris
//                .antMatchers("/", "/swagger-ui.html").permitAll()
//// visi /api/ saugus (dar galima .anyRequest() )
//                .antMatchers("/api/**", "/calc/**").authenticated()
//                .and().formLogin() // leidziam login
//// prisijungus
//                .successHandler(new SimpleUrlAuthenticationSuccessHandler())
//// esant blogiems user/pass
//                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
//                .loginPage("/login").permitAll() // jis jau egzistuoja !
//                .and().logout().permitAll() // leidziam /logout
//                .and()
//                .csrf().disable() // nenaudojam tokenu
//// toliau forbidden klaidai
//                .exceptionHandling()
//                .authenticationEntryPoint(securityEntryPoint)
//                .and()
//                .headers().frameOptions().disable(); // H2 konsolei
//    }


}
