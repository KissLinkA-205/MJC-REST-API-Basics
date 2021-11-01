package com.epam.esm.validator;

import com.epam.esm.entity.Tag;
import com.epam.esm.exceptions.IncorrectParameterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TagValidatorTest {
    private static final String INCORRECT_NAME = "qw";
    private static final String CORRECT_NAME = "tagName";
    private static final Tag INCORRECT_TAG = new Tag(INCORRECT_NAME);
    private static final Tag CORRECT_TAG = new Tag(CORRECT_NAME);

    @Test
    void testValidate_incorrectData() {
        assertThrows(IncorrectParameterException.class, () -> TagValidator.validate(INCORRECT_TAG));
    }

    @Test
    void testValidate_correctData() {
        assertDoesNotThrow(() -> TagValidator.validate(CORRECT_TAG));
    }

    @Test
    void testValidateName_incorrectData() {
        assertThrows(IncorrectParameterException.class, () -> TagValidator.validateName(INCORRECT_NAME));
    }

    @Test
    void testValidateName_correctData() {
        assertDoesNotThrow(() -> TagValidator.validateName(CORRECT_NAME));
    }
}