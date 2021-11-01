package com.epam.esm.logic.creator.impl;

import com.epam.esm.entity.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

import static com.epam.esm.entity.TagColumns.TAG_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TagCreatorTest {
    private static final TagCreator creator = new TagCreator();
    private static final String EXPECTED_TAG_NAME = "tagName";

    @Test
    public void testCreateObject() {
        MultiValueMap<String, String> fields = new LinkedMultiValueMap<>();
        fields.add(TAG_NAME, EXPECTED_TAG_NAME);
        Tag actual = creator.createObject(fields);

        Tag expected = new Tag(EXPECTED_TAG_NAME);
        assertEquals(expected, actual);
    }

    @Test
    public void testCreateList() {
        MultiValueMap<String, String> fields = new LinkedMultiValueMap<>();
        fields.add(TAG_NAME, EXPECTED_TAG_NAME);
        fields.add(TAG_NAME, EXPECTED_TAG_NAME);
        List<Tag> actual = creator.createList(fields);

        List<Tag> expected = new ArrayList<>();
        Tag tag = new Tag(EXPECTED_TAG_NAME);
        expected.add(tag);
        expected.add(tag);
        assertEquals(actual, expected);
    }
}