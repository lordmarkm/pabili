package com.pabili.core.model.user;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.pabili.core.model.base.BaseEntity;

@Entity(name = "user_profile")
public class UserProfile extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "email", nullable = false)
    private String email;

    @Embedded
    private BuyerProfile buyerProfile;

    @Embedded
    private GopherProfile gopherProfile;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BuyerProfile getBuyerProfile() {
        return buyerProfile;
    }

    public void setBuyerProfile(BuyerProfile buyerProfile) {
        this.buyerProfile = buyerProfile;
    }

    public GopherProfile getGopherProfile() {
        return gopherProfile;
    }

    public void setGopherProfile(GopherProfile gopherProfile) {
        this.gopherProfile = gopherProfile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
