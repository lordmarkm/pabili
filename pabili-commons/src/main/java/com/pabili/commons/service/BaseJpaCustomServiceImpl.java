package com.pabili.commons.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Mark Martinez, created Sep 4, 2015
 *
 * @param <D> DTO
 * @param <E> Entity
 */
@NoRepositoryBean
@Transactional
public abstract class BaseJpaCustomServiceImpl<E, D, R extends BaseJpaService<E>> extends MappingService<E, D> {

    @Autowired
    protected R service;

    public D findInfo(Long id) {
        return toDto(service.findOne(id));
    }
    public List<D> findInfo(Long... ids) {
        return toDto(service.findAll(Arrays.asList(ids)));
    }
    public D saveInfo(D dto) {
        return toDto(service.save(toEntity(dto)));
    }
    public E saveInfoGetEntity(D dto) {
        return service.save(toEntity(dto));
    }

}
