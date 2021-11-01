package com.epam.esm.dao.impl;

import com.epam.esm.dao.AbstractDao;
import com.epam.esm.dao.GiftCertificateDao;
import com.epam.esm.dao.TagDao;
import com.epam.esm.dao.creator.QueryCreator;
import com.epam.esm.dao.extractor.FieldExtractor;
import com.epam.esm.dao.mapper.GiftCertificateRowMapper;
import com.epam.esm.dao.mapper.TagRowMapper;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import com.epam.esm.exceptions.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.epam.esm.exceptions.ExceptionDaoMessageCodes.*;

/**
 * Class {@code GiftCertificateDaoImpl} is implementation of interface {@link GiftCertificateDao}
 * and intended to work with 'gift_certificates' table.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Repository
public class GiftCertificateDaoImpl extends AbstractDao<GiftCertificate> implements GiftCertificateDao {
    private static final String TABLE_NAME = "gift_certificates";
    private static final String SELECT_JOINER = " gc LEFT JOIN gift_certificates_tags gct ON " +
            "gc.id=gct.gift_certificate_id LEFT JOIN tags t ON gct.tag_id=t.id";

    private final TagRowMapper tagRowMapper;
    private final TagDao tagDao;
    private final FieldExtractor<GiftCertificate> giftCertificateFieldExtractor;

    private static final String INSERT_QUERY = "INSERT INTO gift_certificates(name, description, price, duration, create_date, " +
            "last_update_date) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String ADD_TAGS_ASSOCIATION_QUERY = "INSERT INTO gift_certificates_tags (gift_certificate_id, tag_id) VALUES(?, ?)";
    private static final String GET_ASSOCIATED_TAGS_QUERY = "SELECT * FROM tags t INNER JOIN gift_certificates_tags gct ON " +
            "t.id = gct.tag_id WHERE gct.gift_certificate_id=?";
    private static final String REMOVE_TAGS_ASSOCIATION_QUERY = "DELETE FROM gift_certificates_tags WHERE gift_certificate_id=? AND tag_id=?";
    private static final String ADD_TAGS_QUERY = "INSERT INTO gift_certificates_tags (gift_certificate_id,tag_id) VALUES(?,?)";

    @Autowired
    public GiftCertificateDaoImpl(JdbcTemplate jdbcTemplate, GiftCertificateRowMapper giftCertificateRowMapper,
                                  FieldExtractor<GiftCertificate> giftCertificateFieldExtractor, QueryCreator queryCreator,
                                  TagRowMapper tagRowMapper, TagDao tagDao) {
        super(jdbcTemplate, giftCertificateRowMapper, queryCreator);
        this.tagRowMapper = tagRowMapper;
        this.tagDao = tagDao;
        this.giftCertificateFieldExtractor = giftCertificateFieldExtractor;
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    protected String getSelectJoiner() {
        return SELECT_JOINER;
    }

    @Override
    @Transactional
    public void insert(GiftCertificate item) throws DaoException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, item.getName());
                ps.setString(2, item.getDescription());
                ps.setString(3, String.valueOf(item.getPrice()));
                ps.setString(4, String.valueOf(item.getDuration()));
                ps.setString(5, item.getCreateDate());
                ps.setString(6, item.getLastUpdateDate());
                return ps;
            }, keyHolder);
            updateTags(item, keyHolder.getKey().intValue());
        } catch (DataAccessException e) {
            throw new DaoException(SAVING_ERROR);
        }
    }

    @Override
    @Transactional
    public void update(GiftCertificate item) throws DaoException {
        try {
            Map<String, String> fields = giftCertificateFieldExtractor.extract(item);
            String updateQuery = queryCreator.createUpdateQuery(fields, getTableName());
            executeUpdateQuery(updateQuery);
            updateTags(item, item.getId());
        } catch (DataAccessException e) {
            throw new DaoException(NO_ENTITY_WITH_ID);
        }
    }

    @Override
    public void addTagsAssociation(long certificateId, List<Tag> tags) throws DaoException {
        List<Long> tagIds = getTagsIds(tags);
        try {
            tagIds.stream().forEach(tagId -> {
                executeUpdateQuery(ADD_TAGS_ASSOCIATION_QUERY, certificateId, tagId);
            });
        } catch (DataAccessException e) {
            throw new DaoException(NO_ENTITY_WITH_ID);
        }
    }

    @Override
    public void deleteTagsAssociation(long certificateId, List<Tag> tags) throws DaoException {
        try {
            List<Long> tagIds = getTagsIds(tags);
            tagIds.stream().forEach(tagId -> {
                executeUpdateQuery(REMOVE_TAGS_ASSOCIATION_QUERY, certificateId, tagId);
            });
        } catch (DataAccessException e) {
            throw new DaoException(NO_ENTITY_WITH_ID);
        }
    }

    @Override
    public List<Tag> getAssociatedTags(long certificateId) throws DaoException {
        try {
            return jdbcTemplate.query(GET_ASSOCIATED_TAGS_QUERY, tagRowMapper, certificateId);
        } catch (DataAccessException e) {
            throw new DaoException(NO_ENTITY);
        }
    }

    private void updateTags(GiftCertificate item, long giftCertificateId) {
        if (item.getTags() == null) {
            return;
        }
        List<Long> tagIds = getTagsIds(item.getTags());
        for (Long id : tagIds) {
            executeUpdateQuery(ADD_TAGS_QUERY, giftCertificateId, id);
        }
    }

    private List<Long> getTagsIds(List<Tag> tags) {
        List<Long> tagIds = new ArrayList();
        tags.stream().forEach(tag -> {
            String tagName = tag.getName();
            Tag tagWithId = null;

            try {
                tagWithId = tagDao.getByName(tagName).get(0);
            } catch (DaoException e) {
                e.printStackTrace();
            }

            tagIds.add(tagWithId.getId());
        });
        return tagIds;
    }
}