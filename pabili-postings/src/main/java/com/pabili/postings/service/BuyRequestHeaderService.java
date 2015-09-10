package com.pabili.postings.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pabili.commons.service.BaseJpaService;
import com.pabili.postings.model.BuyRequestHeader;
import com.pabili.postings.service.custom.BuyRequestHeaderServiceCustom;

/**
 * @author Mark Martinez, create Sep 10, 2015
 */
public interface BuyRequestHeaderService extends BaseJpaService<BuyRequestHeader>,
    BuyRequestHeaderServiceCustom {

    Page<BuyRequestHeader> findByCreator_User_Username(String username, Pageable page);

}
