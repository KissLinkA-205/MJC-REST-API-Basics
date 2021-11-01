package com.epam.esm.dao.extractor.impl;

import com.epam.esm.entity.GiftCertificate;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.epam.esm.entity.GiftCertificateColumns.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GiftCertificateFieldExtractorTest {
    private final GiftCertificateFieldExtractor extractor = new GiftCertificateFieldExtractor();

    private static final String EXPECTED_ID = "1";
    private static final String EXPECTED_NAME = "name";
    private static final String EXPECTED_DESCRIPTION = "description";
    private static final String EXPECTED_PRICE = "10.5";
    private static final String EXPECTED_DURATION = "2";
    private static final String EXPECTED_LAST_UPDATE_DATE = "2018-08-29T06:12:15.156";

    @Test
    public void testExtract() {
        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setId(Long.parseLong(EXPECTED_ID));
        giftCertificate.setName(EXPECTED_NAME);
        giftCertificate.setDescription(EXPECTED_DESCRIPTION);
        giftCertificate.setPrice(new BigDecimal(EXPECTED_PRICE));
        giftCertificate.setDuration(Integer.parseInt(EXPECTED_DURATION));
        giftCertificate.setLastUpdateDate(EXPECTED_LAST_UPDATE_DATE);

        Map<String, String> actual = extractor.extract(giftCertificate);
        Map<String, String> expected = new HashMap<>();

        expected.put(ID, EXPECTED_ID);
        expected.put(NAME, EXPECTED_NAME);
        expected.put(DESCRIPTION, EXPECTED_DESCRIPTION);
        expected.put(PRICE, EXPECTED_PRICE);
        expected.put(DURATION, EXPECTED_DURATION);
        expected.put(LAST_UPDATE_DATE, EXPECTED_LAST_UPDATE_DATE);
        assertEquals(expected, actual);
    }
}