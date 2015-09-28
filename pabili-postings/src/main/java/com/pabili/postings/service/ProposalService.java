package com.pabili.postings.service;

import com.pabili.commons.service.BaseJpaService;
import com.pabili.postings.model.Proposal;
import com.pabili.postings.service.custom.ProposalServiceCustom;

/**
 * @author Mark Martinez, created Sep 28, 2015
 */
public interface ProposalService  extends ProposalServiceCustom, BaseJpaService<Proposal> {

}
