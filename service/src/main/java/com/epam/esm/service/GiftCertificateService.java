package com.epam.esm.service;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import com.epam.esm.exceptions.DaoException;
import com.epam.esm.exceptions.IncorrectParameterException;
import com.epam.esm.validator.IdentifiableValidator;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

/**
 * Interface {@code GiftCertificateService} describes abstract behavior for working with {@link GiftCertificate} objects.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface GiftCertificateService extends CRUDService<GiftCertificate> {

    /**
     * Method for getting a list of tags by gift certificate ID.
     *
     * @param certificateId ID of gift certificate
     * @return List of tags from gift certificate
     * @throws DaoException                an exception thrown by method
     *                                     {@link com.epam.esm.dao.GiftCertificateDao#getAssociatedTags(long)}
     * @throws IncorrectParameterException an exception thrown by method
     *                                     {@link IdentifiableValidator#validateId(long)}
     */
    List<Tag> getAssociatedTags(long certificateId) throws DaoException, IncorrectParameterException;

    /**
     * Method for adding a list of tags.
     *
     * @param id   ID of gift certificate
     * @param tags list of tags to add
     * @throws DaoException                an exception thrown by method
     *                                     {@link com.epam.esm.dao.GiftCertificateDao#addTagsAssociation(long, List)}
     * @throws IncorrectParameterException an exception thrown by method
     *                                     {@link IdentifiableValidator#validateId(long)}
     *                                     or {@link com.epam.esm.validator.GiftCertificateValidator#validateListOfTags(List)}
     */
    void addAssociatedTags(long id, List<Tag> tags) throws DaoException, IncorrectParameterException;

    /**
     * Method for deleting a list of tags.
     *
     * @param id   ID of gift certificate
     * @param tags list of tags to delete
     * @throws DaoException                an exception thrown by method
     *                                     {@link com.epam.esm.dao.GiftCertificateDao#deleteTagsAssociation(long, List)}
     * @throws IncorrectParameterException an exception thrown by method
     *                                     {@link IdentifiableValidator#validateId(long)}
     *                                     or {@link com.epam.esm.validator.GiftCertificateValidator#validateListOfTags(List)}
     */
    void deleteAssociatedTags(long id, List<Tag> tags) throws DaoException, IncorrectParameterException;

    /**
     * Method for getting a list of gift certificates by specific parameters.
     *
     * @param requestParams request parameters from url
     * @return List of gift certificates
     * @throws DaoException an exception thrown by method
     *                      {@link com.epam.esm.dao.GiftCertificateDao#getWithFilters(Map)}
     */
    List<GiftCertificate> doFilter(MultiValueMap<String, String> requestParams) throws DaoException;
}
