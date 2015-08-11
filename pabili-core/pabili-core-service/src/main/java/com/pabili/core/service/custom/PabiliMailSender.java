package com.pabili.core.service.custom;

public interface PabiliMailSender {

    void sendRegistrationToken(String email, String registrationToken);

}
