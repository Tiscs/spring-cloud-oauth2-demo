package io.github.tiscs.demos.oauth2.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "oauth2_clients")
public class OAuth2ClientEntity {
    @Id
    @Column(name = "id", length = 32)
    private String id;

    @Column(name = "secret", nullable = false, length = 32)
    private String secret;

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Column(name = "resource_ids", length = 256)
    private String resourceIds;

    @Column(name = "authorities", length = 256)
    private String authorities;

    @Column(name = "grant_types", length = 256)
    private String grantTypes;

    @Column(name = "redirect_uris", length = 256)
    private String redirectUris;

    @Column(name = "access_token_validity")
    private Integer accessTokenValidity;

    @Column(name = "refresh_token_validity")
    private Integer refreshTokenValidity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private Collection<OAuth2AccountEntity> accounts = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private Collection<OAuth2ClientScopeEntity> clientScopes;

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    private void setSecret(String secret) {
        this.secret = secret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(String grantTypes) {
        this.grantTypes = grantTypes;
    }

    public String getRedirectUris() {
        return redirectUris;
    }

    public void setRedirectUris(String redirectUris) {
        this.redirectUris = redirectUris;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public Collection<OAuth2AccountEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<OAuth2AccountEntity> accounts) {
        this.accounts = accounts;
    }

    @PrePersist
    public void prePersist() {
        this.setId(UUID.randomUUID().toString());
        this.setSecret(UUID.randomUUID().toString());
    }
}
