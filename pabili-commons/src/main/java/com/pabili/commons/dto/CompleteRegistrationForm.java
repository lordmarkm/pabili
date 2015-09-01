package com.pabili.commons.dto;

import org.springframework.core.style.ToStringCreator;

import com.google.common.base.Objects;

public class CompleteRegistrationForm {

    private String password;
    private String confirmPassword;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("pw match?", null != password && Objects.equal(password, confirmPassword) ? "Yes" : "No")
            .toString();
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
