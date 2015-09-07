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
import com.pabili.commons.dto.posting.PostingInfo;
import com.pabili.commons.web.GenericController;
import com.pabili.postings.service.PostingService;

@RestController
@RequestMapping("/posting")
public class PostingsResource extends GenericController {

    private static Logger LOG = LoggerFactory.getLogger(PostingsResource.class);

    @Autowired
    private PostingService service;

    @RequestMapping(method = GET, params = "postingId")
    public ResponseEntity<PostingInfo> getPostingById(@RequestParam Long postingId) {
        PostingInfo postingInfo = service.findInfo(postingId);
        LOG.info("Request posting view. postingInfo={}", postingInfo);
        return new ResponseEntity<PostingInfo>(postingInfo, OK);
    }

    @RequestMapping(method = GET)
    public ResponseEntity<PageInfo<PostingInfo>> postings(
            Principal principal,
            @RequestParam(required = false) String username,
            Pageable page) {

        PageInfo<PostingInfo> results = null;
        //Own posts
        if (null == username && null != principal) {
            LOG.info("Finding own posts. user={}, page={}", principal.getName(), page);
            results = service.findByOwner(principal.getName(), page);
        } else if (null != username) {
            LOG.info("Finding user posts. user={}, page={}", name(principal), page);
            results = service.findByOwner(username, page);
        }
        return new ResponseEntity<>(results, OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<PostingInfo> save(Principal principal, @RequestBody PostingInfo posting) {
        LOG.info("Posting save reques. posting={}", posting);
        return new ResponseEntity<>(service.saveInfo(principal.getName(), posting), OK);
    }
}
