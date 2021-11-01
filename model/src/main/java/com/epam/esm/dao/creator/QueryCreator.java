package com.epam.esm.dao.creator;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Class {@code QueryCreator} designed to create a selection condition.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Component
public class QueryCreator {

    /**
     * Method for creating a database query from {@link Map} to update entity information.
     *
     * @param fields    query parameters
     * @param tableName name of the table where the update will take place
     * @return generated string query
     */
    public String createUpdateQuery(Map<String, String> fields, String tableName) {
        StringJoiner joiner = new StringJoiner(",");
        for (Map.Entry<String, String> entry : fields.entrySet()) {
            if (entry.getValue() != null && !entry.getKey().equals("id")) {
                joiner.add(entry.getKey() + "=" + '\'' + entry.getValue() + '\'');
            }
        }
        String query = "UPDATE " + tableName + " SET " + joiner + " WHERE id=" + fields.get("id");
        return query;
    }

    /**
     * Method for creating a database query from {@link Map} to get entities.
     *
     * @param fields    query parameters
     * @param tableName name of the table where the update will take place
     * @return generated string query
     */
    public String createGetQuery(Map<String, String> fields, String tableName) {
        StringBuilder query = new StringBuilder("SELECT * FROM " + tableName);
        if (Objects.equals(tableName, "gift_certificates")) {
            query.append(" gc LEFT JOIN gift_certificates_tags gct ON gc.id=gct.gift_certificate_id LEFT JOIN tags t ON gct.tag_id=t.id");
        }
        if (fields.get("tag_name") != null) {
            addParameter(query, "tag_name", fields.get("tag_name"));
        }
        if (fields.get("name") != null) {
            addParameter(query, "name", fields.get("name"));
        }
        if (fields.get("partOfTagName") != null) {
            addPartParameter(query, "tag_name", fields.get("partOfTagName"));
        }
        if (fields.get("partOfName") != null) {
            addPartParameter(query, "name", fields.get("partOfName"));
        }
        if (fields.get("partOfDescription") != null) {
            addPartParameter(query, "description", fields.get("partOfDescription"));
        }
        if (fields.get("sortByTagName") != null) {
            addSortParameter(query, "tag_name", fields.get("sortByTagName"));
        }
        if (fields.get("sortByName") != null) {
            addSortParameter(query, "name", fields.get("sortByName"));
        }
        if (fields.get("sortByCreateDate") != null) {
            addSortParameter(query, "create_date", fields.get("sortByCreateDate"));
        }

        return query.toString();
    }

    private void addParameter(StringBuilder query, String partParameter, String value) {
        if (query.toString().contains("WHERE")) {
            query.append(" AND ");
        } else {
            query.append(" WHERE ");
        }
        query.append(partParameter).append("='").append(value).append('\'');
    }

    private void addPartParameter(StringBuilder query, String partParameter, String value) {
        if (query.toString().contains("WHERE")) {
            query.append(" AND ");
        } else {
            query.append(" WHERE ");
        }
        query.append(partParameter).append(" LIKE '%").append(value).append("%'");
    }

    private void addSortParameter(StringBuilder query, String sortParameter, String value) {
        if (query.toString().contains("ORDER BY")) {
            query.append(", ");
        } else {
            query.append(" ORDER BY ");
        }
        query.append(sortParameter).append(" ").append(value);
    }
}
