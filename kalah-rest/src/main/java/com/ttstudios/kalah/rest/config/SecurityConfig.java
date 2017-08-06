package com.ttstudios.kalah.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // TODO move to properties
        auth.inMemoryAuthentication().withUser("john").password("123").roles("SYSTEM");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/*").permitAll();
        http.authorizeRequests().antMatchers("/chat/*").permitAll();
        http.authorizeRequests().antMatchers( "/socket.io/*" ).permitAll();
        http.authorizeRequests().antMatchers( "/app/topic/*" ).permitAll();
        http.authorizeRequests().anyRequest().hasRole("SYSTEM").and().httpBasic().and().csrf().disable();
    }
}
