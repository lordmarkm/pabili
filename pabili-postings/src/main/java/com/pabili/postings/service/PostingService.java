package com.pabili.postings.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pabili.commons.service.BaseJpaService;
import com.pabili.postings.model.Posting;
import com.pabili.postings.service.custom.PostingServiceCustom;

public interface PostingService extends BaseJpaService<Posting>, PostingServiceCustom {

    Page<Posting> findByOwner_User_Username(String username, Pageable page);

}
