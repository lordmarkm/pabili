package com.pabili.commons.dto;

public class CompleteRegistrationForm {

    private String registrationToken;
    private String username;
    private String password;

    public String getRegistrationToken() {
        return registrationToken;
    }
    public void setRegistrationToken(String registrationToken) {
        this.registrationToken = registrationToken;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
