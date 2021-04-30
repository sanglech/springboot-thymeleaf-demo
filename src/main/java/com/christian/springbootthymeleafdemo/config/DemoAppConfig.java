package com.christian.springbootthymeleafdemo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoAppConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").anonymous()
                .antMatchers("/employees/list").anonymous()
                .antMatchers("/employees/showFormForAdd").anonymous()
                .antMatchers("/employees/showFormForUpdate").anonymous()
                .antMatchers("/employees/save").anonymous()
                .antMatchers("/employees/delete").anonymous()
                .anyRequest().authenticated();
    }
}
