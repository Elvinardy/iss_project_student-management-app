/* package com.student_management_app.config;

import com.okta.spring.boot.oauth.Okta;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpEntity http) throws Exception {
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

        http.requiresChannel()
            .requestMatchers(r -> r.getHeader("X-Forwarded-Proto")!=null)
            .requiresSecure();

    }
    
    

} 
 */