package com.pabili.postings.service.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.pabili.commons.service.BaseJpaCustomServiceImpl;
import com.pabili.core.service.UserProfileService;
import com.pabili.postings.dto.ProposalInfo;
import com.pabili.postings.model.Proposal;
import com.pabili.postings.service.ProposalService;
import com.pabili.postings.service.custom.ProposalServiceCustom;

/**
 * @author Mark Martinez, created Sep 28, 2015
 */
public class ProposalServiceCustomImpl extends BaseJpaCustomServiceImpl<Proposal, ProposalInfo, ProposalService> implements ProposalServiceCustom {

    @Autowired
    private UserProfileService userProfileService;

    @Override
    public ProposalInfo saveInfo(String gopherUsername, ProposalInfo proposal) {
        proposal.setGopher(userProfileService.findInfoByUsername(gopherUsername));
        return super.saveInfo(proposal);
    }

}
