package com.epam.esm.service.impl;

import com.epam.esm.dao.impl.TagDaoImpl;
import com.epam.esm.entity.Tag;
import com.epam.esm.exceptions.DaoException;
import com.epam.esm.exceptions.IncorrectParameterException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TagServiceImplTest {

    @Mock
    private TagDaoImpl tagDao = Mockito.mock(TagDaoImpl.class);

    @InjectMocks
    private TagServiceImpl tagService;

    private static final Tag TAG_1 = new Tag(1, "tagName1");
    private static final Tag TAG_2 = new Tag(2, "tagName3");
    private static final Tag TAG_3 = new Tag(3, "tagName5");
    private static final Tag TAG_4 = new Tag(4, "tagName4");
    private static final Tag TAG_5 = new Tag(5, "tagName2");

    private static final String SORT_PARAMETER = "ASC";

    @Test
    public void testGetById() throws DaoException, IncorrectParameterException {
        when(tagDao.getById(TAG_3.getId())).thenReturn(TAG_3);
        Tag actual = tagService.getById(TAG_3.getId());
        Tag expected = TAG_3;

        assertEquals(expected, actual);
    }

    @Test
    public void testGetAll() throws DaoException {
        List<Tag> tags = Arrays.asList(TAG_1, TAG_2, TAG_3, TAG_4, TAG_5);
        when(tagDao.getAll()).thenReturn(tags);
        List<Tag> actual = tagService.getAll();
        List<Tag> expected = tags;

        assertEquals(expected, actual);
    }

    @Test
    public void testDoFilter() throws DaoException {
        List<Tag> tags = Arrays.asList(TAG_1, TAG_5, TAG_2, TAG_4, TAG_3);

        MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("sortByTagName", SORT_PARAMETER);
        Map<String, String> parameters = new HashMap<>();
        parameters.put("partOfTagName", null);
        parameters.put("tag_name", null);
        parameters.put("sortByTagName", SORT_PARAMETER);
        when(tagDao.getWithFilters(parameters)).thenReturn(tags);
        List<Tag> actual = tagService.doFilter(requestParams);
        List<Tag> expected = tags;

        assertEquals(expected, actual);
    }
}