package com.amrit.blog.payloads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class PostDtoTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>default or parameterless constructor of {@link PostDto}
     *   <li>{@link PostDto#setAddedDate(Date)}
     *   <li>{@link PostDto#setCategory(CategoryDto)}
     *   <li>{@link PostDto#setContent(String)}
     *   <li>{@link PostDto#setPostId(Integer)}
     *   <li>{@link PostDto#setTitle(String)}
     *   <li>{@link PostDto#setUser(UserDto)}
     *   <li>{@link PostDto#getAddedDate()}
     *   <li>{@link PostDto#getCategory()}
     *   <li>{@link PostDto#getContent()}
     *   <li>{@link PostDto#getPostId()}
     *   <li>{@link PostDto#getTitle()}
     *   <li>{@link PostDto#getUser()}
     * </ul>
     */
    @Test
    void gettersAndSetters_Test() {
        // Arrange and Act
        PostDto actualPostDto = new PostDto();
        Date addedDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        actualPostDto.setAddedDate(addedDate);
        CategoryDto category = new CategoryDto();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        actualPostDto.setCategory(category);
        actualPostDto.setContent("Not all who wander are lost");
        actualPostDto.setPostId(1);
        actualPostDto.setTitle("Dr");
        UserDto user = new UserDto();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());
        actualPostDto.setUser(user);
        Date actualAddedDate = actualPostDto.getAddedDate();
        CategoryDto actualCategory = actualPostDto.getCategory();
        String actualContent = actualPostDto.getContent();
        Integer actualPostId = actualPostDto.getPostId();
        String actualTitle = actualPostDto.getTitle();
        UserDto actualUser = actualPostDto.getUser();

        // Assert that nothing has changed
        assertEquals("Dr", actualTitle);
        assertEquals("Not all who wander are lost", actualContent);
        assertEquals(1, actualPostId.intValue());
        assertSame(category, actualCategory);
        assertSame(user, actualUser);
        assertSame(addedDate, actualAddedDate);
    }
}
