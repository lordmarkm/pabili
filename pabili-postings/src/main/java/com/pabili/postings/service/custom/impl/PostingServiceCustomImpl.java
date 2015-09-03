package com.pabili.postings.service.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pabili.commons.dto.PageInfo;
import com.pabili.commons.dto.posting.PostingInfo;
import com.pabili.commons.service.MappingService;
import com.pabili.postings.model.Posting;
import com.pabili.postings.service.PostingService;
import com.pabili.postings.service.custom.PostingServiceCustom;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
public class PostingServiceCustomImpl extends MappingService<Posting, PostingInfo> implements PostingServiceCustom {

    @Autowired
    private PostingService service;

    @Override
    public PageInfo<PostingInfo> findByOwner(String username, Pageable page) {
        Page<Posting> results = service.findByOwner_User_Username(username, page);
        return PageInfo.toPageInfo(results, toDto(results.getContent()));
    }

}
