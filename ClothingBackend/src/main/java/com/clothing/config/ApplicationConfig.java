package com.clothing.config;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.clothing.repo.UserRepo;
import com.mysql.cj.protocol.AuthenticationProvider;

@Configuration
public class ApplicationConfig {

    @Autowired
    private UserRepo userRepo;

    @Bean
    public UserDetailsService userDetailsService(){
        User username=null;
		return (UserDetailsService) (username = userRepo.findByEmail(username));
    }
 
         

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }


    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider =new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService((org.springframework.security.core.userdetails.UserDetailsService) userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return (AuthenticationProvider) authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
