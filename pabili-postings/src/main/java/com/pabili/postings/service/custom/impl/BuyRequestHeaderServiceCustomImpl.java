package com.pabili.postings.service.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.pabili.commons.dto.PageInfo;
import com.pabili.commons.service.BaseJpaCustomServiceImpl;
import com.pabili.core.model.user.UserProfile;
import com.pabili.core.service.UserProfileService;
import com.pabili.postings.dto.BuyRequestHeaderInfo;
import com.pabili.postings.dto.BuyRequestInfo;
import com.pabili.postings.model.BuyRequest;
import com.pabili.postings.model.BuyRequestHeader;
import com.pabili.postings.service.BuyRequestHeaderService;
import com.pabili.postings.service.BuyRequestMessageService;
import com.pabili.postings.service.custom.BuyRequestHeaderServiceCustom;

@Transactional
public class BuyRequestHeaderServiceCustomImpl 
    extends BaseJpaCustomServiceImpl<BuyRequestHeader, BuyRequestHeaderInfo, BuyRequestHeaderService>
    implements BuyRequestHeaderServiceCustom {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private BuyRequestMessageService buyRequestMessageService;

    @Override
    public BuyRequestHeaderInfo findInfo(Long id) {
        BuyRequestHeaderInfo buyRequestHeaderInfo = super.findInfo(id);
        buyRequestMessageService.addConversations(buyRequestHeaderInfo);
        return buyRequestHeaderInfo;
    }

    @Override
    public BuyRequestHeaderInfo saveInfo(String name, BuyRequestHeaderInfo buyRequestHeaderInfo) {
        BuyRequestHeader buyRequestHeader = toEntity(buyRequestHeaderInfo);

        //Manually map buy request creator
        UserProfile creator = userProfileService.findByUserUsername(name);
        buyRequestHeader.setCreator(creator);

        //Manually map buyrequests
        List<BuyRequest> buyRequests = Lists.newArrayList();
        for (BuyRequestInfo buyRequestInfo : buyRequestHeaderInfo.getBuyRequests()) {
            BuyRequest buyRequest = mapper.map(buyRequestInfo, BuyRequest.class);
            buyRequest.setBuyRequestHeader(buyRequestHeader);
            buyRequests.add(buyRequest);
        }
        buyRequestHeader.setBuyRequests(buyRequests);

        return toDto(service.save(buyRequestHeader));
    }

    @Override
    public PageInfo<BuyRequestHeaderInfo> findByCreator(String username,
            Pageable page) {
        Page<BuyRequestHeader> results = service.findByCreator_User_Username(username, page);
        List<BuyRequestHeaderInfo> resultsInfo = toDto(results.getContent());
        for (BuyRequestHeaderInfo buyRequestHeaderInfo : resultsInfo) {
            buyRequestMessageService.addConversations(buyRequestHeaderInfo);
        }
        return PageInfo.toPageInfo(results, resultsInfo);
    }

}
