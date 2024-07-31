package com.amrit.blog.payloads;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CategoryDtoTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>default or parameterless constructor of {@link CategoryDto}
     *   <li>{@link CategoryDto#setCategoryDescription(String)}
     *   <li>{@link CategoryDto#setCategoryId(Integer)}
     *   <li>{@link CategoryDto#setCategoryTitle(String)}
     *   <li>{@link CategoryDto#getCategoryDescription()}
     *   <li>{@link CategoryDto#getCategoryId()}
     *   <li>{@link CategoryDto#getCategoryTitle()}
     * </ul>
     */
    @Test
    void gettersAndSetters_Test() {
        // Arrange and Act
        CategoryDto actualCategoryDto = new CategoryDto();
        actualCategoryDto.setCategoryDescription("Category Description");
        actualCategoryDto.setCategoryId(1);
        actualCategoryDto.setCategoryTitle("Dr");
        String actualCategoryDescription = actualCategoryDto.getCategoryDescription();
        Integer actualCategoryId = actualCategoryDto.getCategoryId();

        // Assert that nothing has changed
        assertEquals("Category Description", actualCategoryDescription);
        assertEquals("Dr", actualCategoryDto.getCategoryTitle());
        assertEquals(1, actualCategoryId.intValue());
    }
}
