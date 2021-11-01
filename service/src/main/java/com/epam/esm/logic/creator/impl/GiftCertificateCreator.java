package com.epam.esm.logic.creator.impl;

import com.epam.esm.entity.GiftCertificate;
import com.epam.esm.entity.Tag;
import com.epam.esm.logic.creator.Creator;
import com.epam.esm.logic.handler.DateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.epam.esm.entity.GiftCertificateColumns.*;

/**
 * Class {@code GiftCertificateCreator} is implementation of interface {@link Creator} and intended
 * to work with {@link GiftCertificate} objects.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@Component
public class GiftCertificateCreator implements Creator<GiftCertificate> {
    private final DateHandler dateHandler;

    @Autowired
    public GiftCertificateCreator(DateHandler dateHandler) {
        this.dateHandler = dateHandler;
    }

    @Override
    public GiftCertificate createObject(MultiValueMap<String, String> allRequestParams) {
        GiftCertificate giftCertificate = new GiftCertificate();
        giftCertificate.setId(getLongField(ID, allRequestParams));
        giftCertificate.setName(getStringField(NAME, allRequestParams));
        giftCertificate.setDescription(getStringField(DESCRIPTION, allRequestParams));
        giftCertificate.setPrice(getBigDecimalField(PRICE, allRequestParams));
        giftCertificate.setDuration(getIntField(DURATION, allRequestParams));
        giftCertificate.setTags(getTags(allRequestParams));
        giftCertificate.setCreateDate(dateHandler.getCurrentDate());
        giftCertificate.setLastUpdateDate(dateHandler.getCurrentDate());
        return giftCertificate;
    }

    @Override
    public List<GiftCertificate> createList(MultiValueMap<String, String> requestParams) {
        return null;
    }

    private String getStringField(String fieldName, MultiValueMap<String, String> requestParams) {
        if (requestParams.containsKey(fieldName)) {
            return requestParams.get(fieldName).get(0);
        }
        return null;
    }

    private int getIntField(String fieldName, MultiValueMap<String, String> requestParams) {
        if (requestParams.containsKey(fieldName)) {
            String stringField = requestParams.get(fieldName).get(0);
            return Integer.parseInt(stringField);
        }
        return 0;
    }

    private long getLongField(String fieldName, MultiValueMap<String, String> requestParams) {
        if (requestParams.containsKey(fieldName)) {
            String stringField = requestParams.get(fieldName).get(0);
            return Long.parseLong(stringField);
        }
        return 0;
    }

    private BigDecimal getBigDecimalField(String fieldName, MultiValueMap<String, String> requestParams) {
        if (requestParams.containsKey(fieldName)) {
            String stringField = requestParams.get(fieldName).get(0);
            return new BigDecimal(stringField);
        }
        return new BigDecimal("0");
    }

    private List<Tag> getTags(MultiValueMap<String, String> requestParams) {
        if (requestParams.containsKey(TAGS)) {
            List<Tag> tags = new ArrayList<>();
            List<String> tagsNames = requestParams.get(TAGS);
            tagsNames.stream().forEach(tagName -> tags.add(new Tag(tagName)));
            return tags;
        }
        return new ArrayList<>();
    }
}
