package ls.hvacaretaker.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * Klasa konfiguracji WebSecurity
 * Zawiera podstawowe ustawienia dotyczące uwierzytelnienia i autoryzacji w aplikacji.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    /**
     * Konstruktor nowego @Bean dla enkodera haseł dla użytkowników.
     *
     * @return obiekt enkodera haseł typu BCrypt
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Metoda ustawia parametry dla warstwy DaoAuthenticationProvider i zwraca skonfigurowany obiekt.
     *
     * @return obiekt typu DaoAuthenticationProvider
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenticationProvider());
        auth.inMemoryAuthentication()
                .withUser("administrator")
                .password("$2a$12$2SNljltYsTOTIcq1kXycHOXsqnsfbp.kKAJ/BQBDU68J4cDyQDgqK")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/userpanel/**").hasAnyAuthority("USER", "TECHNICIAN", "ADMIN")
                .mvcMatchers("/servicepanel/**").hasAnyAuthority("TECHNICIAN", "ADMIN")
                .mvcMatchers("/accountdetails").authenticated()
                .mvcMatchers("/user/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().logoutSuccessUrl("/").permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
