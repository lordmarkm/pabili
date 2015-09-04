package com.pabili.profile.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pabili.commons.dto.profile.UserProfileInfo;
import com.pabili.commons.web.GenericController;
import com.pabili.core.service.UserProfileService;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
@RestController
@RequestMapping("/profile")
public class ProfileResource extends GenericController {

    private static final Logger LOG = LoggerFactory.getLogger(ProfileResource.class);

    @Autowired
    private UserProfileService userProfileService;

    @RequestMapping(method = GET)
    public ResponseEntity<UserProfileInfo> getProfile(Principal principal) {
        UserProfileInfo userProfile = null;
        if (null != principal) {
            userProfile = userProfileService.findInfoByUsername(principal.getName());
        }
        return new ResponseEntity<>(userProfile, OK);
    }

    @RequestMapping(value = "/{username}", method = GET)
    public ResponseEntity<UserProfileInfo> getPublicProfile(Principal principal, @PathVariable String username) {
        LOG.info("User profile request. user={}, requested profile={}", name(principal), username);
        UserProfileInfo userProfile = userProfileService.getPublicProfileByUsername(username);
        return new ResponseEntity<>(userProfile, OK);
    }
}
