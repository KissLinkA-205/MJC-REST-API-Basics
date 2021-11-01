package com.epam.esm.validator;

import com.epam.esm.exceptions.IncorrectParameterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IdentifiableValidatorTest {
    private static final long INCORRECT_ID = -4;
    private static final long CORRECT_ID = 4;

    @Test
    void testValidateId_incorrectData() {
        assertThrows(IncorrectParameterException.class, () -> IdentifiableValidator.validateId(INCORRECT_ID));
    }

    @Test
    void testValidateId_correctData() {
        assertDoesNotThrow(() -> IdentifiableValidator.validateId(CORRECT_ID));
    }
}