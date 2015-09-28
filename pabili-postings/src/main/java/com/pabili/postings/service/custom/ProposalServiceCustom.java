package com.pabili.postings.service.custom;

import com.pabili.commons.service.BaseCustomService;
import com.pabili.postings.dto.ProposalInfo;
import com.pabili.postings.model.Proposal;

/**
 * @author Mark Martinez, created Sep 28, 2015
 */
public interface ProposalServiceCustom extends BaseCustomService<Proposal, ProposalInfo> {

    ProposalInfo saveInfo(String gopherUsername, ProposalInfo proposal);

}
