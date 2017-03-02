package io.github.tiscs.demos.oauth2.repositories;

import io.github.tiscs.demos.oauth2.entities.OAuth2ScopeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OAuth2ScopeRepository extends JpaRepository<OAuth2ScopeEntity, Long> {
    @Query("select distinct(s.key) from OAuth2ScopeEntity s" +
            " left join s.clientScopes cs" +
            " where s.clientId = :clientId or cs.clientId = :clientId")
    Set<String> findScopeKeysByClientId(@Param("clientId") String clientId);
}
