package com.epam.esm.dao;

import com.epam.esm.exceptions.DaoException;

/**
 * Interface {@code CRUDDao} describes CRUD operations for working with database tables.
 *
 * @param <T> the type parameter
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface CRUDDao<T> extends CRDDao<T> {

    /**
     * Method for updating an entity in a table.
     *
     * @param item entity object to update
     * @throws DaoException the exception thrown in case of updating error
     */
    void update(T item) throws DaoException;
}
