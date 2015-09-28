package com.pabili.postings.service.custom;

import java.util.List;

import com.pabili.commons.service.BaseCustomService;
import com.pabili.postings.dto.ProposalInfo;
import com.pabili.postings.model.Proposal;

/**
 * @author Mark Martinez, created Sep 28, 2015
 */
public interface ProposalServiceCustom extends BaseCustomService<Proposal, ProposalInfo> {

    /**
     * Save implementation for brand new proposals
     * @param gopherUsername
     * @param proposal
     * @return
     */
    ProposalInfo saveNewProposalInfo(String gopherUsername, ProposalInfo proposal);
    List<ProposalInfo> findProposalsByGopher(String gopherUsername, Long buyRequestHeaderId);

}
