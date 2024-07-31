package com.amrit.blog.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ApiExceptionTest {
    /**
     * Method under test: {@link ApiException#ApiException()}
     */
    @Test
    void NewApiException_Test() {
        // Arrange and Act
        ApiException actualApiException = new ApiException();

        // Assert
        assertNull(actualApiException.getMessage());
        assertNull(actualApiException.getCause());
        assertEquals(0, actualApiException.getSuppressed().length);
    }

    /**
     * Method under test: {@link ApiException#ApiException(String)}
     */
    @Test
    void NewApiException_Test2() {
        // Arrange and Act
        ApiException actualApiException = new ApiException("An error occurred");

        // Assert
        assertEquals("An error occurred", actualApiException.getMessage());
        assertNull(actualApiException.getCause());
        assertEquals(0, actualApiException.getSuppressed().length);
    }
}
