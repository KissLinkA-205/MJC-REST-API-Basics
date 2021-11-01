package com.epam.esm.dao.impl;

import com.epam.esm.dao.config.MySqlDataBaseTestConfig;
import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import com.epam.esm.exceptions.DaoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = MySqlDataBaseTestConfig.class)
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class GiftCertificateDaoImplTest {

    @Autowired
    private GiftCertificateDaoImpl giftCertificateDao;

    private static final Tag TAG_2 = new Tag(2, "tagName3");

    private static final GiftCertificate GIFT_CERTIFICATE_1 = new GiftCertificate(1, "giftCertificate1",
            "description1", new BigDecimal("10.1"), 1, "2020-08-29T06:12:15.156",
            "2020-08-29T06:12:15.156", Collections.singletonList(new Tag(2, "tagName3")));

    private static final GiftCertificate GIFT_CERTIFICATE_2 = new GiftCertificate(2, "giftCertificate3",
            "description3", new BigDecimal("30.3"), 3, "2019-08-29T06:12:15.156",
            "2019-08-29T06:12:15.156", Collections.singletonList(new Tag(2, "tagName3")));

    private static final GiftCertificate GIFT_CERTIFICATE_3 = new GiftCertificate(3, "giftCertificate2",
            "description2", new BigDecimal("20.2"), 2, "2018-08-29T06:12:15.156",
            "2018-08-29T06:12:15.156", Collections.singletonList(new Tag(0, null)));

    private static final String SORT_PARAMETER = "DESC";

    @Test
    void testGetById() throws DaoException {
        GiftCertificate actual = giftCertificateDao.getById(GIFT_CERTIFICATE_2.getId());
        GiftCertificate expected = GIFT_CERTIFICATE_2;

        assertEquals(expected, actual);
    }

    @Test
    void testGetAll() throws DaoException {
        List<GiftCertificate> actual = giftCertificateDao.getAll();

        List<GiftCertificate> expected = Arrays.asList(GIFT_CERTIFICATE_1, GIFT_CERTIFICATE_2, GIFT_CERTIFICATE_3);
        assertEquals(expected, actual);
    }

    @Test
    void testGetAssociatedTags() throws DaoException {
        List<Tag> actual = giftCertificateDao.getAssociatedTags(2);
        List<Tag> expected = Collections.singletonList(TAG_2);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetWithFilters() throws DaoException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("sortByName", SORT_PARAMETER);
        parameters.put("partOfDescription", null);
        parameters.put("partOfTagName", null);
        parameters.put("tag_name", TAG_2.getName());
        parameters.put("sortByTagName", null);
        parameters.put("sortByCreateDate", null);
        parameters.put("name", null);
        parameters.put("partOfName", null);
        List<GiftCertificate> actual = giftCertificateDao.getWithFilters(parameters);
        List<GiftCertificate> expected = Arrays.asList(GIFT_CERTIFICATE_2, GIFT_CERTIFICATE_1);

        assertEquals(expected, actual);
    }
}