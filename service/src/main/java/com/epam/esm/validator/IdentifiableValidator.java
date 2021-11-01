package com.epam.esm.validator;

import com.epam.esm.exceptions.IncorrectParameterException;
import lombok.experimental.UtilityClass;

import static com.epam.esm.exceptions.ExceptionIncorrectParameterMessageCodes.BAD_ID;

/**
 * Class {@code IdentifiableValidator} provides methods to validate fields of {@link com.epam.esm.entity.Identifiable}.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@UtilityClass
public class IdentifiableValidator {
    private final int MIN_ID = 1;

    /**
     * Validate ID.
     *
     * @param id the id
     * @throws IncorrectParameterException an exception thrown in case incorrect ID
     */
    public void validateId(long id) throws IncorrectParameterException {
        if (id < MIN_ID) {
            throw new IncorrectParameterException(BAD_ID);
        }
    }
}
