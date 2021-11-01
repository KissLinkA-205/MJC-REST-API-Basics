package com.epam.esm.logic.creator;

import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * Interface {@code Creator} describes abstract behavior for creating objects.
 *
 * @param <T> the type parameter
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface Creator<T> {

    /**
     * Method for getting an entity object from request parameters.
     *
     * @param requestParams request parameters
     * @return Entity object from request parameters
     */
    T createObject(MultiValueMap<String, String> requestParams);

    /**
     * Method for getting a List of objects from request parameters.
     *
     * @param requestParams request parameters
     * @return List of objects from request parameters
     */
    List<T> createList(MultiValueMap<String, String> requestParams);
}
