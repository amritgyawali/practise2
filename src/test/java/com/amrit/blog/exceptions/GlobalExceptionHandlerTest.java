package com.amrit.blog.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.amrit.blog.payloads.ApiResponse;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;

class GlobalExceptionHandlerTest {
    /**
     * Method under test:
     * {@link GlobalExceptionHandler#resourceNotFoundExceptionHandler(ResourceNotFoundException)}
     */
    @Test
    void ResourceNotFoundExceptionHandler_Test() {
        // Arrange
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

        // Act
        ResponseEntity<ApiResponse> actualResourceNotFoundExceptionHandlerResult = globalExceptionHandler
                .resourceNotFoundExceptionHandler(new ResourceNotFoundException("Resource Name", "Field Name", 42L));

        // Assert
        ApiResponse body = actualResourceNotFoundExceptionHandlerResult.getBody();
        assertEquals("Resource Name not found with Field Name : 42", body.getMessage());
        assertEquals(404, actualResourceNotFoundExceptionHandlerResult.getStatusCodeValue());
        assertEquals(HttpStatus.NOT_FOUND, actualResourceNotFoundExceptionHandlerResult.getStatusCode());
        assertFalse(body.isSuccess());
        assertTrue(actualResourceNotFoundExceptionHandlerResult.hasBody());
        assertTrue(actualResourceNotFoundExceptionHandlerResult.getHeaders().isEmpty());
    }

    /**
     * Method under test:
     * {@link GlobalExceptionHandler#handleMethodArgsNotValidException(MethodArgumentNotValidException)}
     */
    @Test
    void HandleMethodArgsNotValidException_Test() {
        // Arrange
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

        // Act
        ResponseEntity<Map<String, String>> actualHandleMethodArgsNotValidExceptionResult = globalExceptionHandler
                .handleMethodArgsNotValidException(
                        new MethodArgumentNotValidException(null, new BindException("Target", "Object Name")));

        // Assert
        assertEquals(400, actualHandleMethodArgsNotValidExceptionResult.getStatusCodeValue());
        assertEquals(HttpStatus.BAD_REQUEST, actualHandleMethodArgsNotValidExceptionResult.getStatusCode());
        assertTrue(actualHandleMethodArgsNotValidExceptionResult.getBody().isEmpty());
        assertTrue(actualHandleMethodArgsNotValidExceptionResult.hasBody());
        assertTrue(actualHandleMethodArgsNotValidExceptionResult.getHeaders().isEmpty());
    }

    /**
     * Method under test:
     * {@link GlobalExceptionHandler#handleApiException(ApiException)}
     */
    @Test
    void HandleApiException_Test() {
        // Arrange
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

        // Act
        ResponseEntity<ApiResponse> actualHandleApiExceptionResult = globalExceptionHandler
                .handleApiException(new ApiException("An error occurred"));

        // Assert
        ApiResponse body = actualHandleApiExceptionResult.getBody();
        assertEquals("An error occurred", body.getMessage());
        assertEquals(400, actualHandleApiExceptionResult.getStatusCodeValue());
        assertEquals(HttpStatus.BAD_REQUEST, actualHandleApiExceptionResult.getStatusCode());
        assertTrue(body.isSuccess());
        assertTrue(actualHandleApiExceptionResult.hasBody());
        assertTrue(actualHandleApiExceptionResult.getHeaders().isEmpty());
    }
}
