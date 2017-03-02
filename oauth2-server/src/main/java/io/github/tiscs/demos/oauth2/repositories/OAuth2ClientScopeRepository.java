package io.github.tiscs.demos.oauth2.repositories;

import io.github.tiscs.demos.oauth2.entities.OAuth2ClientScopeEntity;
import io.github.tiscs.demos.oauth2.entities.OAuth2ClientScopeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OAuth2ClientScopeRepository extends JpaRepository<OAuth2ClientScopeEntity, OAuth2ClientScopeId> {
}
