package com.pabili.postings.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.pabili.postings.dto.ShippingChannelInfo;
import com.pabili.postings.util.ShippingChannel;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.http.HttpStatus.*;

/**
 * @author Mark Martinez, created Sep 28, 2015
 */
@RestController
@RequestMapping("/shipping_channel")
public class ShippingChannelResource {

    @RequestMapping(method = GET)
    public ResponseEntity<List<ShippingChannelInfo>> query() {
        List<ShippingChannelInfo> channels = Lists.newArrayList();
        for (ShippingChannel s : ShippingChannel.values()) {
            ShippingChannelInfo sInfo = new ShippingChannelInfo();
            sInfo.setName(s.name());
            sInfo.setCode(s.name());
            channels.add(sInfo);
        }
        return new ResponseEntity<>(channels, OK);
    }

}
