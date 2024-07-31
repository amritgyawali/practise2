package com.amrit.blog.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class PostTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>default or parameterless constructor of {@link Post}
     *   <li>{@link Post#setAddedDate(Date)}
     *   <li>{@link Post#setCategory(Category)}
     *   <li>{@link Post#setContent(String)}
     *   <li>{@link Post#setPostId(Integer)}
     *   <li>{@link Post#setTitle(String)}
     *   <li>{@link Post#setUser(User)}
     *   <li>{@link Post#getAddedDate()}
     *   <li>{@link Post#getCategory()}
     *   <li>{@link Post#getContent()}
     *   <li>{@link Post#getPostId()}
     *   <li>{@link Post#getTitle()}
     *   <li>{@link Post#getUser()}
     * </ul>
     */
    @Test
    void gettersAndSetters_Test() {
        // Arrange and Act
        Post actualPost = new Post();
        Date addedDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        actualPost.setAddedDate(addedDate);
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());
        actualPost.setCategory(category);
        actualPost.setContent("Not all who wander are lost");
        actualPost.setPostId(1);
        actualPost.setTitle("Dr");
        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());
        actualPost.setUser(user);
        Date actualAddedDate = actualPost.getAddedDate();
        Category actualCategory = actualPost.getCategory();
        String actualContent = actualPost.getContent();
        Integer actualPostId = actualPost.getPostId();
        String actualTitle = actualPost.getTitle();
        User actualUser = actualPost.getUser();

        // Assert that nothing has changed
        assertEquals("Dr", actualTitle);
        assertEquals("Not all who wander are lost", actualContent);
        assertEquals(1, actualPostId.intValue());
        assertSame(category, actualCategory);
        assertSame(user, actualUser);
        assertSame(addedDate, actualAddedDate);
    }
}
