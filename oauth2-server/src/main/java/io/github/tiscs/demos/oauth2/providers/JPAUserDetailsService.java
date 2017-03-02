package io.github.tiscs.demos.oauth2.providers;

import io.github.tiscs.demos.oauth2.entities.UserCredentialEntity;
import io.github.tiscs.demos.oauth2.repositories.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class JPAUserDetailsService implements UserDetailsService {
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final UserCredentialRepository userCredentialRepository;

    @Autowired
    public JPAUserDetailsService(UserCredentialRepository userCredentialRepository) {
        this.userCredentialRepository = userCredentialRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentialEntity credential = userCredentialRepository.findOneByUserKey(username);
        return new User(
                credential.getUserKey(),
                credential.getSecretCode(),
                !credential.getAccount().isDisabled(),
                true,
                true,
                true,
                new ArrayList<>()
        );
    }
}
