package com.amrit.blog.payloads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class JwtAuthRequestTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link JwtAuthRequest#equals(Object)}
     *   <li>{@link JwtAuthRequest#hashCode()}
     * </ul>
     */
    @Test
    void EqualsAndHashCode_whenOtherIsEqual_thenReturnEqualTest() {
        // Arrange
        JwtAuthRequest jwtAuthRequest = new JwtAuthRequest();
        jwtAuthRequest.setPassword("iloveyou");
        jwtAuthRequest.setUsername("janedoe");

        JwtAuthRequest jwtAuthRequest2 = new JwtAuthRequest();
        jwtAuthRequest2.setPassword("iloveyou");
        jwtAuthRequest2.setUsername("janedoe");

        // Act and Assert
        assertEquals(jwtAuthRequest, jwtAuthRequest2);
        int expectedHashCodeResult = jwtAuthRequest.hashCode();
        assertEquals(expectedHashCodeResult, jwtAuthRequest2.hashCode());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link JwtAuthRequest#equals(Object)}
     *   <li>{@link JwtAuthRequest#hashCode()}
     * </ul>
     */
    @Test
    void EqualsAndHashCode_whenOtherIsEqual_thenReturnEqualTest2() {
        // Arrange
        JwtAuthRequest jwtAuthRequest = new JwtAuthRequest();
        jwtAuthRequest.setPassword(null);
        jwtAuthRequest.setUsername("janedoe");

        JwtAuthRequest jwtAuthRequest2 = new JwtAuthRequest();
        jwtAuthRequest2.setPassword(null);
        jwtAuthRequest2.setUsername("janedoe");

        // Act and Assert
        assertEquals(jwtAuthRequest, jwtAuthRequest2);
        int expectedHashCodeResult = jwtAuthRequest.hashCode();
        assertEquals(expectedHashCodeResult, jwtAuthRequest2.hashCode());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link JwtAuthRequest#equals(Object)}
     *   <li>{@link JwtAuthRequest#hashCode()}
     * </ul>
     */
    @Test
    void EqualsAndHashCode_whenOtherIsEqual_thenReturnEqualTest3() {
        // Arrange
        JwtAuthRequest jwtAuthRequest = new JwtAuthRequest();
        jwtAuthRequest.setPassword("iloveyou");
        jwtAuthRequest.setUsername(null);

        JwtAuthRequest jwtAuthRequest2 = new JwtAuthRequest();
        jwtAuthRequest2.setPassword("iloveyou");
        jwtAuthRequest2.setUsername(null);

        // Act and Assert
        assertEquals(jwtAuthRequest, jwtAuthRequest2);
        int expectedHashCodeResult = jwtAuthRequest.hashCode();
        assertEquals(expectedHashCodeResult, jwtAuthRequest2.hashCode());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link JwtAuthRequest#equals(Object)}
     *   <li>{@link JwtAuthRequest#hashCode()}
     * </ul>
     */
    @Test
    void EqualsAndHashCode_whenOtherIsSame_thenReturnEqualTest() {
        // Arrange
        JwtAuthRequest jwtAuthRequest = new JwtAuthRequest();
        jwtAuthRequest.setPassword("iloveyou");
        jwtAuthRequest.setUsername("janedoe");

        // Act and Assert
        assertEquals(jwtAuthRequest, jwtAuthRequest);
        int expectedHashCodeResult = jwtAuthRequest.hashCode();
        assertEquals(expectedHashCodeResult, jwtAuthRequest.hashCode());
    }

    /**
     * Method under test: {@link JwtAuthRequest#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsDifferent_thenReturnNotEqualTest() {
        // Arrange
        JwtAuthRequest jwtAuthRequest = new JwtAuthRequest();
        jwtAuthRequest.setPassword("janedoe");
        jwtAuthRequest.setUsername("janedoe");

        JwtAuthRequest jwtAuthRequest2 = new JwtAuthRequest();
        jwtAuthRequest2.setPassword("iloveyou");
        jwtAuthRequest2.setUsername("janedoe");

        // Act and Assert
        assertNotEquals(jwtAuthRequest, jwtAuthRequest2);
    }

    /**
     * Method under test: {@link JwtAuthRequest#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsDifferent_thenReturnNotEqualTest2() {
        // Arrange
        JwtAuthRequest jwtAuthRequest = new JwtAuthRequest();
        jwtAuthRequest.setPassword(null);
        jwtAuthRequest.setUsername("janedoe");

        JwtAuthRequest jwtAuthRequest2 = new JwtAuthRequest();
        jwtAuthRequest2.setPassword("iloveyou");
        jwtAuthRequest2.setUsername("janedoe");

        // Act and Assert
        assertNotEquals(jwtAuthRequest, jwtAuthRequest2);
    }

    /**
     * Method under test: {@link JwtAuthRequest#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsDifferent_thenReturnNotEqualTest3() {
        // Arrange
        JwtAuthRequest jwtAuthRequest = new JwtAuthRequest();
        jwtAuthRequest.setPassword("iloveyou");
        jwtAuthRequest.setUsername("iloveyou");

        JwtAuthRequest jwtAuthRequest2 = new JwtAuthRequest();
        jwtAuthRequest2.setPassword("iloveyou");
        jwtAuthRequest2.setUsername("janedoe");

        // Act and Assert
        assertNotEquals(jwtAuthRequest, jwtAuthRequest2);
    }

    /**
     * Method under test: {@link JwtAuthRequest#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsDifferent_thenReturnNotEqualTest4() {
        // Arrange
        JwtAuthRequest jwtAuthRequest = new JwtAuthRequest();
        jwtAuthRequest.setPassword("iloveyou");
        jwtAuthRequest.setUsername(null);

        JwtAuthRequest jwtAuthRequest2 = new JwtAuthRequest();
        jwtAuthRequest2.setPassword("iloveyou");
        jwtAuthRequest2.setUsername("janedoe");

        // Act and Assert
        assertNotEquals(jwtAuthRequest, jwtAuthRequest2);
    }

    /**
     * Method under test: {@link JwtAuthRequest#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsNull_thenReturnNotEqualTest() {
        // Arrange
        JwtAuthRequest jwtAuthRequest = new JwtAuthRequest();
        jwtAuthRequest.setPassword("iloveyou");
        jwtAuthRequest.setUsername("janedoe");

        // Act and Assert
        assertNotEquals(jwtAuthRequest, null);
    }

    /**
     * Method under test: {@link JwtAuthRequest#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsWrongType_thenReturnNotEqualTest() {
        // Arrange
        JwtAuthRequest jwtAuthRequest = new JwtAuthRequest();
        jwtAuthRequest.setPassword("iloveyou");
        jwtAuthRequest.setUsername("janedoe");

        // Act and Assert
        assertNotEquals(jwtAuthRequest, "Different type to JwtAuthRequest");
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>default or parameterless constructor of {@link JwtAuthRequest}
     *   <li>{@link JwtAuthRequest#setPassword(String)}
     *   <li>{@link JwtAuthRequest#setUsername(String)}
     *   <li>{@link JwtAuthRequest#toString()}
     *   <li>{@link JwtAuthRequest#getPassword()}
     *   <li>{@link JwtAuthRequest#getUsername()}
     * </ul>
     */
    @Test
    void gettersAndSetters_Test() {
        // Arrange and Act
        JwtAuthRequest actualJwtAuthRequest = new JwtAuthRequest();
        actualJwtAuthRequest.setPassword("iloveyou");
        actualJwtAuthRequest.setUsername("janedoe");
        String actualToStringResult = actualJwtAuthRequest.toString();
        String actualPassword = actualJwtAuthRequest.getPassword();

        // Assert that nothing has changed
        assertEquals("JwtAuthRequest(username=janedoe, password=iloveyou)", actualToStringResult);
        assertEquals("iloveyou", actualPassword);
        assertEquals("janedoe", actualJwtAuthRequest.getUsername());
    }
}
