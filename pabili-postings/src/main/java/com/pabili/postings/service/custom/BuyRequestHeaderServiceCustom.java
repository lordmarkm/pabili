package com.pabili.postings.service.custom;

import org.springframework.data.domain.Pageable;

import com.pabili.commons.dto.PageInfo;
import com.pabili.commons.service.BaseCustomService;
import com.pabili.postings.dto.BuyRequestHeaderInfo;
import com.pabili.postings.model.BuyRequestHeader;

/**
 * @author Mark Martinez, create Sep 10, 2015
 */
public interface BuyRequestHeaderServiceCustom extends BaseCustomService<BuyRequestHeader, BuyRequestHeaderInfo> {

    PageInfo<BuyRequestHeaderInfo> findByCreator(String username, Pageable page);
    BuyRequestHeaderInfo saveInfo(String name, BuyRequestHeaderInfo buyRequestHeaderInfo);

}
