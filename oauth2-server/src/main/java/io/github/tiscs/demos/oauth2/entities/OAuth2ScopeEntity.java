package io.github.tiscs.demos.oauth2.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "oauth2_scopes", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"scope_key", "client_id"}),
        @UniqueConstraint(columnNames = {"scope_name", "client_id"})
})
public class OAuth2ScopeEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "scope_key", nullable = false, length = 64)
    private String key;

    @Column(name = "scope_name", length = 64)
    private String name;

    @Column(name = "client_id", nullable = false, length = 32)
    private String clientId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", insertable = false, updatable = false, nullable = false)
    private OAuth2ClientEntity client;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "scope")
    private Collection<OAuth2ClientScopeEntity> clientScopes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public OAuth2ClientEntity getClient() {
        return client;
    }

    public void setClient(OAuth2ClientEntity client) {
        this.client = client;
    }

    public Collection<OAuth2ClientScopeEntity> getClientScopes() {
        return clientScopes;
    }

    public void setClientScopes(Collection<OAuth2ClientScopeEntity> clientScopes) {
        this.clientScopes = clientScopes;
    }
}
