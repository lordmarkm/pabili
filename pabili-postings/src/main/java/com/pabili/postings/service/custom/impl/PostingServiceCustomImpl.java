package com.pabili.postings.service.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.google.common.base.Preconditions;
import com.pabili.commons.dto.PageInfo;
import com.pabili.commons.dto.posting.PostingInfo;
import com.pabili.commons.service.BaseJpaCustomServiceImpl;
import com.pabili.core.model.Location;
import com.pabili.core.model.user.UserProfile;
import com.pabili.core.service.LocationService;
import com.pabili.core.service.UserProfileService;
import com.pabili.postings.model.Posting;
import com.pabili.postings.service.PostingService;
import com.pabili.postings.service.custom.PostingServiceCustom;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
public class PostingServiceCustomImpl extends BaseJpaCustomServiceImpl<Posting, PostingInfo, PostingService> implements PostingServiceCustom {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private LocationService locationService;

    @Override
    public PageInfo<PostingInfo> findByOwner(String username, Pageable page) {
        Page<Posting> results = service.findByOwner_User_Username(username, page);
        return PageInfo.toPageInfo(results, toDto(results.getContent()));
    }

    @Override
    public PostingInfo saveInfo(String ownerUsername, PostingInfo postingInfo) {
        Posting posting = toEntity(postingInfo);

        //Manually set location
        Location location = locationService.findByName(postingInfo.getLocation().getName());
        if (null == location) {
            location = locationService.saveInfoGetEntity(postingInfo.getLocation());
        }
        posting.setLocation(location);

        //Manually set owner
        UserProfile owner = userProfileService.findByUserUsername(ownerUsername);
        Preconditions.checkNotNull(owner);
        posting.setOwner(owner);

        return toDto(service.save(posting));
    }

}
