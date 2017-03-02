package io.github.tiscs.demos.oauth2.entities;

import java.io.Serializable;
import java.util.Objects;

public class OAuth2AccountId implements Serializable {
    private Long oauth2ClientId;
    private Long userAccountId;

    public OAuth2AccountId() {
    }

    public OAuth2AccountId(Long oauth2ClientId, Long userAccountId) {
        this.oauth2ClientId = oauth2ClientId;
        this.userAccountId = userAccountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OAuth2AccountId that = (OAuth2AccountId) o;
        return Objects.equals(oauth2ClientId, that.oauth2ClientId) &&
                Objects.equals(userAccountId, that.userAccountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oauth2ClientId, userAccountId);
    }
}
