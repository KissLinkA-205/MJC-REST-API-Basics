package com.epam.esm.controllers;

import com.epam.esm.entity.Tag;
import com.epam.esm.exceptions.DaoException;
import com.epam.esm.exceptions.IncorrectParameterException;
import com.epam.esm.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class {@code TagController} is an endpoint of the API which allows to perform CRD operations on tags.
 * Annotated by {@link RestController} with no parameters to provide an answer in application/json.
 * Annotated by {@link RequestMapping} with parameter value = "/tags".
 * So that {@code TagController} is accessed by sending request to /tags.
 *
 * @author Anzhalika Dziarkach
 * @since 1.0
 */
@RestController
@RequestMapping("/tags")
public class TagController {
    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    /**
     * Method for getting all tags from data source.
     *
     * @return List of found tags
     * @throws DaoException an exception thrown in case tags not found
     */
    @GetMapping
    public List<Tag> allTags() throws DaoException {
        return tagService.getAll();
    }

    /**
     * Method for getting tag by ID.
     *
     * @param id ID of tag to get
     * @return Found tag entity
     * @throws DaoException                an exception thrown in case tag with such ID not found
     * @throws IncorrectParameterException an exception thrown in case of invalid ID
     */
    @GetMapping("/{id}")
    public Tag tagById(@PathVariable long id) throws DaoException, IncorrectParameterException {
        return tagService.getById(id);
    }

    /**
     * Method for removing tag by ID.
     *
     * @param id ID of tag to remove
     * @return NO_CONTENT HttpStatus
     * @throws DaoException                an exception thrown in case tag with such ID not found
     * @throws IncorrectParameterException an exception thrown in case of invalid ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTag(@PathVariable long id) throws DaoException, IncorrectParameterException {
        tagService.removeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Success");
    }

    /**
     * Method for saving new tag.
     *
     * @param tag tag for saving
     * @return CREATED HttpStatus
     * @throws DaoException                the exception thrown in case of saving error
     * @throws IncorrectParameterException an exception thrown in case of invalid tag name
     */
    @PostMapping
    public ResponseEntity createTag(@RequestBody Tag tag) throws DaoException, IncorrectParameterException {
        tagService.insert(tag);
        return ResponseEntity.status(HttpStatus.CREATED).body("Success");
    }

    /**
     * Method for getting list of tags from data source by special filter.
     *
     * @param allRequestParams request parameters, which include the information needed for the search
     * @return List of found tags
     * @throws DaoException an exception thrown in case tags not found
     */
    @GetMapping("/filter")
    public List<Tag> tagsByParameter(@RequestParam MultiValueMap<String, String> allRequestParams) throws DaoException {
        return tagService.doFilter(allRequestParams);
    }
}
