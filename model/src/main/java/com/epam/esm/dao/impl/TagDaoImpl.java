package com.epam.esm.dao.impl;

import com.epam.esm.dao.AbstractDao;
import com.epam.esm.dao.TagDao;
import com.epam.esm.dao.creator.QueryCreator;
import com.epam.esm.dao.mapper.TagRowMapper;
import com.epam.esm.entity.Tag;
import com.epam.esm.exceptions.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.epam.esm.exceptions.ExceptionDaoMessageCodes.NO_ENTITY_WITH_NAME;
import static com.epam.esm.exceptions.ExceptionDaoMessageCodes.SAVING_ERROR;

/**
 * Class {@code TagDaoImpl} is implementation of interface {@link TagDao} and intended to work with 'tags' table.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Repository
public class TagDaoImpl extends AbstractDao<Tag> implements TagDao {
    private static final String TABLE_NAME = "tags";

    private static final String GET_BY_NAME_QUERY = "SELECT * FROM tags WHERE tag_name=?";
    private static final String INSERT_QUERY = "INSERT INTO tags(tag_name) values(?)";

    @Autowired
    public TagDaoImpl(JdbcTemplate jdbcTemplate, TagRowMapper tagRowMapper, QueryCreator queryCreator) {
        super(jdbcTemplate, tagRowMapper, queryCreator);
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected String getSelectJoiner() {
        return "";
    }

    @Override
    public List<Tag> getByName(String name) throws DaoException {
        try {
            return executeQuery(GET_BY_NAME_QUERY, name);
        } catch (DataAccessException e) {
            throw new DaoException(NO_ENTITY_WITH_NAME);
        }
    }

    @Override
    public void insert(Tag item) throws DaoException {
        try {
            executeUpdateQuery(INSERT_QUERY, item.getName());
        } catch (DataAccessException e) {
            throw new DaoException(SAVING_ERROR);
        }
    }
}
