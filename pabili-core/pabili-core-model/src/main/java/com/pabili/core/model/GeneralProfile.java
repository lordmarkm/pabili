package com.pabili.core.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.pabili.core.model.base.BaseEntity;

@Entity(name = "general_profile")
public class GeneralProfile extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "email", nullable = false)
    private String email_address;

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

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
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

}
