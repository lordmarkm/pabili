package com.pabili.postings.service.custom.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pabili.commons.service.BaseJpaCustomServiceImpl;
import com.pabili.core.service.UserProfileService;
import com.pabili.postings.dto.ProposalInfo;
import com.pabili.postings.model.Proposal;
import com.pabili.postings.service.ProposalService;
import com.pabili.postings.service.custom.ProposalServiceCustom;
import com.pabili.postings.util.ProposalStatus;

/**
 * @author Mark Martinez, created Sep 28, 2015
 */
public class ProposalServiceCustomImpl extends BaseJpaCustomServiceImpl<Proposal, ProposalInfo, ProposalService> implements ProposalServiceCustom {

    @Autowired
    private UserProfileService userProfileService;

    @Override
    public ProposalInfo saveNewProposalInfo(String gopherUsername, ProposalInfo proposal) {
        proposal.setGopher(userProfileService.findInfoByUsername(gopherUsername));
        proposal.setPabiliFee(computePabiliFee(proposal));
        proposal.setStatus(ProposalStatus.NEW);
        return super.saveInfo(proposal);
    }

    private BigDecimal computePabiliFee(ProposalInfo proposal) {
        return proposal.getTotalItemsAmount().multiply(new BigDecimal(0.2d));
    }

    @Override
    public List<ProposalInfo> findProposalsByGopher(String gopherUsername, Long buyRequestHeaderId) {
        List<Proposal> proposals = service.findByGopher_User_UsernameAndBuyRequestHeader_Id(gopherUsername, buyRequestHeaderId);
        return toDto(proposals);
    }

}
