package com.epam.esm.controllers;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import com.epam.esm.exceptions.DaoException;
import com.epam.esm.exceptions.IncorrectParameterException;
import com.epam.esm.service.GiftCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class {@code GiftCertificateController} is an endpoint of the API
 * which allows to perform CRUD operations on gift certificates.
 * Annotated by {@link RestController} with no parameters to provide an answer in application/json.
 * Annotated by {@link RequestMapping} with parameter value = "/certificates".
 * So that {@code GiftCertificateController} is accessed by sending request to /certificates.
 *
 * @author Anzhalika Dziarkach
 * @since 1.0
 */
@RestController
@RequestMapping("/certificates")
public class GiftCertificateController {
    private final GiftCertificateService giftCertificateService;

    @Autowired
    public GiftCertificateController(GiftCertificateService giftCertificateService) {
        this.giftCertificateService = giftCertificateService;
    }

    /**
     * Method for getting all gift certificates from data source.
     *
     * @return List of found gift certificates
     * @throws DaoException an exception thrown in case gift certificates not found
     */
    @GetMapping
    public List<GiftCertificate> allGiftCertificates() throws DaoException {
        return giftCertificateService.getAll();
    }

    /**
     * Method for getting gift certificate by ID.
     *
     * @param id ID of gift certificate to get
     * @return Found gift certificate entity
     * @throws DaoException                an exception thrown in case gift certificate with such ID not found
     * @throws IncorrectParameterException an exception thrown in case of invalid ID
     */
    @GetMapping("/{id}")
    public GiftCertificate giftCertificateById(@PathVariable long id) throws DaoException, IncorrectParameterException {
        return giftCertificateService.getById(id);
    }

    /**
     * Method for removing gift certificate by ID.
     *
     * @param id ID of gift certificate to remove
     * @return NO_CONTENT HttpStatus
     * @throws DaoException                an exception thrown in case gift certificate with such ID not found
     * @throws IncorrectParameterException an exception thrown in case of invalid ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteGiftCertificate(@PathVariable long id) throws DaoException, IncorrectParameterException {
        giftCertificateService.removeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Success");
    }

    /**
     * Method for saving new gift certificate.
     *
     * @param giftCertificate gift certificate for saving
     * @return CREATED HttpStatus
     * @throws DaoException                the exception thrown in case of saving error
     * @throws IncorrectParameterException an exception thrown in case of invalid gift certificate information
     */
    @PostMapping
    public ResponseEntity createGiftCertificate(@RequestBody GiftCertificate giftCertificate)
            throws DaoException, IncorrectParameterException {
        giftCertificateService.insert(giftCertificate);
        return ResponseEntity.status(HttpStatus.CREATED).body("Success");
    }

    /**
     * Method for getting list of tags by gift certificate ID.
     *
     * @param id ID of gift certificate
     * @return List of found tags
     * @throws DaoException                an exception thrown in case tags not found
     * @throws IncorrectParameterException an exception thrown in case of invalid ID
     */
    @GetMapping("/{id}/tags")
    public List<Tag> getAssociatedTags(@PathVariable long id) throws DaoException, IncorrectParameterException {
        return giftCertificateService.getAssociatedTags(id);
    }

    /**
     * Method for adding new tags to the gift certificate.
     *
     * @param tags tags to add
     * @param id   ID of gift certificate
     * @return CREATED HttpStatus
     * @throws DaoException                the exception thrown in case of saving error
     * @throws IncorrectParameterException an exception thrown in case of invalid ID
     */
    @PostMapping("/{id}/tags")
    public ResponseEntity addAssociatedTags(@RequestBody List<Tag> tags,
                                            @PathVariable long id) throws DaoException, IncorrectParameterException {
        giftCertificateService.addAssociatedTags(id, tags);
        return ResponseEntity.status(HttpStatus.CREATED).body("Success");
    }

    /**
     * Method for removing tags from the gift certificate.
     *
     * @param tags tags to delete
     * @param id   ID of gift certificate
     * @return NO_CONTENT HttpStatus
     * @throws DaoException                the exception thrown in case of deleting error
     * @throws IncorrectParameterException an exception thrown in case of invalid ID
     */
    @DeleteMapping("/{id}/tags")
    public ResponseEntity deleteAssociatedTags(@RequestBody List<Tag> tags,
                                               @PathVariable long id) throws DaoException, IncorrectParameterException {
        giftCertificateService.deleteAssociatedTags(id, tags);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Success");
    }

    /**
     * Method for updating tags from the gift certificate.
     *
     * @param giftCertificate gift certificate entity, which include information to update
     * @param id              ID of gift certificate
     * @return CREATED HttpStatus
     * @throws DaoException                the exception thrown in case of updating error
     * @throws IncorrectParameterException an exception thrown in case of invalid gift certificate information
     */
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateGiftCertificate(@PathVariable long id,
                                                        @RequestBody GiftCertificate giftCertificate) throws DaoException, IncorrectParameterException {
        giftCertificateService.update(id, giftCertificate);
        return ResponseEntity.status(HttpStatus.CREATED).body("Success");
    }

    /**
     * Method for getting list of gift certificates from data source by special filter.
     *
     * @param allRequestParams request parameters, which include the information needed for the search
     * @return List of found gift certificates
     * @throws DaoException an exception thrown in case gift certificates not found
     */
    @GetMapping("/filter")
    public List<GiftCertificate> giftCertificatesByParameter(@RequestParam MultiValueMap<String, String> allRequestParams) throws DaoException {
        return giftCertificateService.doFilter(allRequestParams);
    }
}
