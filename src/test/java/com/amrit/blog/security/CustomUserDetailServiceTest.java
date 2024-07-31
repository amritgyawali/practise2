package com.amrit.blog.security;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amrit.blog.entities.User;
import com.amrit.blog.exceptions.ResourceNotFoundException;
import com.amrit.blog.repositories.UserRepo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomUserDetailService.class})
@ExtendWith(SpringExtension.class)
class CustomUserDetailServiceTest {
    @Autowired
    private CustomUserDetailService customUserDetailService;

    @MockBean
    private UserRepo userRepo;

    /**
     * Method under test: {@link CustomUserDetailService#loadUserByUsername(String)}
     */
    @Test
    void LoadUserByUsername_Test() throws UsernameNotFoundException {
        // Arrange
        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());
        Optional<User> ofResult = Optional.of(user);
        when(userRepo.findByEmail(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        UserDetails actualLoadUserByUsernameResult = customUserDetailService.loadUserByUsername("janedoe");

        // Assert
        verify(userRepo).findByEmail(eq("janedoe"));
        assertSame(user, actualLoadUserByUsernameResult);
    }

    /**
     * Method under test: {@link CustomUserDetailService#loadUserByUsername(String)}
     */
    @Test
    void LoadUserByUsername_Test2() throws UsernameNotFoundException {
        // Arrange
        Optional<User> emptyResult = Optional.empty();
        when(userRepo.findByEmail(Mockito.<String>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> customUserDetailService.loadUserByUsername("janedoe"));
        verify(userRepo).findByEmail(eq("janedoe"));
    }

    /**
     * Method under test: {@link CustomUserDetailService#loadUserByUsername(String)}
     */
    @Test
    void LoadUserByUsername_Test3() throws UsernameNotFoundException {
        // Arrange
        when(userRepo.findByEmail(Mockito.<String>any())).thenThrow(new ResourceNotFoundException("User ", "User ", 42L));

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> customUserDetailService.loadUserByUsername("janedoe"));
        verify(userRepo).findByEmail(eq("janedoe"));
    }
}
