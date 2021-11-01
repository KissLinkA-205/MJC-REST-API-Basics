package com.epam.esm.service.impl;

import com.epam.esm.dao.impl.GiftCertificateDaoImpl;
import com.epam.esm.entity.GiftCertificate;
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

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GiftCertificateServiceImplTest {

    @Mock
    private GiftCertificateDaoImpl giftCertificateDao = Mockito.mock(GiftCertificateDaoImpl.class);

    @InjectMocks
    private GiftCertificateServiceImpl giftCertificateService;

    private static final Tag TAG_2 = new Tag(2, "tagName3");

    private static final GiftCertificate GIFT_CERTIFICATE_1 = new GiftCertificate(1, "giftCertificate1",
            "description1", new BigDecimal("10.1"), 1, "2020-08-29T06:12:15.156",
            "2020-08-29T06:12:15.156", Arrays.asList(new Tag(1, "tagName1"),
            new Tag(2, "tagName3"), new Tag(3, "tagName5")));

    private static final GiftCertificate GIFT_CERTIFICATE_2 = new GiftCertificate(2, "giftCertificate3",
            "description3", new BigDecimal("30.3"), 3, "2019-08-29T06:12:15.156",
            "2019-08-29T06:12:15.156", Collections.singletonList(new Tag(2, "tagName3")));

    private static final GiftCertificate GIFT_CERTIFICATE_3 = new GiftCertificate(3, "giftCertificate2",
            "description2", new BigDecimal("20.2"), 2, "2018-08-29T06:12:15.156",
            "2018-08-29T06:12:15.156", Collections.singletonList(new Tag(0, null)));

    private static final String SORT_PARAMETER = "DESC";

    @Test
    void testGetById() throws DaoException, IncorrectParameterException {
        when(giftCertificateDao.getById(GIFT_CERTIFICATE_2.getId())).thenReturn(GIFT_CERTIFICATE_2);
        GiftCertificate actual = giftCertificateService.getById(GIFT_CERTIFICATE_2.getId());
        GiftCertificate expected = GIFT_CERTIFICATE_2;

        assertEquals(expected, actual);
    }

    @Test
    void testGetAll() throws DaoException {
        List<GiftCertificate> giftCertificates = Arrays.asList(GIFT_CERTIFICATE_1, GIFT_CERTIFICATE_2, GIFT_CERTIFICATE_3);
        when(giftCertificateDao.getAll()).thenReturn(giftCertificates);
        List<GiftCertificate> actual = giftCertificateService.getAll();

        List<GiftCertificate> expected = giftCertificates;
        assertEquals(expected, actual);
    }

    @Test
    void testGetAssociatedTags() throws DaoException, IncorrectParameterException {
        when(giftCertificateDao.getAssociatedTags(GIFT_CERTIFICATE_2.getId())).thenReturn(Collections.singletonList(TAG_2));
        List<Tag> actual = giftCertificateService.getAssociatedTags(GIFT_CERTIFICATE_2.getId());
        List<Tag> expected = Collections.singletonList(TAG_2);

        assertEquals(expected, actual);
    }

    @Test
    void testDoFilter() throws DaoException {
        List<GiftCertificate> giftCertificates = Arrays.asList(GIFT_CERTIFICATE_2, GIFT_CERTIFICATE_1);
        MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("tag_name", TAG_2.getName());
        requestParams.add("sortByName", SORT_PARAMETER);

        Map<String, String> parameters = new HashMap<>();
        parameters.put("sortByName", SORT_PARAMETER);
        parameters.put("partOfDescription", null);
        parameters.put("partOfTagName", null);
        parameters.put("tag_name", TAG_2.getName());
        parameters.put("sortByTagName", null);
        parameters.put("sortByCreateDate", null);
        parameters.put("name", null);
        parameters.put("partOfName", null);
        when(giftCertificateDao.getWithFilters(parameters)).thenReturn(giftCertificates);
        List<GiftCertificate> actual = giftCertificateService.doFilter(requestParams);
        List<GiftCertificate> expected = giftCertificates;

        assertEquals(expected, actual);
    }
}