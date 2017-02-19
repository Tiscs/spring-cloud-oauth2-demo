package io.github.tiscs.demos.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

@Configuration
public class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(...);
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .authorities("READ", "WRITE")
                .and()
                .withUser("user")
                .password("user")
                .authorities("READ");
    }
}
