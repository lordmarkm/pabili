package com.pabili.postings.resource;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pabili.commons.web.GenericController;
import com.pabili.postings.dto.ProposalInfo;
import com.pabili.postings.service.ProposalService;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

/**
 * @author Mark Martinez, created Sep 28, 2015
 */
@RestController
@RequestMapping("/proposal")
public class ProposalResource extends GenericController {

    private static Logger LOG = LoggerFactory.getLogger(ProposalResource.class);

    @Autowired
    private ProposalService service;

    @RequestMapping(method = POST)
    public ResponseEntity<ProposalInfo> save(Principal principal, ProposalInfo proposal) {
        LOG.info("Proposal received. gopher={}, proposal={}", name(principal), proposal);
        return new ResponseEntity<>(service.saveInfo(name(principal), proposal), OK);
    }

}
