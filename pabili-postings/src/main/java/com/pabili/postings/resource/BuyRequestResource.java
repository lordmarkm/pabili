package com.pabili.postings.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pabili.commons.dto.PageInfo;
import com.pabili.commons.web.GenericController;
import com.pabili.postings.dto.BuyRequestHeaderInfo;
import com.pabili.postings.service.BuyRequestHeaderService;

/**
 * @author Mark Martinez, create Sep 10, 2015
 */
@RestController
@RequestMapping("/buyrequest_r")
public class BuyRequestResource extends GenericController {

    private static Logger LOG = LoggerFactory.getLogger(BuyRequestResource.class);

    @Autowired
    private BuyRequestHeaderService service;

    @RequestMapping(method = GET, params = "buyRequestHeaderId")
    public ResponseEntity<BuyRequestHeaderInfo> getById(@RequestParam Long buyRequestHeaderId) {
        LOG.info("Buy request header requested. id={}", buyRequestHeaderId);
        return new ResponseEntity<>(service.findInfo(buyRequestHeaderId), OK);
    }

    @RequestMapping(method = GET)
    public ResponseEntity<PageInfo<BuyRequestHeaderInfo>> buyRequests(
            Principal principal,
            @RequestParam(required = false) String username,
            Pageable page) {

        PageInfo<BuyRequestHeaderInfo> results = null;
        //Own posts
        if (null == username && null != principal) {
            LOG.info("Finding own buy requests. user={}, page={}", principal.getName(), page);
            results = service.findByCreator(principal.getName(), page);
        } else if (null != username) {
            LOG.info("Finding user buy requests. user={}, page={}", name(principal), page);
            results = service.findByCreator(username, page);
        }
        return new ResponseEntity<>(results, OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<BuyRequestHeaderInfo> create(Principal principal, @RequestBody BuyRequestHeaderInfo buyRequestHeaderInfo) {
        LOG.info("Buy request save request. user={}, buyRequest={}", name(principal), buyRequestHeaderInfo);
        return new ResponseEntity<>(service.saveInfo(name(principal), buyRequestHeaderInfo), OK);
    }

}
