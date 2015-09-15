package com.pabili.postings.resource;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pabili.commons.web.GenericController;
import com.pabili.postings.dto.BuyRequestMessageInfo;
import com.pabili.postings.service.BuyRequestMessageService;

@RestController
@RequestMapping("/buyrequestMessage/{buyRequestHeaderId}")
public class BuyRequestMessageResource extends GenericController {

    private static Logger LOG = LoggerFactory.getLogger(BuyRequestMessageResource.class);

    @Autowired
    private BuyRequestMessageService service;

    @RequestMapping(method = GET, params = "role=gopher")
    public ResponseEntity<List<BuyRequestMessageInfo>> getMessages(Principal principal,
            @PathVariable Long buyRequestHeaderId) {
        return new ResponseEntity<>(service.findInfoByConversation(buyRequestHeaderId, name(principal)), OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<BuyRequestMessageInfo> post(Principal sender,
            @PathVariable Long buyRequestHeaderId,
            @RequestBody BuyRequestMessageInfo buyRequestMessageInfo) {
        LOG.info("BuyRequestMessage save request. msg={}", buyRequestMessageInfo);
        return new ResponseEntity<>(service.saveInfo(buyRequestHeaderId,
                name(sender), buyRequestMessageInfo), OK);
    }

}
