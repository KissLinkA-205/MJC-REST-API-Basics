package com.epam.esm.dao;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import com.epam.esm.exceptions.DaoException;

import java.util.List;

/**
 * Interface {@code GiftCertificateDao} describes abstract behavior for working with gift_certificates table in database.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface GiftCertificateDao extends CRUDDao<GiftCertificate> {

    /**
     * Method for adding a list of tags by gift certificate ID to database.
     *
     * @param certificateId ID of gift certificate to update
     * @param tags          List of tags to add
     * @throws DaoException the exception thrown in case of saving error
     */
    void addTagsAssociation(long certificateId, List<Tag> tags) throws DaoException;

    /**
     * Method for deleting a list of tags by gift certificate ID from database.
     *
     * @param certificateId ID of gift certificate to update
     * @param tags          List of tags to delete
     * @throws DaoException the exception thrown in case of deleting error
     */
    void deleteTagsAssociation(long certificateId, List<Tag> tags) throws DaoException;

    /**
     * Method for getting a list of tags by gift certificate ID from database.
     *
     * @param certificateId ID of gift certificate
     * @return List of tags from gift certificate
     * @throws DaoException an exception thrown in case tags not found
     */
    List<Tag> getAssociatedTags(long certificateId) throws DaoException;
}
