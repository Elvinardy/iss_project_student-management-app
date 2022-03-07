/* package com.student_management_app.config;

import com.okta.spring.boot.oauth.Okta;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // to protect the endpoint /api/student

        http.authorizeRequests()
            .antMatchers("/student/**")
            .authenticated()
            .and()
            .oauth2ResourceServer()
            .jwt();

            http.cors();

        Okta.configureResourceServer401ResponseBody(http);

        http.csrf().disable();
    }
    
    

} */
