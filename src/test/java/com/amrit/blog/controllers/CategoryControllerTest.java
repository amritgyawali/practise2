package com.amrit.blog.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.amrit.blog.payloads.CategoryDto;
import com.amrit.blog.services.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CategoryController.class})
@ExtendWith(SpringExtension.class)
class CategoryControllerTest {
    @Autowired
    private CategoryController categoryController;

    @MockBean
    private CategoryService categoryService;

    /**
     * Method under test: {@link CategoryController#createCategory(CategoryDto)}
     */
    @Test
    void CreateCategory_Test() throws Exception {
        // Arrange
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryDescription("Category Description");
        categoryDto.setCategoryId(1);
        categoryDto.setCategoryTitle("Dr");
        String content = (new ObjectMapper()).writeValueAsString(categoryDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/categories/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(categoryController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link CategoryController#createCategory(CategoryDto)}
     */
    @Test
    void CreateCategory_Test2() throws Exception {
        // Arrange
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryDescription("Category Description");
        categoryDto.setCategoryId(1);
        categoryDto.setCategoryTitle("Dr");
        when(categoryService.createCategory(Mockito.<CategoryDto>any())).thenReturn(categoryDto);

        CategoryDto categoryDto2 = new CategoryDto();
        categoryDto2.setCategoryDescription("Category Description");
        categoryDto2.setCategoryId(1);
        categoryDto2.setCategoryTitle("Prof");
        String content = (new ObjectMapper()).writeValueAsString(categoryDto2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/categories/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(categoryController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<CategoryDto><categoryId>1</categoryId><categoryTitle>Dr</categoryTitle><categoryDescription>Category"
                                        + " Description</categoryDescription></CategoryDto>"));
    }

    /**
     * Method under test:
     * {@link CategoryController#updateCategory(CategoryDto, Integer)}
     */
    @Test
    void UpdateCategory_Test2() throws Exception {
        // Arrange
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryDescription("Category Description");
        categoryDto.setCategoryId(1);
        categoryDto.setCategoryTitle("Dr");
        when(categoryService.updateCategory(Mockito.<CategoryDto>any(), Mockito.<Integer>any())).thenReturn(categoryDto);

        CategoryDto categoryDto2 = new CategoryDto();
        categoryDto2.setCategoryDescription("Category Description");
        categoryDto2.setCategoryId(1);
        categoryDto2.setCategoryTitle("Prof");
        String content = (new ObjectMapper()).writeValueAsString(categoryDto2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/categories/{catId}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(categoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<CategoryDto><categoryId>1</categoryId><categoryTitle>Dr</categoryTitle><categoryDescription>Category"
                                        + " Description</categoryDescription></CategoryDto>"));
    }

    /**
     * Method under test: {@link CategoryController#deleteCategory(Integer)}
     */
    @Test
    void DeleteCategory_Test() throws Exception {
        // Arrange
        doNothing().when(categoryService).deleteCategory(Mockito.<Integer>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/categories/{catId}", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(categoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("<ApiResponse><message>category is deleted successfully !!</message><success>true</success><"
                                + "/ApiResponse>"));
    }

    /**
     * Method under test: {@link CategoryController#deleteCategory(Integer)}
     */
    @Test
    void DeleteCategory_Test2() throws Exception {
        // Arrange
        doNothing().when(categoryService).deleteCategory(Mockito.<Integer>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/categories/{catId}", 1);
        requestBuilder.characterEncoding("Encoding");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(categoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("<ApiResponse><message>category is deleted successfully !!</message><success>true</success><"
                                + "/ApiResponse>"));
    }

    /**
     * Method under test: {@link CategoryController#getCategory(Integer)}
     */
    @Test
    void GetCategory_Test() throws Exception {
        // Arrange
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryDescription("Category Description");
        categoryDto.setCategoryId(1);
        categoryDto.setCategoryTitle("Dr");
        when(categoryService.getCategory(Mockito.<Integer>any())).thenReturn(categoryDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/categories/{catId}", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(categoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<CategoryDto><categoryId>1</categoryId><categoryTitle>Dr</categoryTitle><categoryDescription>Category"
                                        + " Description</categoryDescription></CategoryDto>"));
    }

    /**
     * Method under test: {@link CategoryController#getCategories()}
     */
    @Test
    void GetCategories_Test() throws Exception {
        // Arrange
        when(categoryService.getCategories()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/categories/");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(categoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("<List/>"));
    }

    /**
     * Method under test: {@link CategoryController#getCategories()}
     */
    @Test
    void GetCategories_Test2() throws Exception {
        // Arrange
        when(categoryService.getCategories()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/categories/");
        requestBuilder.characterEncoding("Encoding");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(categoryController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("<List/>"));
    }

    /**
     * Method under test:
     * {@link CategoryController#updateCategory(CategoryDto, Integer)}
     */
    @Test
    void UpdateCategory_Test() throws Exception {
        // Arrange
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryDescription("Category Description");
        categoryDto.setCategoryId(1);
        categoryDto.setCategoryTitle("Dr");
        String content = (new ObjectMapper()).writeValueAsString(categoryDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/categories/{catId}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(categoryController)
                .build()
                .perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}
