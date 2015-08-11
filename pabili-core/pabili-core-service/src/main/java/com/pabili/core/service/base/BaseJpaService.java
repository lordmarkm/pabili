package com.pabili.core.service.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * @author mbmartinez
 * @param <E> the entity
 */
public interface BaseJpaService<E> extends JpaRepository<E, Long>, QueryDslPredicateExecutor<E> {

}
