package com.pabili.postings.service.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pabili.commons.service.BaseJpaCustomServiceImpl;
import com.pabili.core.model.user.QBuyerProfile;
import com.pabili.core.model.user.UserProfile;
import com.pabili.core.service.UserProfileService;
import com.pabili.postings.dto.BuyRequestHeaderInfo;
import com.pabili.postings.dto.BuyRequestMessageInfo;
import com.pabili.postings.model.BuyRequestHeader;
import com.pabili.postings.model.BuyRequestMessage;
import com.pabili.postings.model.QBuyRequestMessage;
import com.pabili.postings.service.BuyRequestHeaderService;
import com.pabili.postings.service.BuyRequestMessageService;
import com.pabili.postings.service.custom.BuyRequestMessageServiceCustom;

/**
 * @author Mark Martinez, create Sep 14, 2015
 */
public class BuyRequestMessageServiceCustomImpl
    extends BaseJpaCustomServiceImpl<BuyRequestMessage, BuyRequestMessageInfo, BuyRequestMessageService>
    implements BuyRequestMessageServiceCustom {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private BuyRequestHeaderService buyRequestHeaderService;

    @Override
    public BuyRequestMessageInfo saveInfo(Long buyRequestHeaderId,
            String senderUsername, BuyRequestMessageInfo buyRequestMessageInfo) {

        BuyRequestMessage buyRequestMessage = toEntity(buyRequestMessageInfo);

        //Set the buy request header
        BuyRequestHeader buyRequestHeader = buyRequestHeaderService.findOne(buyRequestHeaderId);
        buyRequestMessage.setBuyRequestHeader(buyRequestHeader);

        //Set the sender
        UserProfile sender = userProfileService.findByUserUsername(senderUsername);
        buyRequestMessage.setSender(sender);

        //Set the gopher
        UserProfile gopher = userProfileService.findByUserUsername(buyRequestMessageInfo.getGopher());
        buyRequestMessage.setGopher(gopher);

        return toDto(service.save(buyRequestMessage));
    }

    @Override
    public List<BuyRequestMessageInfo> findInfoByConversation(Long buyRequestHeaderId, String gopherUsername) {
        List<BuyRequestMessage> messages = service.findByConversation(buyRequestHeaderId, gopherUsername);
        return toDto(messages);
    }

    @Override
    public void addConversations(BuyRequestHeaderInfo buyRequestHeaderInfo) {
        List<BuyRequestMessage> latestMessages = service.findLatestMessages(buyRequestHeaderInfo.getId());
        buyRequestHeaderInfo.setConversations(toDto(latestMessages));
    }

}
