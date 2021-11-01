package com.epam.esm.validator;

import com.epam.esm.entity.Tag;
import com.epam.esm.exceptions.IncorrectParameterException;
import lombok.experimental.UtilityClass;

import static com.epam.esm.exceptions.ExceptionIncorrectParameterMessageCodes.BAD_TAG_NAME;

/**
 * Class {@code TagValidator} provides methods to validate fields of {@link com.epam.esm.entity.Tag}.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
@UtilityClass
public class TagValidator {
    private final int MAX_LENGTH_NAME = 20;
    private final int MIN_LENGTH_NAME = 3;

    public void validate(Tag tag) throws IncorrectParameterException {
        validateName(tag.getName());
    }

    /**
     * Validate tag name.
     *
     * @param name the tag name
     * @throws IncorrectParameterException an exception thrown in case incorrect name
     */
    public void validateName(String name) throws IncorrectParameterException {
        if (name.length() < MIN_LENGTH_NAME || name.length() > MAX_LENGTH_NAME) {
            throw new IncorrectParameterException(BAD_TAG_NAME);
        }
    }
}
