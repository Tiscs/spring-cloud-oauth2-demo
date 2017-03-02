package io.github.tiscs.demos.oauth2.providers;

import io.github.tiscs.demos.oauth2.entities.UserAccountEntity;
import io.github.tiscs.demos.oauth2.entities.UserCredentialEntity;
import io.github.tiscs.demos.oauth2.repositories.UserAccountRepository;
import io.github.tiscs.demos.oauth2.repositories.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class JPAUserDetailsService implements UserDetailsService {
    private final UserCredentialRepository userCredentialRepository;
    private final UserAccountRepository userAccountRepository;

    @Autowired
    public JPAUserDetailsService(UserCredentialRepository userCredentialRepository, UserAccountRepository userAccountRepository) {
        this.userCredentialRepository = userCredentialRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentialEntity credential = userCredentialRepository.findOneByUserKey(username);
        UserAccountEntity account = userAccountRepository.findOne(credential.getAccountId());
        return new User(
                credential.getUserKey(),
                credential.getSecretCode(),
                !account.isDisabled(),
                true,
                true,
                true,
                Collections.emptyList()
        );
    }
}
