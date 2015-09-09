package com.pabili.profile.resource;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pabili.commons.dto.profile.BuyerProfileInfo;
import com.pabili.commons.web.GenericController;
import com.pabili.core.service.UserProfileService;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

/**
 * @author Mark Martinez, create Sep 9, 2015
 */
@RestController
@RequestMapping("/buyerprofile")
public class BuyerProfileResource extends GenericController {

    private static Logger LOG = LoggerFactory.getLogger(BuyerProfileResource.class);

    @Autowired
    private UserProfileService service;

    @RequestMapping(method = POST)
    public ResponseEntity<BuyerProfileInfo> saveBuyerProfile(Principal principal, @RequestBody BuyerProfileInfo buyerProfileInfo) {

        LOG.debug("Buyer profile update request. user={}, buyerProfile={}", name(principal), buyerProfileInfo);
        return new ResponseEntity<>(service.updateBuyerProfile(name(principal), buyerProfileInfo), OK);

    }

}
