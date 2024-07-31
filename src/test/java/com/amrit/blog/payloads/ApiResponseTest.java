package com.amrit.blog.payloads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ApiResponseTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link ApiResponse#ApiResponse()}
     *   <li>{@link ApiResponse#setMessage(String)}
     *   <li>{@link ApiResponse#setSuccess(boolean)}
     *   <li>{@link ApiResponse#getMessage()}
     *   <li>{@link ApiResponse#isSuccess()}
     * </ul>
     */
    @Test
    void gettersAndSetters_Test() {
        // Arrange and Act
        ApiResponse actualApiResponse = new ApiResponse();
        actualApiResponse.setMessage("Not all who wander are lost");
        actualApiResponse.setSuccess(true);
        String actualMessage = actualApiResponse.getMessage();

        // Assert that nothing has changed
        assertEquals("Not all who wander are lost", actualMessage);
        assertTrue(actualApiResponse.isSuccess());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link ApiResponse#ApiResponse(String, boolean)}
     *   <li>{@link ApiResponse#setMessage(String)}
     *   <li>{@link ApiResponse#setSuccess(boolean)}
     *   <li>{@link ApiResponse#getMessage()}
     *   <li>{@link ApiResponse#isSuccess()}
     * </ul>
     */
    @Test
    void gettersAndSetters_Test2() {
        // Arrange and Act
        ApiResponse actualApiResponse = new ApiResponse("Not all who wander are lost", true);
        actualApiResponse.setMessage("Not all who wander are lost");
        actualApiResponse.setSuccess(true);
        String actualMessage = actualApiResponse.getMessage();

        // Assert that nothing has changed
        assertEquals("Not all who wander are lost", actualMessage);
        assertTrue(actualApiResponse.isSuccess());
    }
}
