package com.pabili.postings.resource;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pabili.commons.dto.PageInfo;
import com.pabili.commons.dto.posting.PostingInfo;
import com.pabili.postings.service.PostingService;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/posting")
public class PostingsResource {

    private static Logger LOG = LoggerFactory.getLogger(PostingsResource.class);

    @Autowired
    private PostingService service;

    @RequestMapping(method = GET)
    public ResponseEntity<PageInfo<PostingInfo>> postings(
            Principal principal,
            @RequestParam(required = false) String username,
            Pageable page) {

        PageInfo<PostingInfo> results = null;
        //Own posts
        if (null == username && null != principal) {
            LOG.debug("Finding own posts. user={}, page={}", principal.getName(), page);
            results = service.findByOwner(principal.getName(), page);
        } else if (null != username) {
            LOG.debug("Finding user posts. user={}, page={}", principal.getName(), page);
            results = service.findByOwner(username, page);
        }
        return new ResponseEntity<>(results, OK);
    }

}
