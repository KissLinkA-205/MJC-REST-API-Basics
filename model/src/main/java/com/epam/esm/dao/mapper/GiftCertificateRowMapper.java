package com.epam.esm.dao.mapper;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.esm.entity.GiftCertificateColumns.*;
import static com.epam.esm.entity.TagColumns.TAG_NAME;

/**
 * The {@code GiftCertificateRowMapper} class is an implementation of the {@link ResultSetExtractor} interface
 * and is designed to work with a gift_certificates table to display ResultSet rows for each row.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Component
public class GiftCertificateRowMapper implements ResultSetExtractor<List<GiftCertificate>> {

    private static final String TAG_ID = "tag_id";

    /**
     * Method map each row of data in the ResultSet.
     * It is supposed to map values of every row on {@link GiftCertificate}.
     *
     * @param rs the ResultSet to map (pre-initialized before the current row)
     * @return the result list of objects (maybe {@code empty})
     * @throws SQLException
     * @throws DataAccessException
     */
    @Override
    public List<GiftCertificate> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<GiftCertificate> giftCertificates = new ArrayList<>();
        rs.next();
        while (!rs.isAfterLast()) {
            GiftCertificate giftCertificate = new GiftCertificate();
            giftCertificate.setId(rs.getLong(ID));
            giftCertificate.setName(rs.getString(NAME));
            giftCertificate.setDescription(rs.getString(DESCRIPTION));
            giftCertificate.setPrice(rs.getBigDecimal(PRICE));
            giftCertificate.setDuration(rs.getInt(DURATION));
            giftCertificate.setCreateDate(rs.getString(CREATE_DATE));
            giftCertificate.setLastUpdateDate(rs.getString(LAST_UPDATE_DATE));

            List<Tag> tags = new ArrayList<>();
            while (!rs.isAfterLast() && rs.getInt(ID) == giftCertificate.getId()) {
                long tagId = rs.getLong(TAG_ID);
                String tagName = rs.getString(TAG_NAME);
                tags.add(new Tag(tagId, tagName));
                rs.next();
            }
            giftCertificate.setTags(tags);
            giftCertificates.add(giftCertificate);
        }
        return giftCertificates;
    }
}
