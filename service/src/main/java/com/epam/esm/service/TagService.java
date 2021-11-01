package com.epam.esm.service;

import com.epam.esm.entity.Tag;
import com.epam.esm.exceptions.DaoException;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

/**
 * Interface {@code TagService} describes abstract behavior for working with {@link Tag} objects.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface TagService extends CRDService<Tag> {

    /**
     * Method for getting a list of tags by specific parameters.
     *
     * @param requestParams request parameters from url
     * @return List of tags
     * @throws DaoException an exception thrown by method
     *                      {@link com.epam.esm.dao.TagDao#getWithFilters(Map)}
     */
    List<Tag> doFilter(MultiValueMap<String, String> requestParams) throws DaoException;
}
