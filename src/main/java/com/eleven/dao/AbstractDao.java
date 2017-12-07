package com.eleven.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by User on 2017/11/16.
 */
public abstract class AbstractDao<PK extends Serializable,T> {
    private final Class<T> persistentClass;

    public AbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory  sessionFactoryBean;

    protected Session getSession() {
        return sessionFactoryBean.getCurrentSession();
    }

    public  T getByKey(PK key){
        return (T)getSession().get(persistentClass,key);
    }

    public void persist(T entity) {
        getSession().persist(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public void updateEntity(T entity) {
        getSession().update(entity);
    }

    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
}
