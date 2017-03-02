package io.github.tiscs.demos.oauth2.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "user_accounts")
public class UserAccountEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "locked", nullable = false)
    private boolean locked;

    @Column(name = "disabled", nullable = false)
    private boolean disabled;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private UserProfileEntity profile;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private Collection<UserCredentialEntity> credentials = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userAccount")
    private Collection<OAuth2AccountEntity> oAuth2Accounts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public UserProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(UserProfileEntity profile) {
        this.profile = profile;
    }

    public Collection<UserCredentialEntity> getCredentials() {
        return credentials;
    }

    public void setCredentials(Collection<UserCredentialEntity> credentials) {
        this.credentials = credentials;
    }

    public Collection<OAuth2AccountEntity> getoAuth2Accounts() {
        return oAuth2Accounts;
    }

    public void setoAuth2Accounts(Collection<OAuth2AccountEntity> oAuth2Accounts) {
        this.oAuth2Accounts = oAuth2Accounts;
    }
}
