package io.github.tiscs.demos.oauth2.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_profiles")
public class UserProfileEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "gender", length = 32)
    private String gender;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "avatar", length = 256)
    private String avatar;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @PrimaryKeyJoinColumn
    private UserAccountEntity account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public UserAccountEntity getAccount() {
        return account;
    }

    public void setAccount(UserAccountEntity account) {
        this.account = account;
    }
}
