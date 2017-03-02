package io.github.tiscs.demos.oauth2.entities;

import javax.persistence.*;

@Entity
@IdClass(OAuth2ClientScopeId.class)
@Table(name = "oauth2_client_scopes")
public class OAuth2ClientScopeEntity {
    @Id
    @Column(name = "client_id", length = 32)
    private String clientId;

    @Id
    @Column(name = "scope_id")
    private Long scopeId;

    @Column(name = "auto_approve")
    private Boolean autoApprove;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id", insertable = false, updatable = false, nullable = false)
    private OAuth2ClientEntity client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "scope_id", insertable = false, updatable = false, nullable = false)
    private OAuth2ScopeEntity scope;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Long getScopeId() {
        return scopeId;
    }

    public void setScopeId(Long scopeId) {
        this.scopeId = scopeId;
    }

    public Boolean getAutoApprove() {
        return autoApprove;
    }

    public void setAutoApprove(Boolean autoApprove) {
        this.autoApprove = autoApprove;
    }

    public OAuth2ClientEntity getClient() {
        return client;
    }

    public void setClient(OAuth2ClientEntity client) {
        this.client = client;
    }

    public OAuth2ScopeEntity getScope() {
        return scope;
    }

    public void setScope(OAuth2ScopeEntity scope) {
        this.scope = scope;
    }
}
