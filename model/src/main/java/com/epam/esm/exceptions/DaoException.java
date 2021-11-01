package com.epam.esm.exceptions;

/**
 * {@code DaoException} is generated in case resource {@link com.epam.esm.dao.AbstractDao}
 * or {@link com.epam.esm.dao.impl.TagDaoImpl} or {@link com.epam.esm.dao.impl.GiftCertificateDaoImpl} don't found in database.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 * @see Exception
 */
public class DaoException extends Exception {

    public DaoException() {
    }

    public DaoException(String messageCode) {
        super(messageCode);
    }

    public DaoException(String messageCode, Throwable cause) {
        super(messageCode, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

}
