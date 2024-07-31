package com.amrit.blog.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CategoryTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>default or parameterless constructor of {@link Category}
     *   <li>{@link Category#setCategoryDescription(String)}
     *   <li>{@link Category#setCategoryId(Integer)}
     *   <li>{@link Category#setCategoryTitle(String)}
     *   <li>{@link Category#setPosts(List)}
     *   <li>{@link Category#getCategoryDescription()}
     *   <li>{@link Category#getCategoryId()}
     *   <li>{@link Category#getCategoryTitle()}
     *   <li>{@link Category#getPosts()}
     * </ul>
     */
    @Test
    void gettersAndSetters_Test() {
        // Arrange and Act
        Category actualCategory = new Category();
        actualCategory.setCategoryDescription("Category Description");
        actualCategory.setCategoryId(1);
        actualCategory.setCategoryTitle("Dr");
        ArrayList<Post> posts = new ArrayList<>();
        actualCategory.setPosts(posts);
        String actualCategoryDescription = actualCategory.getCategoryDescription();
        Integer actualCategoryId = actualCategory.getCategoryId();
        String actualCategoryTitle = actualCategory.getCategoryTitle();
        List<Post> actualPosts = actualCategory.getPosts();

        // Assert that nothing has changed
        assertEquals("Category Description", actualCategoryDescription);
        assertEquals("Dr", actualCategoryTitle);
        assertEquals(1, actualCategoryId.intValue());
        assertTrue(actualPosts.isEmpty());
        assertSame(posts, actualPosts);
    }
}
