package com.epam.esm.dao.impl;


import com.epam.esm.dao.config.MySqlDataBaseTestConfig;
import com.epam.esm.entity.Tag;
import com.epam.esm.exceptions.DaoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ContextConfiguration(classes = MySqlDataBaseTestConfig.class)
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class TagDaoImplTest {

    @Autowired
    private TagDaoImpl tagDao;

    private static final Tag TAG_1 = new Tag(1, "tagName1");
    private static final Tag TAG_2 = new Tag(2, "tagName3");
    private static final Tag TAG_3 = new Tag(3, "tagName5");
    private static final Tag TAG_4 = new Tag(4, "tagName4");
    private static final Tag TAG_5 = new Tag(5, "tagName2");

    private static final String SORT_PARAMETER = "ASC";

    @Test
    public void testGetAll() throws DaoException {
        List<Tag> actual = tagDao.getAll();
        List<Tag> expected = Arrays.asList(TAG_1, TAG_2, TAG_3, TAG_4, TAG_5);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetById() throws DaoException {
        Tag actual = tagDao.getById(TAG_3.getId());
        Tag expected = TAG_3;

        assertEquals(expected, actual);
    }

    @Test
    public void testGetByName() throws DaoException {
        List<Tag> actual = tagDao.getByName(TAG_2.getName());
        List<Tag> expected = Collections.singletonList(TAG_2);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetWithFilters() throws DaoException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("partOfTagName", null);
        parameters.put("tag_name", null);
        parameters.put("sortByTagName", SORT_PARAMETER);
        List<Tag> actual = tagDao.getWithFilters(parameters);
        List<Tag> expected = Arrays.asList(TAG_1, TAG_5, TAG_2, TAG_4, TAG_3);

        assertEquals(expected, actual);
    }
}