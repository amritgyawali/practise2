package com.amrit.blog.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

class UserTest {
    /**
     * Method under test: {@link User#getAuthorities()}
     */
    @Test
    void GetAuthorities_Test() {
        // Arrange
        User user = new User();

        // Act
        Collection<? extends GrantedAuthority> actualAuthorities = user.getAuthorities();

        // Assert
        assertTrue(actualAuthorities instanceof List);
        assertTrue(actualAuthorities.isEmpty());
        assertEquals(actualAuthorities, user.getPosts());
    }

    /**
     * Method under test: {@link User#getAuthorities()}
     */
    @Test
    void GetAuthorities_Test2() {
        // Arrange
        Role role = new Role();
        role.setId(1);
        role.setName("foo");

        LinkedHashSet<Role> roles = new LinkedHashSet<>();
        roles.add(role);

        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(roles);

        // Act
        Collection<? extends GrantedAuthority> actualAuthorities = user.getAuthorities();

        // Assert
        assertTrue(actualAuthorities instanceof List);
        assertEquals(1, actualAuthorities.size());
        GrantedAuthority getResult = ((List<? extends GrantedAuthority>) actualAuthorities).get(0);
        assertTrue(getResult instanceof SimpleGrantedAuthority);
        assertEquals("foo", getResult.toString());
        assertEquals("foo", getResult.getAuthority());
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>{@link User#getUsername()}
     *   <li>{@link User#isAccountNonExpired()}
     *   <li>{@link User#isAccountNonLocked()}
     *   <li>{@link User#isCredentialsNonExpired()}
     *   <li>{@link User#isEnabled()}
     * </ul>
     */
    @Test
    void gettersAndSetters_Test() {
        // Arrange
        User user = new User();

        // Act
        String actualUsername = user.getUsername();
        boolean actualIsAccountNonExpiredResult = user.isAccountNonExpired();
        boolean actualIsAccountNonLockedResult = user.isAccountNonLocked();
        boolean actualIsCredentialsNonExpiredResult = user.isCredentialsNonExpired();

        // Assert
        assertNull(actualUsername);
        assertTrue(actualIsAccountNonExpiredResult);
        assertTrue(actualIsAccountNonLockedResult);
        assertTrue(actualIsCredentialsNonExpiredResult);
        assertTrue(user.isEnabled());
    }
}
