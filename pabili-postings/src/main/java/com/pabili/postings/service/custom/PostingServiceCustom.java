package com.pabili.postings.service.custom;

import org.springframework.data.domain.Pageable;

import com.pabili.commons.dto.PageInfo;
import com.pabili.commons.dto.posting.PostingInfo;
import com.pabili.commons.service.BaseCustomService;
import com.pabili.postings.model.Posting;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
public interface PostingServiceCustom extends BaseCustomService<Posting, PostingInfo> {

    PageInfo<PostingInfo> findByOwner(String username, Pageable page);
    PostingInfo saveInfo(String ownerUsername, PostingInfo postingInfo);

}
