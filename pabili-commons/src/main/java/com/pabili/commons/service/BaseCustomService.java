package com.pabili.commons.service;

import java.util.List;

/**
 * @author Mark Martinez, created Sep 7, 2015
 */
public interface BaseCustomService<E, D> {

    D findInfo(Long id);
    List<D> findInfo(Long... ids);
    D saveInfo(D dto);

    E saveInfoGetEntity(D dto);

}
