package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.exceptions.DaoException;
import com.epam.esm.exceptions.IncorrectParameterException;
import com.epam.esm.validator.IdentifiableValidator;

/**
 * Interface {@code CRUDService} describes CRUD operations for working with objects.
 *
 * @param <T> the type parameter
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface CRUDService<T> extends CRDService<T> {

    /**
     * Method for updating an entity.
     *
     * @param id     ID of entity to update
     * @param entity entity, which include information to update
     * @throws DaoException                an exception thrown by method
     *                                     {@link com.epam.esm.dao.GiftCertificateDao#update(Object)}
     * @throws IncorrectParameterException an exception thrown by method
     *                                     {@link IdentifiableValidator#validateId(long)} )}
     *                                     or {@link com.epam.esm.validator.GiftCertificateValidator#validateForUpdate(GiftCertificate)}
     */
    void update(long id, T entity) throws DaoException, IncorrectParameterException;
}
