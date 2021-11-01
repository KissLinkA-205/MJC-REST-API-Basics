package com.epam.esm.exceptions;

/**
 * Class {@code ExceptionIncorrectParameterMessageCodes} presents keys by which messages will be taken from properties files.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public class ExceptionIncorrectParameterMessageCodes {

    /**
     * Keys for exception messages associated with {@link com.epam.esm.entity.Identifiable}.
     */
    public static final String BAD_ID = "40000";
    /**
     * Keys for exception messages associated with {@link com.epam.esm.entity.Tag}.
     */
    public static final String BAD_TAG_NAME = "40001";

    /**
     * Keys for exception messages associated with {@link com.epam.esm.entity.GiftCertificate}.
     */
    public static final String BAD_GIFT_CERTIFICATE_NAME = "40002";
    public static final String BAD_GIFT_CERTIFICATE_DESCRIPTION = "40003";
    public static final String BAD_GIFT_CERTIFICATE_PRICE = "40004";
    public static final String BAD_GIFT_CERTIFICATE_DURATION = "40005";
}
