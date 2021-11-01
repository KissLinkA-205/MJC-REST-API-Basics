package com.epam.esm.dao;

import com.epam.esm.exceptions.DaoException;

import java.util.List;
import java.util.Map;

/**
 * Interface {@code CRDDao} describes CRD operations for working with database tables.
 *
 * @param <T> the type parameter
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface CRDDao<T> {

    /**
     * Method for getting an entity object from a table by ID.
     *
     * @param id ID of entity to get
     * @return Entity object from table
     * @throws DaoException an exception thrown in case entity with such ID not found
     */
    T getById(long id) throws DaoException;

    /**
     * Method for getting all entities from a table.
     *
     * @return List of all entities in the table
     * @throws DaoException an exception thrown in case entities not found
     */
    List<T> getAll() throws DaoException;

    /**
     * Method for saving an entity to a table.
     *
     * @param item entity object to save
     * @throws DaoException the exception thrown in case of saving error
     */
    void insert(T item) throws DaoException;

    /**
     * Method for removing an entity from a table by ID.
     *
     * @param id ID of entity to remove
     * @throws DaoException an exception thrown in case entity with such ID not found
     */
    void removeById(long id) throws DaoException;

    /**
     * Method for getting a list of entities by specific parameters.
     *
     * @param fields parameters by which the filter will be performed
     * @return List of entity objects
     * @throws DaoException an exception thrown in case entities not found
     */
    List<T> getWithFilters(Map<String, String> fields) throws DaoException;
}
