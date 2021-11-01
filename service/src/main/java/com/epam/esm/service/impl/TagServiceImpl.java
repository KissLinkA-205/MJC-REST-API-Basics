package com.epam.esm.service.impl;

import com.epam.esm.dao.CRDDao;
import com.epam.esm.dao.TagDao;
import com.epam.esm.entity.Tag;
import com.epam.esm.exceptions.DaoException;
import com.epam.esm.exceptions.IncorrectParameterException;
import com.epam.esm.service.AbstractService;
import com.epam.esm.service.TagService;
import com.epam.esm.validator.TagValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.esm.service.FilterParameters.*;

/**
 * Class {@code TagServiceImpl} is implementation of interface {@link TagService} and intended to work with {@link Tag} objects.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Service
public class TagServiceImpl extends AbstractService<Tag> implements TagService {
    private final TagDao tagDao;

    @Autowired
    public TagServiceImpl(CRDDao<Tag> dao, TagDao tagDao) {
        super(dao);
        this.tagDao = tagDao;
    }

    @Override
    public void insert(Tag tag) throws DaoException, IncorrectParameterException {
        dao.insert(tag);
        TagValidator.validateName(tag.getName());
    }

    @Override
    public List<Tag> doFilter(MultiValueMap<String, String> requestParams) throws DaoException {
        Map<String, String> map = new HashMap<>();
        map.put(TAG_NAME, getSingleRequestParameter(requestParams, TAG_NAME));
        map.put(PART_OF_TAG_NAME, getSingleRequestParameter(requestParams, PART_OF_TAG_NAME));
        map.put(SORT_BY_TAG_NAME, getSingleRequestParameter(requestParams, SORT_BY_TAG_NAME));
        return tagDao.getWithFilters(map);
    }
}
