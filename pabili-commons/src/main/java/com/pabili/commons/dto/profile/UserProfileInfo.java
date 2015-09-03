package com.pabili.commons.dto.profile;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
public class UserProfileInfo {

    private UserInfo user;
    private String email;
    private BuyerProfileInfo buyerProfile;
    private GopherProfileInfo gopherProfile;

    public UserInfo getUser() {
        return user;
    }
    public void setUser(UserInfo user) {
        this.user = user;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public BuyerProfileInfo getBuyerProfile() {
        return buyerProfile;
    }
    public void setBuyerProfile(BuyerProfileInfo buyerProfile) {
        this.buyerProfile = buyerProfile;
    }
    public GopherProfileInfo getGopherProfile() {
        return gopherProfile;
    }
    public void setGopherProfile(GopherProfileInfo gopherProfile) {
        this.gopherProfile = gopherProfile;
    }

}
