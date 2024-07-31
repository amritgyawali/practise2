package com.amrit.blog.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class RoleTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Role#equals(Object)}
     *   <li>{@link Role#hashCode()}
     * </ul>
     */
    @Test
    void EqualsAndHashCode_whenOtherIsEqual_thenReturnEqualTest() {
        // Arrange
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("Name");

        // Act and Assert
        assertEquals(role, role2);
        int expectedHashCodeResult = role.hashCode();
        assertEquals(expectedHashCodeResult, role2.hashCode());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Role#equals(Object)}
     *   <li>{@link Role#hashCode()}
     * </ul>
     */
    @Test
    void EqualsAndHashCode_whenOtherIsEqual_thenReturnEqualTest2() {
        // Arrange
        Role role = new Role();
        role.setId(1);
        role.setName(null);

        Role role2 = new Role();
        role2.setId(1);
        role2.setName(null);

        // Act and Assert
        assertEquals(role, role2);
        int expectedHashCodeResult = role.hashCode();
        assertEquals(expectedHashCodeResult, role2.hashCode());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Role#equals(Object)}
     *   <li>{@link Role#hashCode()}
     * </ul>
     */
    @Test
    void EqualsAndHashCode_whenOtherIsSame_thenReturnEqualTest() {
        // Arrange
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        // Act and Assert
        assertEquals(role, role);
        int expectedHashCodeResult = role.hashCode();
        assertEquals(expectedHashCodeResult, role.hashCode());
    }

    /**
     * Method under test: {@link Role#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsDifferent_thenReturnNotEqualTest() {
        // Arrange
        Role role = new Role();
        role.setId(2);
        role.setName("Name");

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("Name");

        // Act and Assert
        assertNotEquals(role, role2);
    }

    /**
     * Method under test: {@link Role#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsDifferent_thenReturnNotEqualTest2() {
        // Arrange
        Role role = new Role();
        role.setId(1);
        role.setName(null);

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("Name");

        // Act and Assert
        assertNotEquals(role, role2);
    }

    /**
     * Method under test: {@link Role#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsDifferent_thenReturnNotEqualTest3() {
        // Arrange
        Role role = new Role();
        role.setId(1);
        role.setName("com.amrit.blog.entities.Role");

        Role role2 = new Role();
        role2.setId(1);
        role2.setName("Name");

        // Act and Assert
        assertNotEquals(role, role2);
    }

    /**
     * Method under test: {@link Role#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsNull_thenReturnNotEqualTest() {
        // Arrange
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        // Act and Assert
        assertNotEquals(role, null);
    }

    /**
     * Method under test: {@link Role#equals(Object)}
     */
    @Test
    void Equals_whenOtherIsWrongType_thenReturnNotEqualTest() {
        // Arrange
        Role role = new Role();
        role.setId(1);
        role.setName("Name");

        // Act and Assert
        assertNotEquals(role, "Different type to Role");
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>default or parameterless constructor of {@link Role}
     *   <li>{@link Role#setId(int)}
     *   <li>{@link Role#setName(String)}
     *   <li>{@link Role#toString()}
     *   <li>{@link Role#getId()}
     *   <li>{@link Role#getName()}
     * </ul>
     */
    @Test
    void gettersAndSetters_Test() {
        // Arrange and Act
        Role actualRole = new Role();
        actualRole.setId(1);
        actualRole.setName("Name");
        String actualToStringResult = actualRole.toString();
        int actualId = actualRole.getId();

        // Assert that nothing has changed
        assertEquals("Name", actualRole.getName());
        assertEquals("Role(id=1, name=Name)", actualToStringResult);
        assertEquals(1, actualId);
    }
}
