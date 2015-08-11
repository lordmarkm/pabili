package com.pabili.core.service;

import com.pabili.core.model.user.RegistrationToken;

public interface RegistrationTokenService extends BaseJpaService<RegistrationToken> {

    public RegistrationToken findByEmail(String email);
    public RegistrationToken findByToken(String token);

}
