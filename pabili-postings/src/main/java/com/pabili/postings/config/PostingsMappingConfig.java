package com.pabili.postings.config;

import static org.dozer.loader.api.FieldsMappingOptions.oneWay;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.pabili.commons.dto.posting.PostingInfo;
import com.pabili.postings.dto.BuyRequestHeaderInfo;
import com.pabili.postings.dto.BuyRequestInfo;
import com.pabili.postings.model.BuyRequest;
import com.pabili.postings.model.BuyRequestHeader;
import com.pabili.postings.model.Posting;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
@Configuration
public class PostingsMappingConfig {

    @Autowired
    private DozerBeanMapper mapper;

    @PostConstruct
    public void init() {
        mapper.addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(Posting.class, PostingInfo.class)
                    .fields("name", "title")
                    .fields("location", "location", oneWay())
                    .fields("owner.user.username", "owner", oneWay());

                mapping(BuyRequestHeader.class, BuyRequestHeaderInfo.class)
                    .fields("creator.user.username", "creator")
                    .fields("buyRequests", "buyRequests", oneWay());
//                mapping(BuyRequest.class, BuyRequestInfo.class)
//                    .fields("posting", "posting", oneWay());
            }
        });
    }

}
