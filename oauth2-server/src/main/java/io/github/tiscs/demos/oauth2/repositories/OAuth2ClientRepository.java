package io.github.tiscs.demos.oauth2.repositories;

import io.github.tiscs.demos.oauth2.entities.OAuth2ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OAuth2ClientRepository extends JpaRepository<OAuth2ClientEntity, String> {
}
