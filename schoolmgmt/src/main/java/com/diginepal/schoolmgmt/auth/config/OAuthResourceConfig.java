package com.diginepal.schoolmgmt.auth.config;

import com.diginepal.schoolmgmt.path.ApiPaths;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;


@Configuration
@EnableResourceServer
public class OAuthResourceConfig extends ResourceServerConfigurerAdapter {
    //todo uncomment auth path in development/production



    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                anonymous().disable()
                .authorizeRequests()
                .antMatchers("/oauth/**").authenticated() //authorization API
                .antMatchers(ApiPaths.BRANCH_PATH, ApiPaths.COMPANY).hasAuthority("ROLE_SUPER_ADMIN") //authorization API
                .antMatchers("/api/**").hasAuthority("ROLE_SUPER_ADMIN") //user management
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
