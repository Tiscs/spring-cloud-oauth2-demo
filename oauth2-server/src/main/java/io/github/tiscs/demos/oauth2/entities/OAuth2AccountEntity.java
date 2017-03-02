package io.github.tiscs.demos.oauth2.entities;

import javax.persistence.*;

@Entity
@IdClass(OAuth2AccountId.class)
@Table(name = "oauth2_accounts")
public class OAuth2AccountEntity {
    @Id
    @Column(name = "oauth2_client_id", length = 32)
    private String oauth2ClientId;

    @Id
    @Column(name = "user_account_id")
    private Long userAccountId;

    @Column(name = "open_id", nullable = false, length = 32)
    private String openId;

    @Column(name = "authorities", length = 256)
    private String authorities;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "oauth2_client_id", insertable = false, updatable = false, nullable = false)
    private OAuth2ClientEntity client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_account_id", insertable = false, updatable = false, nullable = false)
    private UserAccountEntity userAccount;

    public String getOauth2ClientId() {
        return oauth2ClientId;
    }

    public void setOauth2ClientId(String oauth2ClientId) {
        this.oauth2ClientId = oauth2ClientId;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public OAuth2ClientEntity getClient() {
        return client;
    }

    public void setClient(OAuth2ClientEntity client) {
        this.client = client;
    }

    public UserAccountEntity getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccountEntity userAccount) {
        this.userAccount = userAccount;
    }
}
