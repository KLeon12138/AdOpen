package com.leon.adopen.common.jpa;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * @author leon
 * @date 2021-12-03 17:21
 */
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {
    private Class<T> domainClass;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager em) {
        super(entityInformation, em);
    }

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.domainClass = domainClass;
    }

    @Override
    public boolean support(String modelType) {
        return this.domainClass.getName().equals(modelType);
    }
}
