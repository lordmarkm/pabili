package com.pabili.commons.service;

/**
 * @author Mark Martinez, created Sep 7, 2015
 */
public interface BaseCustomService<E, D> {

    D findInfo(Long id);
    D saveInfo(D dto);

    E saveInfoGetEntity(D dto);

}
