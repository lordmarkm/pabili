package com.pabili.postings.resource;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/gopher", method = GET)
    public ResponseEntity<List<ProposalInfo>> getProposalsByGopher(Principal principal, @RequestParam Long buyRequestHeaderId) {
        LOG.debug("Finding proposals by gopher. gopher={}, buyRequestHeaderId={}", name(principal), buyRequestHeaderId);
        return new ResponseEntity<>(service.findProposalsByGopher(name(principal), buyRequestHeaderId), OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<ProposalInfo> save(Principal principal, @RequestBody ProposalInfo proposal) {
        LOG.info("Proposal received. gopher={}, proposal={}", name(principal), proposal);
        return new ResponseEntity<>(service.saveNewProposalInfo(name(principal), proposal), OK);
    }

}
