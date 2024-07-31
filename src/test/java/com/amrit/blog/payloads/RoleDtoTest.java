package com.amrit.blog.payloads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class RoleDtoTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link RoleDto#equals(Object)}
     *   <li>{@link RoleDto#hashCode()}
     * </ul>
     */
    @Test
    void EqualsAndHashCode_whenOtherIsEqual_thenReturnEqualTest() {
        // Arrange
        RoleDto roleDto = new RoleDto();
        roleDto.setId(1);
        roleDto.setName("Name");

        RoleDto roleDto2 = new RoleDto();
        roleDto2.setId(1);
        roleDto2.setName("Name");

        // Act and Assert
        assertEquals(roleDto, roleDto2);
        int expectedHashCodeResult = roleDto.hashCode();
        assertEquals(expectedHashCodeResult, roleDto2.hashCode());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link RoleDto#equals(Object)}
     *   <li>{@link RoleDto#hashCode()}
     * </ul>
     */
    @Test
    void EqualsAndHashCode_whenOtherIsEqual_thenReturnEqualTest2() {
        // Arrange
        RoleDto roleDto = new RoleDto();
        roleDto.setId(1);
        roleDto.setName(null);

        RoleDto roleDto2 = new RoleDto();
        roleDto2.setId(1);
        roleDto2.setName(null);

        // Act and Assert
        assertEquals(roleDto, roleDto2);
        int expectedHashCodeResult = roleDto.hashCode();
        assertEquals(expectedHashCodeResult, roleDto2.hashCode());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link RoleDto#equals(Object)}
     *   <li>{@link RoleDto#hashCode()}
     * </ul>
     */
    @Test
    void EqualsAndHashCode_whenOtherIsSame_thenReturnEqualTest() {
        // Arrange
        RoleDto roleDto = new RoleDto();
        roleDto.setId(1);
        roleDto.setName("Name");

        // Act and Assert
        assertEquals(roleDto, roleDto);
        int expectedHashCodeResult = roleDto.hashCode();
        assertEquals(expectedHashCodeResult, roleDto.hashCode());
    }

    /**
     * Method under test: {@link RoleDto#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsDifferent_thenReturnNotEqualTest() {
        // Arrange
        RoleDto roleDto = new RoleDto();
        roleDto.setId(2);
        roleDto.setName("Name");

        RoleDto roleDto2 = new RoleDto();
        roleDto2.setId(1);
        roleDto2.setName("Name");

        // Act and Assert
        assertNotEquals(roleDto, roleDto2);
    }

    /**
     * Method under test: {@link RoleDto#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsDifferent_thenReturnNotEqualTest2() {
        // Arrange
        RoleDto roleDto = new RoleDto();
        roleDto.setId(1);
        roleDto.setName(null);

        RoleDto roleDto2 = new RoleDto();
        roleDto2.setId(1);
        roleDto2.setName("Name");

        // Act and Assert
        assertNotEquals(roleDto, roleDto2);
    }

    /**
     * Method under test: {@link RoleDto#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsDifferent_thenReturnNotEqualTest3() {
        // Arrange
        RoleDto roleDto = new RoleDto();
        roleDto.setId(1);
        roleDto.setName("com.amrit.blog.payloads.RoleDto");

        RoleDto roleDto2 = new RoleDto();
        roleDto2.setId(1);
        roleDto2.setName("Name");

        // Act and Assert
        assertNotEquals(roleDto, roleDto2);
    }

    /**
     * Method under test: {@link RoleDto#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsNull_thenReturnNotEqualTest() {
        // Arrange
        RoleDto roleDto = new RoleDto();
        roleDto.setId(1);
        roleDto.setName("Name");

        // Act and Assert
        assertNotEquals(roleDto, null);
    }

    /**
     * Method under test: {@link RoleDto#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsWrongType_thenReturnNotEqualTest() {
        // Arrange
        RoleDto roleDto = new RoleDto();
        roleDto.setId(1);
        roleDto.setName("Name");

        // Act and Assert
        assertNotEquals(roleDto, "Different type to RoleDto");
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>default or parameterless constructor of {@link RoleDto}
     *   <li>{@link RoleDto#setId(int)}
     *   <li>{@link RoleDto#setName(String)}
     *   <li>{@link RoleDto#toString()}
     *   <li>{@link RoleDto#getId()}
     *   <li>{@link RoleDto#getName()}
     * </ul>
     */
    @Test
    void gettersAndSetters_Test() {
        // Arrange and Act
        RoleDto actualRoleDto = new RoleDto();
        actualRoleDto.setId(1);
        actualRoleDto.setName("Name");
        String actualToStringResult = actualRoleDto.toString();
        int actualId = actualRoleDto.getId();

        // Assert that nothing has changed
        assertEquals("Name", actualRoleDto.getName());
        assertEquals("RoleDto(id=1, name=Name)", actualToStringResult);
        assertEquals(1, actualId);
    }
}
