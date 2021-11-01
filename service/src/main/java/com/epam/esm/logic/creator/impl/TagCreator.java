package com.epam.esm.logic.creator.impl;

import com.epam.esm.entity.Tag;
import com.epam.esm.logic.creator.Creator;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

import static com.epam.esm.entity.TagColumns.TAG_NAME;

/**
 * Class {@code TagCreator} is implementation of interface {@link Creator} and intended to work with {@link Tag} objects.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Component
public class TagCreator implements Creator<Tag> {

    @Override
    public Tag createObject(MultiValueMap<String, String> requestParams) {
        String name = requestParams.get(TAG_NAME).get(0);
        return new Tag(name);
    }

    @Override
    public List<Tag> createList(MultiValueMap<String, String> requestParams) {
        List<Tag> tags = new ArrayList<>();
        for (int i = 0; i < requestParams.get(TAG_NAME).size(); i++) {
            String name = requestParams.get(TAG_NAME).get(i);
            tags.add(new Tag(name));
        }
        return tags;
    }
}
