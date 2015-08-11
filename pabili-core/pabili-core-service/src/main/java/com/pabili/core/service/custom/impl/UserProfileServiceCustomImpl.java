package com.pabili.core.service.custom.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pabili.commons.dto.EmailRegistrationForm;
import com.pabili.commons.operations.OperationResult;
import com.pabili.core.model.user.RegistrationToken;
import com.pabili.core.service.RegistrationTokenService;
import com.pabili.core.service.UserProfileService;
import static com.pabili.commons.operations.OperationResult.*;

@Transactional
public class UserProfileServiceCustomImpl {

    @Autowired
    private UserProfileService service;

    @Autowired
    private RegistrationTokenService registrationTokenService;

    public OperationResult register(EmailRegistrationForm registrationForm) {
        String email = registrationForm.getEmail();
        if (null != service.findByEmail(email)) {
            return DUPLICATE;
        }

        RegistrationToken registrationToken = registrationTokenService.findByEmail(email);
        if (null != registrationToken) {
            registrationToken.setToken(generateToken());
        } else {
            registrationToken = new RegistrationToken();
            registrationToken.setEmail(email);
            registrationToken.setToken(generateToken());
            registrationTokenService.save(registrationToken);
        }

        return SUCCESS;
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }
}
