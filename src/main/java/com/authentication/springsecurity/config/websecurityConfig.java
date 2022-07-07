 package com.authentication.springsecurity.config;
import com.authentication.springsecurity.service.userService.UserService;
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



@Configuration
@EnableWebSecurity
public class websecurityConfig  extends WebSecurityConfigurerAdapter {
   /*  @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    } */

     @Autowired
     private UserService userService;


     @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()

                .antMatchers("http://localhost:8080/clients").permitAll()
               /* .antMatchers("/clients").hasAnyRole("USER","ADMIN")
                .antMatchers("/clients/search/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/clients/post").hasRole("ADMIN")
                .antMatchers("/clients/delete/**").hasRole("ADMIN")

                .anyRequest().authenticated()
                */

                .and()
                .formLogin().permitAll()
                .defaultSuccessUrl("/clients", true)

                .and()
                .logout().permitAll()


                /*
                .and()
                .logout().permitAll()
                */

        ;
    }

     @Bean
     public BCryptPasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }

     @Bean
     public DaoAuthenticationProvider authenticationProvider() {
         DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
         auth.setUserDetailsService(userService);
         auth.setPasswordEncoder(passwordEncoder());

         return auth;
     }

     @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.authenticationProvider(authenticationProvider());
       /* auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder());

        */

     }


    }




