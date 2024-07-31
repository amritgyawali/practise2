package com.amrit.blog.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.amrit.blog.payloads.CategoryDto;
import com.amrit.blog.payloads.PostDto;
import com.amrit.blog.payloads.PostResponse;
import com.amrit.blog.payloads.UserDto;
import com.amrit.blog.services.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

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

@ContextConfiguration(classes = {PostController.class})
@ExtendWith(SpringExtension.class)
class PostControllerTest {
    @Autowired
    private PostController postController;

    @MockBean
    private PostService postService;

    /**
     * Method under test:
     * {@link PostController#createPost(PostDto, Integer, Integer)}
     */
    @Test
    void CreatePost_Test() throws Exception {
        // Arrange
        CategoryDto category = new CategoryDto();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");

        UserDto user = new UserDto();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());

        PostDto postDto = new PostDto();
        postDto.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        postDto.setCategory(category);
        postDto.setContent("Not all who wander are lost");
        postDto.setPostId(1);
        postDto.setTitle("Dr");
        postDto.setUser(user);
        when(postService.createPost(Mockito.<PostDto>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
                .thenReturn(postDto);

        CategoryDto category2 = new CategoryDto();
        category2.setCategoryDescription("Category Description");
        category2.setCategoryId(1);
        category2.setCategoryTitle("Dr");

        UserDto user2 = new UserDto();
        user2.setAbout("About");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setRoles(new HashSet<>());

        PostDto postDto2 = new PostDto();
        postDto2.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        postDto2.setCategory(category2);
        postDto2.setContent("Not all who wander are lost");
        postDto2.setPostId(1);
        postDto2.setTitle("Dr");
        postDto2.setUser(user2);
        String content = (new ObjectMapper()).writeValueAsString(postDto2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/user/{userId}/category/{categoryId}/posts", 1, 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(postController).build().perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<PostDto><postId>1</postId><title>Dr</title><content>Not all who wander are lost</content><addedDate"
                                        + ">0</addedDate><category><categoryId>1</categoryId><categoryTitle>Dr</categoryTitle><categoryDescription"
                                        + ">Category Description</categoryDescription></category><user><id>1</id><name>Name</name><email>jane.doe"
                                        + "@example.org</email><about>About</about><roles/></user></PostDto>"));
    }

    /**
     * Method under test: {@link PostController#getPostsByUser(Integer)}
     */
    @Test
    void GetPostsByUser_Test() throws Exception {
        // Arrange
        when(postService.getPostsByUser(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/user/{userId}/posts", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("<List/>"));
    }

    /**
     * Method under test: {@link PostController#getPostsByUser(Integer)}
     */
    @Test
    void GetPostsByUser_Test2() throws Exception {
        // Arrange
        when(postService.getPostsByUser(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/user/{userId}/posts", 1);
        requestBuilder.characterEncoding("Encoding");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("<List/>"));
    }

    /**
     * Method under test: {@link PostController#getPostsByCategory(Integer)}
     */
    @Test
    void GetPostsByCategory_Test() throws Exception {
        // Arrange
        when(postService.getPostsByCategory(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/category/{categoryId}/posts", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("<List/>"));
    }

    /**
     * Method under test: {@link PostController#getPostsByCategory(Integer)}
     */
    @Test
    void GetPostsByCategory_Test2() throws Exception {
        // Arrange
        when(postService.getPostsByCategory(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/category/{categoryId}/posts", 1);
        requestBuilder.characterEncoding("Encoding");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("<List/>"));
    }

    /**
     * Method under test:
     * {@link PostController#getAllPost(Integer, Integer, String, String)}
     */
    @Test
    void GetAllPost_Test() throws Exception {
        // Arrange
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(new ArrayList<>());
        postResponse.setLastPage(true);
        postResponse.setPageNumber(10);
        postResponse.setPageSize(3);
        postResponse.setTotalElements(1L);
        postResponse.setTotalPages(1);
        when(postService.getAllPost(Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(),
                Mockito.<String>any())).thenReturn(postResponse);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/posts");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<PostResponse><content/><pageNumber>10</pageNumber><pageSize>3</pageSize><totalElements>1</totalElements"
                                        + "><totalPages>1</totalPages><lastPage>true</lastPage></PostResponse>"));
    }

    /**
     * Method under test: {@link PostController#getPostById(Integer)}
     */
    @Test
    void GetPostById_Test() throws Exception {
        // Arrange
        CategoryDto category = new CategoryDto();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");

        UserDto user = new UserDto();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());

        PostDto postDto = new PostDto();
        postDto.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        postDto.setCategory(category);
        postDto.setContent("Not all who wander are lost");
        postDto.setPostId(1);
        postDto.setTitle("Dr");
        postDto.setUser(user);
        when(postService.getPostById(Mockito.<Integer>any())).thenReturn(postDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/posts/{postId}", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<PostDto><postId>1</postId><title>Dr</title><content>Not all who wander are lost</content><addedDate"
                                        + ">0</addedDate><category><categoryId>1</categoryId><categoryTitle>Dr</categoryTitle><categoryDescription"
                                        + ">Category Description</categoryDescription></category><user><id>1</id><name>Name</name><email>jane.doe"
                                        + "@example.org</email><about>About</about><roles/></user></PostDto>"));
    }

    /**
     * Method under test: {@link PostController#deletePost(Integer)}
     */
    @Test
    void DeletePost_Test() throws Exception {
        // Arrange
        doNothing().when(postService).deletePost(Mockito.<Integer>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/posts/{postId}", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<ApiResponse><message>Post is successfully deleted !!</message><success>true</success></ApiResponse>"));
    }

    /**
     * Method under test: {@link PostController#deletePost(Integer)}
     */
    @Test
    void DeletePost_Test2() throws Exception {
        // Arrange
        doNothing().when(postService).deletePost(Mockito.<Integer>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/posts/{postId}", 1);
        requestBuilder.characterEncoding("Encoding");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<ApiResponse><message>Post is successfully deleted !!</message><success>true</success></ApiResponse>"));
    }

    /**
     * Method under test: {@link PostController#updatePost(PostDto, Integer)}
     */
    @Test
    void UpdatePost_Test() throws Exception {
        // Arrange
        CategoryDto category = new CategoryDto();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");

        UserDto user = new UserDto();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());

        PostDto postDto = new PostDto();
        postDto.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        postDto.setCategory(category);
        postDto.setContent("Not all who wander are lost");
        postDto.setPostId(1);
        postDto.setTitle("Dr");
        postDto.setUser(user);
        when(postService.updatePost(Mockito.<PostDto>any(), Mockito.<Integer>any())).thenReturn(postDto);

        CategoryDto category2 = new CategoryDto();
        category2.setCategoryDescription("Category Description");
        category2.setCategoryId(1);
        category2.setCategoryTitle("Dr");

        UserDto user2 = new UserDto();
        user2.setAbout("About");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setRoles(new HashSet<>());

        PostDto postDto2 = new PostDto();
        postDto2.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        postDto2.setCategory(category2);
        postDto2.setContent("Not all who wander are lost");
        postDto2.setPostId(1);
        postDto2.setTitle("Dr");
        postDto2.setUser(user2);
        String content = (new ObjectMapper()).writeValueAsString(postDto2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/posts/{postId}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<PostDto><postId>1</postId><title>Dr</title><content>Not all who wander are lost</content><addedDate"
                                        + ">0</addedDate><category><categoryId>1</categoryId><categoryTitle>Dr</categoryTitle><categoryDescription"
                                        + ">Category Description</categoryDescription></category><user><id>1</id><name>Name</name><email>jane.doe"
                                        + "@example.org</email><about>About</about><roles/></user></PostDto>"));
    }

    /**
     * Method under test: {@link PostController#searchPostByTitle(String)}
     */
    @Test
    void SearchPostByTitle_Test() throws Exception {
        // Arrange
        when(postService.searchPosts(Mockito.<String>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/posts/search/{keywords}",
                "Keywords");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("<List/>"));
    }

    /**
     * Method under test: {@link PostController#searchPostByTitle(String)}
     */
    @Test
    void SearchPostByTitle_Test2() throws Exception {
        // Arrange
        when(postService.searchPosts(Mockito.<String>any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/posts/search/{keywords}",
                "Keywords");
        requestBuilder.characterEncoding("Encoding");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("<List/>"));
    }
}
