package com.pabili.postings.service;

import java.util.List;

import com.pabili.commons.service.BaseJpaService;
import com.pabili.postings.model.Proposal;
import com.pabili.postings.service.custom.ProposalServiceCustom;

/**
 * @author Mark Martinez, created Sep 28, 2015
 */
public interface ProposalService  extends ProposalServiceCustom, BaseJpaService<Proposal> {

    List<Proposal> findByGopher_User_UsernameAndBuyRequestHeader_Id(String gopherUsername, Long buyRequestHeaderId);

}
