package com.amrit.blog.repositories;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.amrit.blog.entities.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {UserRepo.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.amrit.blog.entities"})
@DataJpaTest
class UserRepoTest {
    @Autowired
    private UserRepo userRepo;

    /**
     * Method under test: {@link UserRepo#findByEmail(String)}
     */
    @Test
    void FindByEmail_Test() {
        // Arrange
        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());

        User user2 = new User();
        user2.setAbout("42");
        user2.setEmail("john.smith@example.org");
        user2.setName("42");
        user2.setPassword("Password");
        user2.setPosts(new ArrayList<>());
        user2.setRoles(new HashSet<>());
        userRepo.save(user);
        userRepo.save(user2);

        // Act
        Optional<User> actualFindByEmailResult = userRepo.findByEmail("jane.doe@example.org");

        // Assert
        assertTrue(actualFindByEmailResult.isPresent());
        assertSame(user, actualFindByEmailResult.get());
    }
}
