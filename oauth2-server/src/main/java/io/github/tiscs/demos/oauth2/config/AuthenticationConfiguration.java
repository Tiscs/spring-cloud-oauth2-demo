package io.github.tiscs.demos.oauth2.config;

import io.github.tiscs.demos.oauth2.providers.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

@Configuration
public class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
    private final JpaUserDetailsService userDetailsService;

    @Autowired
    public AuthenticationConfiguration(JpaUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
