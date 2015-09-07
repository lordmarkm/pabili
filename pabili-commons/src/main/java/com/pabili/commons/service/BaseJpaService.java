package com.pabili.commons.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author mbmartinez
 * @param <E> the entity
 */
@NoRepositoryBean
public interface BaseJpaService<E> extends JpaRepository<E, Long>, QueryDslPredicateExecutor<E> {

}
