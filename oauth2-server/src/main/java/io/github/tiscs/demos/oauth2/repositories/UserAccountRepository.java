package io.github.tiscs.demos.oauth2.repositories;

import io.github.tiscs.demos.oauth2.entities.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Long> {
}
