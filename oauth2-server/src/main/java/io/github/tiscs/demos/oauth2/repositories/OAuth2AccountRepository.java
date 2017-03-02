package io.github.tiscs.demos.oauth2.repositories;

import io.github.tiscs.demos.oauth2.entities.OAuth2AccountEntity;
import io.github.tiscs.demos.oauth2.entities.OAuth2AccountId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OAuth2AccountRepository extends JpaRepository<OAuth2AccountEntity, OAuth2AccountId> {
}
