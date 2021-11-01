package com.epam.esm.service;

import com.epam.esm.dao.AbstractDao;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import com.epam.esm.exceptions.DaoException;
import com.epam.esm.exceptions.IncorrectParameterException;
import com.epam.esm.validator.IdentifiableValidator;

import java.util.List;

/**
 * Interface {@code CRDService} describes CRD operations for working with objects.
 *
 * @param <T> the type parameter
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface CRDService<T> {

    /**
     * Method for getting an entity object by ID.
     *
     * @param id ID of entity to get
     * @return Entity object
     * @throws DaoException                an exception thrown by method
     *                                     {@link com.epam.esm.dao.AbstractDao#getById(long)}
     * @throws IncorrectParameterException an exception thrown by method
     *                                     {@link IdentifiableValidator#validateId(long)}
     */
    T getById(long id) throws DaoException, IncorrectParameterException;

    /**
     * Method for getting all entities.
     *
     * @return List of all entities
     * @throws DaoException an exception thrown by method
     *                      {@link AbstractDao#getAll()}
     */
    List<T> getAll() throws DaoException;

    /**
     * Method for saving an entity.
     *
     * @param entity entity to save
     * @throws DaoException                an exception thrown by method
     *                                     {@link com.epam.esm.dao.TagDao#insert(Object)}
     *                                     or {@link com.epam.esm.dao.GiftCertificateDao#insert(Object)}
     * @throws IncorrectParameterException an exception thrown by method
     *                                     {@link com.epam.esm.validator.TagValidator#validate(Tag)}
     *                                     or {@link com.epam.esm.validator.GiftCertificateValidator#validate(GiftCertificate)}
     */
    void insert(T entity) throws DaoException, IncorrectParameterException;

    /**
     * Method for removing an entity by ID.
     *
     * @param id ID of entity to remove
     * @throws DaoException                an exception thrown by method
     *                                     {@link com.epam.esm.dao.AbstractDao#removeById(long)}
     * @throws IncorrectParameterException an exception thrown by method
     *                                     {@link IdentifiableValidator#validateId(long)}
     */
    void removeById(long id) throws DaoException, IncorrectParameterException;
}
