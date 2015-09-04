package com.pabili.core.service.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;

import com.pabili.commons.service.MappingService;
import com.pabili.core.service.BaseJpaService;

/**
 * 
 * @author Mark Martinez, created Sep 4, 2015
 *
 * @param <D> DTO
 * @param <E> Entity
 */
@NoRepositoryBean
public abstract class BaseJpaServiceCustomImpl<E, D, R extends BaseJpaService<E>> extends MappingService<E, D> {

    @Autowired
    private R repo;

    public D saveInfo(D dto) {
        return toDto(repo.save(toEntity(dto)));
    }
    public E saveInfoGetEntity(D dto) {
        return repo.save(toEntity(dto));
    }

}
