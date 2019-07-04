package com.diginepal.schoolmgmt.auth.config;

import com.diginepal.schoolmgmt.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;


/**
 * @author Pattharyodash Pramil !!
 */


@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    private final String CLIENT_ID="F1HGOH7F3A1UG6YTXPUF";
    private final String CLIENT_SECRET="JYYYRQBSQCN2V6NE8SHOBDIU3ZL2HNFEUCH7FPQA";

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    UserService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

    @Autowired
    @Lazy
    private AuthenticationManager authenticationManagerBean;

    @Autowired
    public void setAuthenticationManagerBean(AuthenticationManager authenticationManagerBean) {
        this.authenticationManagerBean = authenticationManagerBean;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient(CLIENT_ID)
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "client_credentials", "implicit")
                .authorities(
                        "SUPER_ADMIN",
                        "CSR",
                        "PRODUCER_AGENCY",
                        "PRODUCER",
                        "POT_INSURE")
                .scopes("read", "write")
                .autoApprove(true)
                .accessTokenValiditySeconds(1800)
                .secret(passwordEncoder().encode(CLIENT_SECRET));
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore())
                .userDetailsService(userDetailsService)
                .tokenStore(tokenStore)
                .authenticationManager(authenticationManagerBean);
    }
}

