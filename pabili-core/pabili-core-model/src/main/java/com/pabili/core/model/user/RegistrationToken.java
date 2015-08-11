package com.pabili.core.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.pabili.core.model.base.BaseEntity;

@Entity(name = "reg_token")
public class RegistrationToken extends BaseEntity {

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "token", nullable = false)
    private String token;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
