package com.epam.esm.dao.mapper;

import com.epam.esm.entity.Tag;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.esm.entity.TagColumns.ID;
import static com.epam.esm.entity.TagColumns.TAG_NAME;

/**
 * The {@code TagRowMapper} class is an implementation of the {@link ResultSetExtractor} interface
 * and is designed to work with a tags table to display ResultSet rows for each row.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Component
public class TagRowMapper implements ResultSetExtractor<List<Tag>> {

    /**
     * Method map each row of data in the ResultSet.
     * It is supposed to map values of every row on {@link Tag}.
     *
     * @param rs the ResultSet to map (pre-initialized before the current row)
     * @return the result list of objects (maybe {@code empty})
     * @throws SQLException
     * @throws DataAccessException
     */
    @Override
    public List<Tag> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Tag> tags = new ArrayList<>();
        rs.next();
        while (!rs.isAfterLast()) {
            Tag tag = new Tag();
            tag.setId(rs.getLong(ID));
            tag.setName(rs.getString(TAG_NAME));
            tags.add(tag);
            rs.next();
        }
        return tags;
    }
}
