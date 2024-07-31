package com.amrit.blog.payloads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class JwtAuthResponseTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link JwtAuthResponse#equals(Object)}
     *   <li>{@link JwtAuthResponse#hashCode()}
     * </ul>
     */
    @Test
    void EqualsAndHashCode_whenOtherIsSame_thenReturnEqualTest() {
        // Arrange
        UserDto user = new UserDto();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setToken("ABC123");
        jwtAuthResponse.setUser(user);

        // Act and Assert
        assertEquals(jwtAuthResponse, jwtAuthResponse);
        int expectedHashCodeResult = jwtAuthResponse.hashCode();
        assertEquals(expectedHashCodeResult, jwtAuthResponse.hashCode());
    }

    /**
     * Method under test: {@link JwtAuthResponse#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsDifferent_thenReturnNotEqualTest() {
        // Arrange
        UserDto user = new UserDto();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setToken("ABC123");
        jwtAuthResponse.setUser(user);

        UserDto user2 = new UserDto();
        user2.setAbout("About");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setRoles(new HashSet<>());

        JwtAuthResponse jwtAuthResponse2 = new JwtAuthResponse();
        jwtAuthResponse2.setToken("ABC123");
        jwtAuthResponse2.setUser(user2);

        // Act and Assert
        assertNotEquals(jwtAuthResponse, jwtAuthResponse2);
    }

    /**
     * Method under test: {@link JwtAuthResponse#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsDifferent_thenReturnNotEqualTest2() {
        // Arrange
        UserDto user = new UserDto();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setToken("Token");
        jwtAuthResponse.setUser(user);

        UserDto user2 = new UserDto();
        user2.setAbout("About");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setRoles(new HashSet<>());

        JwtAuthResponse jwtAuthResponse2 = new JwtAuthResponse();
        jwtAuthResponse2.setToken("ABC123");
        jwtAuthResponse2.setUser(user2);

        // Act and Assert
        assertNotEquals(jwtAuthResponse, jwtAuthResponse2);
    }

    /**
     * Method under test: {@link JwtAuthResponse#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsDifferent_thenReturnNotEqualTest3() {
        // Arrange
        UserDto user = new UserDto();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setToken(null);
        jwtAuthResponse.setUser(user);

        UserDto user2 = new UserDto();
        user2.setAbout("About");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setRoles(new HashSet<>());

        JwtAuthResponse jwtAuthResponse2 = new JwtAuthResponse();
        jwtAuthResponse2.setToken("ABC123");
        jwtAuthResponse2.setUser(user2);

        // Act and Assert
        assertNotEquals(jwtAuthResponse, jwtAuthResponse2);
    }

    /**
     * Method under test: {@link JwtAuthResponse#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsDifferent_thenReturnNotEqualTest4() {
        // Arrange
        UserDto user = mock(UserDto.class);
        doNothing().when(user).setAbout(Mockito.<String>any());
        doNothing().when(user).setEmail(Mockito.<String>any());
        doNothing().when(user).setId(anyInt());
        doNothing().when(user).setName(Mockito.<String>any());
        doNothing().when(user).setPassword(Mockito.<String>any());
        doNothing().when(user).setRoles(Mockito.<Set<RoleDto>>any());
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setToken("ABC123");
        jwtAuthResponse.setUser(user);

        UserDto user2 = new UserDto();
        user2.setAbout("About");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setRoles(new HashSet<>());

        JwtAuthResponse jwtAuthResponse2 = new JwtAuthResponse();
        jwtAuthResponse2.setToken("ABC123");
        jwtAuthResponse2.setUser(user2);

        // Act and Assert
        assertNotEquals(jwtAuthResponse, jwtAuthResponse2);
    }

    /**
     * Method under test: {@link JwtAuthResponse#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsNull_thenReturnNotEqualTest() {
        // Arrange
        UserDto user = new UserDto();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setToken("ABC123");
        jwtAuthResponse.setUser(user);

        // Act and Assert
        assertNotEquals(jwtAuthResponse, null);
    }

    /**
     * Method under test: {@link JwtAuthResponse#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsWrongType_thenReturnNotEqualTest() {
        // Arrange
        UserDto user = new UserDto();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setToken("ABC123");
        jwtAuthResponse.setUser(user);

        // Act and Assert
        assertNotEquals(jwtAuthResponse, "Different type to JwtAuthResponse");
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>default or parameterless constructor of {@link JwtAuthResponse}
     *   <li>{@link JwtAuthResponse#setToken(String)}
     *   <li>{@link JwtAuthResponse#setUser(UserDto)}
     *   <li>{@link JwtAuthResponse#toString()}
     *   <li>{@link JwtAuthResponse#getToken()}
     *   <li>{@link JwtAuthResponse#getUser()}
     * </ul>
     */
    @Test
    void gettersAndSetters_Test() {
        // Arrange and Act
        JwtAuthResponse actualJwtAuthResponse = new JwtAuthResponse();
        actualJwtAuthResponse.setToken("ABC123");
        UserDto user = new UserDto();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        actualJwtAuthResponse.setUser(user);
        actualJwtAuthResponse.toString();
        String actualToken = actualJwtAuthResponse.getToken();

        // Assert that nothing has changed
        assertEquals("ABC123", actualToken);
        assertSame(user, actualJwtAuthResponse.getUser());
    }
}
