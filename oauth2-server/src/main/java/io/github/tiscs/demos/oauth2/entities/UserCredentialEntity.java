package io.github.tiscs.demos.oauth2.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_credentials")
public class UserCredentialEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "provider_key", nullable = false, length = 128)
    private String providerKey;

    @Column(name = "user_key", unique = true, nullable = false, length = 256)
    private String userKey;

    @Column(name = "secret_code", length = 256)
    private String secretCode;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "account_id", insertable = false, updatable = false, nullable = false)
    private UserAccountEntity account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProviderKey() {
        return providerKey;
    }

    public void setProviderKey(String providerKey) {
        this.providerKey = providerKey;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public UserAccountEntity getAccount() {
        return account;
    }

    public void setAccount(UserAccountEntity account) {
        this.account = account;
    }
}
