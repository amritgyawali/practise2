package com.amrit.blog.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amrit.blog.entities.Category;
import com.amrit.blog.entities.Post;
import com.amrit.blog.exceptions.ResourceNotFoundException;
import com.amrit.blog.payloads.CategoryDto;
import com.amrit.blog.repositories.CategoryRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CategoryServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CategoryServiceImplTest {
    @MockBean
    private CategoryRepo categoryRepo;

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @MockBean
    private ModelMapper modelMapper;

    /**
     * Method under test: {@link CategoryServiceImpl#createCategory(CategoryDto)}
     */
    @Test
    void CreateCategory_Test() {
        // Arrange
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any()))
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L));

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryDescription("Category Description");
        categoryDto.setCategoryId(1);
        categoryDto.setCategoryTitle("Dr");

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> categoryServiceImpl.createCategory(categoryDto));
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
    }

    /**
     * Method under test: {@link CategoryServiceImpl#createCategory(CategoryDto)}
     */
    @Test
    void CreateCategory_Test2() {
        // Arrange
        Category category = mock(Category.class);
        doNothing().when(category).setCategoryDescription(Mockito.<String>any());
        doNothing().when(category).setCategoryId(Mockito.<Integer>any());
        doNothing().when(category).setCategoryTitle(Mockito.<String>any());
        doNothing().when(category).setPosts(Mockito.<List<Post>>any());
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());
        when(categoryRepo.save(Mockito.<Category>any())).thenReturn(category);
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn(null);

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryDescription("Category Description");
        categoryDto.setCategoryId(1);
        categoryDto.setCategoryTitle("Dr");

        // Act
        CategoryDto actualCreateCategoryResult = categoryServiceImpl.createCategory(categoryDto);

        // Assert
        verify(category).setCategoryDescription(eq("Category Description"));
        verify(category).setCategoryId(eq(1));
        verify(category).setCategoryTitle(eq("Dr"));
        verify(category).setPosts(isA(List.class));
        verify(modelMapper, atLeast(1)).map(Mockito.<Object>any(), Mockito.<Class<Category>>any());
        verify(categoryRepo).save(isNull());
        assertNull(actualCreateCategoryResult);
    }

    /**
     * Method under test:
     * {@link CategoryServiceImpl#updateCategory(CategoryDto, Integer)}
     */
    @Test
    void UpdateCategory_Test() {
        // Arrange
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);

        Category category2 = new Category();
        category2.setCategoryDescription("Category Description");
        category2.setCategoryId(1);
        category2.setCategoryTitle("Dr");
        category2.setPosts(new ArrayList<>());
        when(categoryRepo.save(Mockito.<Category>any())).thenReturn(category2);
        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryDescription("Category Description");
        categoryDto.setCategoryId(1);
        categoryDto.setCategoryTitle("Dr");
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<CategoryDto>>any())).thenReturn(categoryDto);

        CategoryDto categoryDto2 = new CategoryDto();
        categoryDto2.setCategoryDescription("Category Description");
        categoryDto2.setCategoryId(1);
        categoryDto2.setCategoryTitle("Dr");

        // Act
        CategoryDto actualUpdateCategoryResult = categoryServiceImpl.updateCategory(categoryDto2, 1);

        // Assert
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(categoryRepo).findById(eq(1));
        verify(categoryRepo).save(isA(Category.class));
        assertSame(categoryDto, actualUpdateCategoryResult);
    }

    /**
     * Method under test:
     * {@link CategoryServiceImpl#updateCategory(CategoryDto, Integer)}
     */
    @Test
    void UpdateCategory_Test2() {
        // Arrange
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);

        Category category2 = new Category();
        category2.setCategoryDescription("Category Description");
        category2.setCategoryId(1);
        category2.setCategoryTitle("Dr");
        category2.setPosts(new ArrayList<>());
        when(categoryRepo.save(Mockito.<Category>any())).thenReturn(category2);
        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<CategoryDto>>any()))
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L));

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryDescription("Category Description");
        categoryDto.setCategoryId(1);
        categoryDto.setCategoryTitle("Dr");

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> categoryServiceImpl.updateCategory(categoryDto, 1));
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(categoryRepo).findById(eq(1));
        verify(categoryRepo).save(isA(Category.class));
    }

    /**
     * Method under test:
     * {@link CategoryServiceImpl#updateCategory(CategoryDto, Integer)}
     */
//    @Test
//    void UpdateCategory_Test3() {
//        // Arrange
//        Optional<Category> emptyResult = Optional.empty();
//        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setCategoryDescription("Category Description");
//        categoryDto.setCategoryId(1);
//        categoryDto.setCategoryTitle("Dr");
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Map");
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<CategoryDto>>any())).thenReturn(categoryDto);
//
//        CategoryDto categoryDto2 = new CategoryDto();
//        categoryDto2.setCategoryDescription("Category Description");
//        categoryDto2.setCategoryId(1);
//        categoryDto2.setCategoryTitle("Dr");
//
//        // Act and Assert
//        assertThrows(ResourceNotFoundException.class, () -> categoryServiceImpl.updateCategory(categoryDto2, 1));
//        verify(modelMapper).map(Mockito.<Object>any(), Mockito.<Class<Object>>any());
//        verify(categoryRepo).findById(eq(1));
//    }

    /**
     * Method under test: {@link CategoryServiceImpl#deleteCategory(Integer)}
     */
    @Test
    void DeleteCategory_Test() {
        // Arrange
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);
        doNothing().when(categoryRepo).delete(Mockito.<Category>any());
        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act
        categoryServiceImpl.deleteCategory(1);

        // Assert that nothing has changed
        verify(categoryRepo).delete(isA(Category.class));
        verify(categoryRepo).findById(eq(1));
    }

    /**
     * Method under test: {@link CategoryServiceImpl#deleteCategory(Integer)}
     */
    @Test
    void DeleteCategory_Test2() {
        // Arrange
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);
        doThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L)).when(categoryRepo)
                .delete(Mockito.<Category>any());
        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> categoryServiceImpl.deleteCategory(1));
        verify(categoryRepo).delete(isA(Category.class));
        verify(categoryRepo).findById(eq(1));
    }

    /**
     * Method under test: {@link CategoryServiceImpl#deleteCategory(Integer)}
     */
    @Test
    void DeleteCategory_Test3() {
        // Arrange
        Optional<Category> emptyResult = Optional.empty();
        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> categoryServiceImpl.deleteCategory(1));
        verify(categoryRepo).findById(eq(1));
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getCategory(Integer)}
     */
    @Test
    void GetCategory_Test() {
        // Arrange
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);
        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryDescription("Category Description");
        categoryDto.setCategoryId(1);
        categoryDto.setCategoryTitle("Dr");
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<CategoryDto>>any())).thenReturn(categoryDto);

        // Act
        CategoryDto actualCategory = categoryServiceImpl.getCategory(1);

        // Assert
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(categoryRepo).findById(eq(1));
        assertSame(categoryDto, actualCategory);
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getCategory(Integer)}
     */
    @Test
    void GetCategory_Test2() {
        // Arrange
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);
        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<CategoryDto>>any()))
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L));

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> categoryServiceImpl.getCategory(1));
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(categoryRepo).findById(eq(1));
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getCategory(Integer)}
     */
//    @Test
//    void GetCategory_Test3() {
//        // Arrange
//        Optional<Category> emptyResult = Optional.empty();
//        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setCategoryDescription("Category Description");
//        categoryDto.setCategoryId(1);
//        categoryDto.setCategoryTitle("Dr");
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Map");
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<CategoryDto>>any())).thenReturn(categoryDto);
//
//        // Act and Assert
//        assertThrows(ResourceNotFoundException.class, () -> categoryServiceImpl.getCategory(1));
//        verify(modelMapper).map(Mockito.<Object>any(), Mockito.<Class<Object>>any());
//        verify(categoryRepo).findById(eq(1));
//    }

    /**
     * Method under test: {@link CategoryServiceImpl#getCategories()}
     */
    @Test
    void GetCategories_Test() {
        // Arrange
        when(categoryRepo.findAll()).thenReturn(new ArrayList<>());

        // Act
        List<CategoryDto> actualCategories = categoryServiceImpl.getCategories();

        // Assert
        verify(categoryRepo).findAll();
        assertTrue(actualCategories.isEmpty());
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getCategories()}
     */
    @Test
    void GetCategories_Test2() {
        // Arrange
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        when(categoryRepo.findAll()).thenReturn(categoryList);

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryDescription("Category Description");
        categoryDto.setCategoryId(1);
        categoryDto.setCategoryTitle("Dr");
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<CategoryDto>>any())).thenReturn(categoryDto);

        // Act
        List<CategoryDto> actualCategories = categoryServiceImpl.getCategories();

        // Assert
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(categoryRepo).findAll();
        assertEquals(1, actualCategories.size());
        assertSame(categoryDto, actualCategories.get(0));
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getCategories()}
     */
    @Test
    void GetCategories_Test3() {
        // Arrange
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());

        Category category2 = new Category();
        category2.setCategoryDescription("42");
        category2.setCategoryId(2);
        category2.setCategoryTitle("Mr");
        category2.setPosts(new ArrayList<>());

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(category2);
        categoryList.add(category);
        when(categoryRepo.findAll()).thenReturn(categoryList);

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryDescription("Category Description");
        categoryDto.setCategoryId(1);
        categoryDto.setCategoryTitle("Dr");
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<CategoryDto>>any())).thenReturn(categoryDto);

        // Act
        List<CategoryDto> actualCategories = categoryServiceImpl.getCategories();

        // Assert
        verify(modelMapper, atLeast(1)).map(Mockito.<Object>any(), isA(Class.class));
        verify(categoryRepo).findAll();
        assertEquals(2, actualCategories.size());
        assertSame(categoryDto, actualCategories.get(0));
        assertSame(categoryDto, actualCategories.get(1));
    }

    /**
     * Method under test: {@link CategoryServiceImpl#getCategories()}
     */
    @Test
    void GetCategories_Test4() {
        // Arrange
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        when(categoryRepo.findAll()).thenReturn(categoryList);
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<CategoryDto>>any()))
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L));

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> categoryServiceImpl.getCategories());
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(categoryRepo).findAll();
    }
}
