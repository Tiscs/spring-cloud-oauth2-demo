package io.github.tiscs.demos.oauth2.entities;

import java.io.Serializable;
import java.util.Objects;

public class OAuth2ClientScopeId implements Serializable {
    private String clientId;
    private String scopeId;

    public OAuth2ClientScopeId() {
    }
    public OAuth2ClientScopeId(String clientId, String scopeId) {
        this.clientId = clientId;
        this.scopeId = scopeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OAuth2ClientScopeId that = (OAuth2ClientScopeId) o;
        return Objects.equals(clientId, that.clientId) &&
                Objects.equals(scopeId, that.scopeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, scopeId);
    }
}
