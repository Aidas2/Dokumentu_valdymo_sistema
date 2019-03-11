package lt.akademijait.bronza;

import lt.akademijait.bronza.security.SecurityEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityEntryPoint securityEntryPoint;
    @Autowired
    private UserDetailsService userService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userService);
//auth.inMemoryAuthentication().withUser("uu")
// .password("pp").roles("USER", "CALC");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
// be saugumo UI dalis ir swaggeris
                .antMatchers("/", "/swagger-ui.html").permitAll()
// visi /api/ saugus (dar galima .anyRequest() )
                .antMatchers("/api/**", "/calc/**").authenticated()
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
