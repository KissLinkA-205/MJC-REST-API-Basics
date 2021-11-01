package com.epam.esm.dao.creator;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.epam.esm.entity.GiftCertificateColumns.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QueryCreatorTest {
    private final QueryCreator queryCreator = new QueryCreator();

    private static final String TAGS_TABLE_NAME = "tags";
    private static final String GIFT_CERTIFICATE_TABLE_NAME = "gift_certificates";

    private static final String UPDATED_ID = "1";
    private static final String UPDATED_NAME = "name";
    private static final String UPDATED_PRICE = "52.15";
    private static final String LAST_UPDATED_DATE = "2018-08-29T06:12:15.156";
    private static final String SORT_PARAMETER = "ASC";

    @Test
    void testCreateUpdateQuery_fromGiftCertificatesTableName() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put(NAME, UPDATED_NAME);
        parameters.put(PRICE, UPDATED_PRICE);
        parameters.put(LAST_UPDATE_DATE, LAST_UPDATED_DATE);
        parameters.put(ID, UPDATED_ID);

        String actual = queryCreator.createUpdateQuery(parameters, GIFT_CERTIFICATE_TABLE_NAME);
        String expected = "UPDATE " + GIFT_CERTIFICATE_TABLE_NAME + " SET price='" + UPDATED_PRICE +
                "',name='" + UPDATED_NAME + "',last_update_date='" + LAST_UPDATED_DATE + "' WHERE id=" + UPDATED_ID;
        assertEquals(expected, actual);
    }

    @Test
    void testCreateGetQuery_fromTagsTableName() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("name", UPDATED_NAME);

        String actual = queryCreator.createGetQuery(parameters, TAGS_TABLE_NAME);
        String expected = "SELECT * FROM " + TAGS_TABLE_NAME + " WHERE name='" + UPDATED_NAME + "'";
        assertEquals(expected, actual);
    }

    @Test
    void testCreateGetQuery_fromGiftCertificatesTableName() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("name", UPDATED_NAME);
        parameters.put("sortByCreateDate", SORT_PARAMETER);

        String actual = queryCreator.createGetQuery(parameters, GIFT_CERTIFICATE_TABLE_NAME);
        String expected = "SELECT * FROM " + GIFT_CERTIFICATE_TABLE_NAME +
                " gc LEFT JOIN gift_certificates_tags gct ON gc.id=gct.gift_certificate_id LEFT JOIN tags t ON gct.tag_id=t.id" +
                " WHERE name='" + UPDATED_NAME + "' ORDER BY create_date " + SORT_PARAMETER;
        assertEquals(expected, actual);
    }
}