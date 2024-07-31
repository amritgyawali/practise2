package com.amrit.blog.payloads;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UserDtoTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link UserDto#setPassword(String)}
     *   <li>{@link UserDto#getPassword()}
     * </ul>
     */
    @Test
    void gettersAndSetters_Test() {
        // Arrange
        UserDto userDto = new UserDto();

        // Act
        userDto.setPassword("iloveyou");

        // Assert that nothing has changed
        assertEquals("iloveyou", userDto.getPassword());
    }
}
