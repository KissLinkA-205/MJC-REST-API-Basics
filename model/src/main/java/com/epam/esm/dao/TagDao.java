package com.epam.esm.dao;

import com.epam.esm.entity.Tag;
import com.epam.esm.exceptions.DaoException;

import java.util.List;

/**
 * Interface {@code TagDao} describes abstract behavior for working with tags table in database.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface TagDao extends CRDDao<Tag> {

    /**
     * Method for getting a list of tags from a table with a specific name.
     *
     * @param name name of tags to get
     * @return List of tags from table
     * @throws DaoException an exception thrown in case entities with such name not found
     */
    List<Tag> getByName(String name) throws DaoException;
}
