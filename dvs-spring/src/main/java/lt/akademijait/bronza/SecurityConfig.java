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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityEntryPoint securityEntryPoint;
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService);
//auth.inMemoryAuthentication().withUser("uu")
// .password("pp").roles("USER", "CALC");
    }

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
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
// be saugumo UI dalis ir swaggeris
                .antMatchers("/", "/swagger-ui.html").permitAll()
// visi /api/ saugus (dar galima .anyRequest() )
                .antMatchers(/*"/api/**", */"/calc/**").authenticated()
                .and().formLogin() // leidziam login
// prisijungus
                .successHandler(new SimpleUrlAuthenticationSuccessHandler())
// esant blogiems user/pass
                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .loginPage("/login").permitAll() // jis jau egzistuoja !
                .and().logout().permitAll() // leidziam /logout
                .and()
                .csrf().disable() // nenaudojam tokenu
// toliau forbidden klaidai
                .exceptionHandling()
                .authenticationEntryPoint(securityEntryPoint)
                .and()
                .headers().frameOptions().disable(); // H2 konsolei
    }


    }
