package io.github.tiscs.demos.oauth2.repositories;

import io.github.tiscs.demos.oauth2.entities.UserCredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredentialEntity, Long> {
    UserCredentialEntity findOneByUserKey(String userKey);
}
