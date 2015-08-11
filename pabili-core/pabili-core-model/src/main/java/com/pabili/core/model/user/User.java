package com.pabili.core.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.pabili.core.model.base.BaseEntity;

@Entity(name = "user")
public class User extends BaseEntity {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

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
