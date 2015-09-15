package com.pabili.postings.service.custom;

import java.util.List;

import com.pabili.commons.service.BaseCustomService;
import com.pabili.postings.dto.BuyRequestHeaderInfo;
import com.pabili.postings.dto.BuyRequestMessageInfo;
import com.pabili.postings.model.BuyRequestMessage;

/**
 * @author Mark Martinez, create Sep 14, 2015
 */
public interface BuyRequestMessageServiceCustom 
    extends BaseCustomService<BuyRequestMessage, BuyRequestMessageInfo> {

    BuyRequestMessageInfo saveInfo(Long buyRequestHeaderId, String senderUsername,
            BuyRequestMessageInfo buyRequestMessageInfo);

    List<BuyRequestMessageInfo> findInfoByConversation(Long buyRequestHeaderId, String gopherUsername);
    void addConversations(BuyRequestHeaderInfo buyRequestHeaderInfo);

}
