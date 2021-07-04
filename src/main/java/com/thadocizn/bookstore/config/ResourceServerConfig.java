package com.thadocizn.bookstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter
{

    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources)
    {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

//    curl -X POST --user 'lambda-client:lambda-secret' -d 'grant_type=password&username=sally&password=password' 'http://localhost:8080/oauth/token'

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                anonymous().disable()
                .authorizeRequests()
                .antMatchers("/data/**").access("hasAnyRole('ROLE_DATA')")
                .antMatchers("/users/**").access("hasAnyRole('ROLE_MGR')")
                .antMatchers("/books/**").access("hasAnyRole('ROLE_USER','ROLE_DATA','ROLE_MGR')")
                .antMatchers("/authors/**").access("hasAnyRole('ROLE_USER','ROLE_DATA','ROLE_MGR')")
                .antMatchers("/sections/**").access("hasAnyRole('ROLE_USER','ROLE_DATA','ROLE_MGR')")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}