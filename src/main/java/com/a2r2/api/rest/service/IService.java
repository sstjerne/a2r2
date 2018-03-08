package com.a2r2.api.rest.service;

import java.io.Serializable;
import java.util.List;


/**
 * CRUD interface
 * 
 * @author sstjerne
 *
 * @param <ID>
 * @param <T>
 */
public interface IService<ID,T extends Serializable> {

    // read - one

    T findOne(ID id);
    
    List<T> findAll();

    // write

    T create(final T entity);

    T update(final ID id,final T entity);

    void delete(final ID id);


}