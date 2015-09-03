package com.pabili.core.config;

import static org.dozer.loader.api.FieldsMappingOptions.copyByReference;
import static org.dozer.loader.api.FieldsMappingOptions.oneWay;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pabili.commons.dto.BaseDto;
import com.pabili.core.model.base.BaseEntity;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
@Configuration
public class PabiliMappingConfig {

    @PostConstruct
    public void init() {
        mapper().addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(BaseEntity.class, BaseDto.class)
                    .fields("dateCreated", "dateCreated", copyByReference(), oneWay());
            }
        });
    }

    @Bean
    public DozerBeanMapper mapper() {
        return new DozerBeanMapper();
    }

}
