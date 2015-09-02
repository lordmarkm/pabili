package com.pabili.core.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.core.style.ToStringCreator;

import com.pabili.core.model.base.BaseEntity;

@Entity(name = "user")
public class User extends BaseEntity {

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "auth", nullable = false)
    private String authorities;

    @Override
    public String toString() {
        return new ToStringCreator(this)
        .append("id", id)
        .append("username", username)
        .append("authorities", authorities)
        .append("password", "[PROTECTED]")
        .toString();
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
    public String getAuthorities() {
        return authorities;
    }
    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

}
