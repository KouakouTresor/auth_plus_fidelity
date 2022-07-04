 package com.authentication.springsecurity.config;
import com.authentication.springsecurity.service.userService.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


 @Configuration
@EnableWebSecurity
public class websecurityConfig  extends WebSecurityConfigurerAdapter {
    /*@Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
*/
    @Autowired
    DataSource dataSource ;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.authenticationProvider(authenticationProvider());*/
        auth.jdbcAuthentication()
                .dataSource(dataSource);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/clients").hasAnyRole("USER","ADMIN")
                .antMatchers("/api/clients/search/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/api/clients/insert").hasRole("ADMIN")
                .antMatchers("/api/clients/delete/**").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                /*.formLogin().permitAll()
                .and()
                .logout().permitAll()
                */



        ;
    }



    }




