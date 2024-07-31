package com.amrit.blog.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ResourceNotFoundExceptionTest {
    /**
     * Method under test:
     * {@link ResourceNotFoundException#ResourceNotFoundException(String, String, long)}
     */
    @Test
    void NewResourceNotFoundException_Test() {
        // Arrange and Act
        ResourceNotFoundException actualResourceNotFoundException = new ResourceNotFoundException("Resource Name",
                "Field Name", 42L);

        // Assert
        assertEquals("Field Name", actualResourceNotFoundException.getFieldName());
        assertEquals("Resource Name not found with Field Name : 42", actualResourceNotFoundException.getLocalizedMessage());
        assertEquals("Resource Name not found with Field Name : 42", actualResourceNotFoundException.getMessage());
        assertEquals("Resource Name", actualResourceNotFoundException.getResourceName());
        assertNull(actualResourceNotFoundException.getCause());
        assertEquals(0, actualResourceNotFoundException.getSuppressed().length);
        assertEquals(42L, actualResourceNotFoundException.getFieldValue());
    }
}
