package com.pabili.postings.service.custom;

import org.springframework.data.domain.Pageable;

import com.pabili.commons.dto.PageInfo;
import com.pabili.commons.dto.posting.PostingInfo;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
public interface PostingServiceCustom {

    PageInfo<PostingInfo> findByOwner(String username, Pageable page);
    PostingInfo saveInfo(String ownerUsername, PostingInfo postingInfo);

}
