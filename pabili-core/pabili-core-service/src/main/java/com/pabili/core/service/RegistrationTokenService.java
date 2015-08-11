package com.pabili.core.service;

import com.pabili.core.model.user.RegistrationToken;
import com.pabili.core.service.base.BaseJpaService;

public interface RegistrationTokenService extends BaseJpaService<RegistrationToken> {

    public RegistrationToken findByEmail(String email);
    public RegistrationToken findByToken(String token);

}
