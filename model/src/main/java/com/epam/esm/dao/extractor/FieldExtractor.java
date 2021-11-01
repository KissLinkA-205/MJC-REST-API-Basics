package com.epam.esm.dao.extractor;

import java.util.Map;

/**
 * Interface {@code FieldExtractor} describes abstract behavior for extracting fields from an object.
 *
 * @param <T> the type parameter
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public interface FieldExtractor<T> {

    /**
     * Method for extracting fields of an object.
     *
     * @param item object, from which to extract the fields
     * @return map of fields, where the map key is the name of field and the map value is the value of field
     */
    Map<String, String> extract(T item);
}
