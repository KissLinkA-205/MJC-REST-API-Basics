package com.epam.esm.logic.creator.impl;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import com.epam.esm.logic.handler.DateHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.math.BigDecimal;
import java.util.Arrays;

import static com.epam.esm.entity.GiftCertificateColumns.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GiftCertificateCreatorTest {

    @Mock
    private DateHandler dateHandler = Mockito.mock(DateHandler.class);

    @InjectMocks
    private GiftCertificateCreator creator;

    private static final String EXPECTED_NAME = "name";
    private static final String EXPECTED_DESCRIPTION = "description";
    private static final String EXPECTED_PRICE = "10.5";
    private static final String EXPECTED_DURATION = "2";
    private static final String EXPECTED_DATE = "2018-08-29T06:12:15.156";
    private static final String EXPECTED_TAG_NAME = "tagName";

    @Test
    public void testCreateObject() {
        when(dateHandler.getCurrentDate()).thenReturn(EXPECTED_DATE);

        MultiValueMap<String, String> fields = new LinkedMultiValueMap<>();
        fields.add(NAME, EXPECTED_NAME);
        fields.add(DESCRIPTION, EXPECTED_DESCRIPTION);
        fields.add(PRICE, EXPECTED_PRICE);
        fields.add(DURATION, EXPECTED_DURATION);
        fields.add(TAGS, EXPECTED_TAG_NAME);
        fields.add(TAGS, EXPECTED_TAG_NAME);
        GiftCertificate actual = creator.createObject(fields);

        GiftCertificate expected = new GiftCertificate();
        expected.setName(EXPECTED_NAME);
        expected.setDescription(EXPECTED_DESCRIPTION);
        expected.setPrice(new BigDecimal(EXPECTED_PRICE));
        expected.setDuration(Integer.parseInt(EXPECTED_DURATION));
        expected.setCreateDate(EXPECTED_DATE);
        expected.setLastUpdateDate(EXPECTED_DATE);
        expected.setTags(Arrays.asList(new Tag(EXPECTED_TAG_NAME), new Tag(EXPECTED_TAG_NAME)));

        assertEquals(expected, actual);
    }
}