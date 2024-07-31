package com.amrit.blog.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amrit.blog.entities.Category;
import com.amrit.blog.entities.Post;
import com.amrit.blog.entities.User;
import com.amrit.blog.exceptions.ResourceNotFoundException;
import com.amrit.blog.payloads.CategoryDto;
import com.amrit.blog.payloads.PostDto;
import com.amrit.blog.payloads.PostResponse;
import com.amrit.blog.payloads.UserDto;
import com.amrit.blog.repositories.CategoryRepo;
import com.amrit.blog.repositories.PostRepo;
import com.amrit.blog.repositories.UserRepo;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PostServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PostServiceImplTest {
    @MockBean
    private CategoryRepo categoryRepo;

    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private PostRepo postRepo;

    @Autowired
    private PostServiceImpl postServiceImpl;

    @MockBean
    private UserRepo userRepo;

    /**
     * Method under test:
     * {@link PostServiceImpl#createPost(PostDto, Integer, Integer)}
     */
    @Test
    void CreatePost_Test() {
        // Arrange
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);
        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        Category category2 = new Category();
        category2.setCategoryDescription("Category Description");
        category2.setCategoryId(1);
        category2.setCategoryTitle("Dr");
        category2.setPosts(new ArrayList<>());

        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());

        Post post = new Post();
        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post.setCategory(category2);
        post.setContent("Not all who wander are lost");
        post.setPostId(1);
        post.setTitle("Dr");
        post.setUser(user);
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Post>>any())).thenReturn(post);
        when(postRepo.save(Mockito.<Post>any()))
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L));

        User user2 = new User();
        user2.setAbout("About");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setPosts(new ArrayList<>());
        user2.setRoles(new HashSet<>());
        Optional<User> ofResult2 = Optional.of(user2);
        when(userRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult2);

        CategoryDto category3 = new CategoryDto();
        category3.setCategoryDescription("Category Description");
        category3.setCategoryId(1);
        category3.setCategoryTitle("Dr");

        UserDto user3 = new UserDto();
        user3.setAbout("About");
        user3.setEmail("jane.doe@example.org");
        user3.setId(1);
        user3.setName("Name");
        user3.setPassword("iloveyou");
        user3.setRoles(new HashSet<>());

        PostDto postDto = new PostDto();
        postDto.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        postDto.setCategory(category3);
        postDto.setContent("Not all who wander are lost");
        postDto.setPostId(1);
        postDto.setTitle("Dr");
        postDto.setUser(user3);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> postServiceImpl.createPost(postDto, 1, 1));
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(categoryRepo).findById(eq(1));
        verify(userRepo).findById(eq(1));
        verify(postRepo).save(isA(Post.class));
    }

    /**
     * Method under test:
     * {@link PostServiceImpl#createPost(PostDto, Integer, Integer)}
     */
//    @Test
//    void CreatePost_Test2() {
//        // Arrange
//        Optional<Category> emptyResult = Optional.empty();
//        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
//
//        Category category = new Category();
//        category.setCategoryDescription("Category Description");
//        category.setCategoryId(1);
//        category.setCategoryTitle("Dr");
//        category.setPosts(new ArrayList<>());
//
//        User user = new User();
//        user.setAbout("About");
//        user.setEmail("jane.doe@example.org");
//        user.setId(1);
//        user.setName("Name");
//        user.setPassword("iloveyou");
//        user.setPosts(new ArrayList<>());
//        user.setRoles(new HashSet<>());
//
//        Post post = new Post();
//        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
//        post.setCategory(category);
//        post.setContent("Not all who wander are lost");
//        post.setPostId(1);
//        post.setTitle("Dr");
//        post.setUser(user);
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Map");
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Post>>any())).thenReturn(post);
//
//        User user2 = new User();
//        user2.setAbout("About");
//        user2.setEmail("jane.doe@example.org");
//        user2.setId(1);
//        user2.setName("Name");
//        user2.setPassword("iloveyou");
//        user2.setPosts(new ArrayList<>());
//        user2.setRoles(new HashSet<>());
//        Optional<User> ofResult = Optional.of(user2);
//        when(userRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);
//
//        CategoryDto category2 = new CategoryDto();
//        category2.setCategoryDescription("Category Description");
//        category2.setCategoryId(1);
//        category2.setCategoryTitle("Dr");
//
//        UserDto user3 = new UserDto();
//        user3.setAbout("About");
//        user3.setEmail("jane.doe@example.org");
//        user3.setId(1);
//        user3.setName("Name");
//        user3.setPassword("iloveyou");
//        user3.setRoles(new HashSet<>());
//
//        PostDto postDto = new PostDto();
//        postDto.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
//        postDto.setCategory(category2);
//        postDto.setContent("Not all who wander are lost");
//        postDto.setPostId(1);
//        postDto.setTitle("Dr");
//        postDto.setUser(user3);
//
//        // Act and Assert
//        assertThrows(ResourceNotFoundException.class, () -> postServiceImpl.createPost(postDto, 1, 1));
//        verify(modelMapper).map(Mockito.<Object>any(), Mockito.<Class<Object>>any());
//        verify(categoryRepo).findById(eq(1));
//        verify(userRepo).findById(eq(1));
//    }

    /**
     * Method under test: {@link PostServiceImpl#updatePost(PostDto, Integer)}
     */
    @Test
    void UpdatePost_Test() {
        // Arrange
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);
        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        CategoryDto category2 = new CategoryDto();
        category2.setCategoryDescription("Category Description");
        category2.setCategoryId(1);
        category2.setCategoryTitle("Dr");

        UserDto user = new UserDto();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());

        PostDto postDto = new PostDto();
        postDto.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        postDto.setCategory(category2);
        postDto.setContent("Not all who wander are lost");
        postDto.setPostId(1);
        postDto.setTitle("Dr");
        postDto.setUser(user);
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<PostDto>>any())).thenReturn(postDto);

        Category category3 = new Category();
        category3.setCategoryDescription("Category Description");
        category3.setCategoryId(1);
        category3.setCategoryTitle("Dr");
        category3.setPosts(new ArrayList<>());

        User user2 = new User();
        user2.setAbout("About");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setPosts(new ArrayList<>());
        user2.setRoles(new HashSet<>());

        Post post = new Post();
        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post.setCategory(category3);
        post.setContent("Not all who wander are lost");
        post.setPostId(1);
        post.setTitle("Dr");
        post.setUser(user2);
        Optional<Post> ofResult2 = Optional.of(post);

        Category category4 = new Category();
        category4.setCategoryDescription("Category Description");
        category4.setCategoryId(1);
        category4.setCategoryTitle("Dr");
        category4.setPosts(new ArrayList<>());

        User user3 = new User();
        user3.setAbout("About");
        user3.setEmail("jane.doe@example.org");
        user3.setId(1);
        user3.setName("Name");
        user3.setPassword("iloveyou");
        user3.setPosts(new ArrayList<>());
        user3.setRoles(new HashSet<>());

        Post post2 = new Post();
        post2.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post2.setCategory(category4);
        post2.setContent("Not all who wander are lost");
        post2.setPostId(1);
        post2.setTitle("Dr");
        post2.setUser(user3);
        when(postRepo.save(Mockito.<Post>any())).thenReturn(post2);
        when(postRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult2);

        CategoryDto category5 = new CategoryDto();
        category5.setCategoryDescription("Category Description");
        category5.setCategoryId(1);
        category5.setCategoryTitle("Dr");

        UserDto user4 = new UserDto();
        user4.setAbout("About");
        user4.setEmail("jane.doe@example.org");
        user4.setId(1);
        user4.setName("Name");
        user4.setPassword("iloveyou");
        user4.setRoles(new HashSet<>());

        PostDto postDto2 = new PostDto();
        postDto2.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        postDto2.setCategory(category5);
        postDto2.setContent("Not all who wander are lost");
        postDto2.setPostId(1);
        postDto2.setTitle("Dr");
        postDto2.setUser(user4);

        // Act
        PostDto actualUpdatePostResult = postServiceImpl.updatePost(postDto2, 1);

        // Assert
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(categoryRepo).findById(eq(1));
        verify(postRepo).findById(eq(1));
        verify(postRepo).save(isA(Post.class));
        assertSame(postDto, actualUpdatePostResult);
    }

    /**
     * Method under test: {@link PostServiceImpl#updatePost(PostDto, Integer)}
     */
//    @Test
//    void UpdatePost_Test2() {
//        // Arrange
//        Category category = new Category();
//        category.setCategoryDescription("Category Description");
//        category.setCategoryId(1);
//        category.setCategoryTitle("Dr");
//        category.setPosts(new ArrayList<>());
//        Optional<Category> ofResult = Optional.of(category);
//        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);
//
//        CategoryDto category2 = new CategoryDto();
//        category2.setCategoryDescription("Category Description");
//        category2.setCategoryId(1);
//        category2.setCategoryTitle("Dr");
//
//        UserDto user = new UserDto();
//        user.setAbout("About");
//        user.setEmail("jane.doe@example.org");
//        user.setId(1);
//        user.setName("Name");
//        user.setPassword("iloveyou");
//        user.setRoles(new HashSet<>());
//
//        PostDto postDto = new PostDto();
//        postDto.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
//        postDto.setCategory(category2);
//        postDto.setContent("Not all who wander are lost");
//        postDto.setPostId(1);
//        postDto.setTitle("Dr");
//        postDto.setUser(user);
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Map");
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<PostDto>>any())).thenReturn(postDto);
//
//        Category category3 = new Category();
//        category3.setCategoryDescription("Category Description");
//        category3.setCategoryId(1);
//        category3.setCategoryTitle("Dr");
//        category3.setPosts(new ArrayList<>());
//
//        User user2 = new User();
//        user2.setAbout("About");
//        user2.setEmail("jane.doe@example.org");
//        user2.setId(1);
//        user2.setName("Name");
//        user2.setPassword("iloveyou");
//        user2.setPosts(new ArrayList<>());
//        user2.setRoles(new HashSet<>());
//
//        Post post = new Post();
//        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
//        post.setCategory(category3);
//        post.setContent("Not all who wander are lost");
//        post.setPostId(1);
//        post.setTitle("Dr");
//        post.setUser(user2);
//        Optional<Post> ofResult2 = Optional.of(post);
//        when(postRepo.save(Mockito.<Post>any()))
//                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L));
//        when(postRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult2);
//
//        CategoryDto category4 = new CategoryDto();
//        category4.setCategoryDescription("Category Description");
//        category4.setCategoryId(1);
//        category4.setCategoryTitle("Dr");
//
//        UserDto user3 = new UserDto();
//        user3.setAbout("About");
//        user3.setEmail("jane.doe@example.org");
//        user3.setId(1);
//        user3.setName("Name");
//        user3.setPassword("iloveyou");
//        user3.setRoles(new HashSet<>());
//
//        PostDto postDto2 = new PostDto();
//        postDto2.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
//        postDto2.setCategory(category4);
//        postDto2.setContent("Not all who wander are lost");
//        postDto2.setPostId(1);
//        postDto2.setTitle("Dr");
//        postDto2.setUser(user3);
//
//        // Act and Assert
//        assertThrows(ResourceNotFoundException.class, () -> postServiceImpl.updatePost(postDto2, 1));
//        verify(modelMapper).map(Mockito.<Object>any(), Mockito.<Class<Object>>any());
//        verify(categoryRepo).findById(eq(1));
//        verify(postRepo).findById(eq(1));
//        verify(postRepo).save(isA(Post.class));
//    }

    /**
     * Method under test: {@link PostServiceImpl#deletePost(Integer)}
     */
    @Test
    void DeletePost_Test() {
        // Arrange
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());

        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());

        Post post = new Post();
        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post.setCategory(category);
        post.setContent("Not all who wander are lost");
        post.setPostId(1);
        post.setTitle("Dr");
        post.setUser(user);
        Optional<Post> ofResult = Optional.of(post);
        doNothing().when(postRepo).delete(Mockito.<Post>any());
        when(postRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act
        postServiceImpl.deletePost(1);

        // Assert that nothing has changed
        verify(postRepo).delete(isA(Post.class));
        verify(postRepo).findById(eq(1));
    }

    /**
     * Method under test: {@link PostServiceImpl#deletePost(Integer)}
     */
    @Test
    void DeletePost_Test2() {
        // Arrange
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());

        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());

        Post post = new Post();
        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post.setCategory(category);
        post.setContent("Not all who wander are lost");
        post.setPostId(1);
        post.setTitle("Dr");
        post.setUser(user);
        Optional<Post> ofResult = Optional.of(post);
        doThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L)).when(postRepo)
                .delete(Mockito.<Post>any());
        when(postRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> postServiceImpl.deletePost(1));
        verify(postRepo).delete(isA(Post.class));
        verify(postRepo).findById(eq(1));
    }

    /**
     * Method under test: {@link PostServiceImpl#deletePost(Integer)}
     */
    @Test
    void DeletePost_Test3() {
        // Arrange
        Optional<Post> emptyResult = Optional.empty();
        when(postRepo.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> postServiceImpl.deletePost(1));
        verify(postRepo).findById(eq(1));
    }

    /**
     * Method under test:
     * {@link PostServiceImpl#getAllPost(Integer, Integer, String, String)}
     */
    @Test
    void GetAllPost_Test() {
        // Arrange
        when(postRepo.findAll(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

        // Act
        PostResponse actualAllPost = postServiceImpl.getAllPost(10, 3, "Sort By", "Sort Dir");

        // Assert
        verify(postRepo).findAll(isA(Pageable.class));
        assertEquals(0, actualAllPost.getPageNumber());
        assertEquals(0, actualAllPost.getPageSize());
        assertEquals(0L, actualAllPost.getTotalElements());
        assertEquals(1, actualAllPost.getTotalPages());
        assertTrue(actualAllPost.isLastPage());
        assertTrue(actualAllPost.getContent().isEmpty());
    }

    /**
     * Method under test:
     * {@link PostServiceImpl#getAllPost(Integer, Integer, String, String)}
     */
    @Test
    void GetAllPost_Test2() {
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
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<PostDto>>any())).thenReturn(postDto);

        Category category2 = new Category();
        category2.setCategoryDescription("asc");
        category2.setCategoryId(1);
        category2.setCategoryTitle("Dr");
        category2.setPosts(new ArrayList<>());

        User user2 = new User();
        user2.setAbout("asc");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("asc");
        user2.setPassword("iloveyou");
        user2.setPosts(new ArrayList<>());
        user2.setRoles(new HashSet<>());

        Post post = new Post();
        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post.setCategory(category2);
        post.setContent("Not all who wander are lost");
        post.setPostId(1);
        post.setTitle("Dr");
        post.setUser(user2);

        ArrayList<Post> content = new ArrayList<>();
        content.add(post);
        PageImpl<Post> pageImpl = new PageImpl<>(content);
        when(postRepo.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

        // Act
        PostResponse actualAllPost = postServiceImpl.getAllPost(10, 3, "Sort By", "Sort Dir");

        // Assert
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(postRepo).findAll(isA(Pageable.class));
        assertEquals(0, actualAllPost.getPageNumber());
        assertEquals(1, actualAllPost.getPageSize());
        assertEquals(1, actualAllPost.getTotalPages());
        List<PostDto> content2 = actualAllPost.getContent();
        assertEquals(1, content2.size());
        assertEquals(1L, actualAllPost.getTotalElements());
        assertTrue(actualAllPost.isLastPage());
        assertSame(postDto, content2.get(0));
    }

    /**
     * Method under test:
     * {@link PostServiceImpl#getAllPost(Integer, Integer, String, String)}
     */
    @Test
    void GetAllPost_Test3() {
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
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<PostDto>>any())).thenReturn(postDto);

        Category category2 = new Category();
        category2.setCategoryDescription("asc");
        category2.setCategoryId(1);
        category2.setCategoryTitle("Dr");
        category2.setPosts(new ArrayList<>());

        User user2 = new User();
        user2.setAbout("asc");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("asc");
        user2.setPassword("iloveyou");
        user2.setPosts(new ArrayList<>());
        user2.setRoles(new HashSet<>());

        Post post = new Post();
        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post.setCategory(category2);
        post.setContent("Not all who wander are lost");
        post.setPostId(1);
        post.setTitle("Dr");
        post.setUser(user2);

        Category category3 = new Category();
        category3.setCategoryDescription("Category Description");
        category3.setCategoryId(2);
        category3.setCategoryTitle("Mr");
        category3.setPosts(new ArrayList<>());

        User user3 = new User();
        user3.setAbout("About");
        user3.setEmail("john.smith@example.org");
        user3.setId(2);
        user3.setName("Name");
        user3.setPassword("asc");
        user3.setPosts(new ArrayList<>());
        user3.setRoles(new HashSet<>());

        Post post2 = new Post();
        post2.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post2.setCategory(category3);
        post2.setContent("asc");
        post2.setPostId(2);
        post2.setTitle("Mr");
        post2.setUser(user3);

        ArrayList<Post> content = new ArrayList<>();
        content.add(post2);
        content.add(post);
        PageImpl<Post> pageImpl = new PageImpl<>(content);
        when(postRepo.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

        // Act
        PostResponse actualAllPost = postServiceImpl.getAllPost(10, 3, "Sort By", "Sort Dir");

        // Assert
        verify(modelMapper, atLeast(1)).map(Mockito.<Object>any(), isA(Class.class));
        verify(postRepo).findAll(isA(Pageable.class));
        assertEquals(0, actualAllPost.getPageNumber());
        assertEquals(1, actualAllPost.getTotalPages());
        assertEquals(2, actualAllPost.getPageSize());
        List<PostDto> content2 = actualAllPost.getContent();
        assertEquals(2, content2.size());
        assertEquals(2L, actualAllPost.getTotalElements());
        assertTrue(actualAllPost.isLastPage());
        assertSame(postDto, content2.get(0));
        assertSame(postDto, content2.get(1));
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostById(Integer)}
     */
    @Test
    void GetPostById_Test() {
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
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<PostDto>>any())).thenReturn(postDto);

        Category category2 = new Category();
        category2.setCategoryDescription("Category Description");
        category2.setCategoryId(1);
        category2.setCategoryTitle("Dr");
        category2.setPosts(new ArrayList<>());

        User user2 = new User();
        user2.setAbout("About");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setPosts(new ArrayList<>());
        user2.setRoles(new HashSet<>());

        Post post = new Post();
        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post.setCategory(category2);
        post.setContent("Not all who wander are lost");
        post.setPostId(1);
        post.setTitle("Dr");
        post.setUser(user2);
        Optional<Post> ofResult = Optional.of(post);
        when(postRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act
        PostDto actualPostById = postServiceImpl.getPostById(1);

        // Assert
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(postRepo).findById(eq(1));
        assertSame(postDto, actualPostById);
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostById(Integer)}
     */
    @Test
    void GetPostById_Test2() {
        // Arrange
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<PostDto>>any()))
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L));

        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());

        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());

        Post post = new Post();
        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post.setCategory(category);
        post.setContent("Not all who wander are lost");
        post.setPostId(1);
        post.setTitle("Dr");
        post.setUser(user);
        Optional<Post> ofResult = Optional.of(post);
        when(postRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> postServiceImpl.getPostById(1));
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(postRepo).findById(eq(1));
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostById(Integer)}
     */
//    @Test
//    void GetPostById_Test3() {
//        // Arrange
//        CategoryDto category = new CategoryDto();
//        category.setCategoryDescription("Category Description");
//        category.setCategoryId(1);
//        category.setCategoryTitle("Dr");
//
//        UserDto user = new UserDto();
//        user.setAbout("About");
//        user.setEmail("jane.doe@example.org");
//        user.setId(1);
//        user.setName("Name");
//        user.setPassword("iloveyou");
//        user.setRoles(new HashSet<>());
//
//        PostDto postDto = new PostDto();
//        postDto.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
//        postDto.setCategory(category);
//        postDto.setContent("Not all who wander are lost");
//        postDto.setPostId(1);
//        postDto.setTitle("Dr");
//        postDto.setUser(user);
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<Object>>any())).thenReturn("Map");
//        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<PostDto>>any())).thenReturn(postDto);
//        Optional<Post> emptyResult = Optional.empty();
//        when(postRepo.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
//
//        // Act and Assert
//        assertThrows(ResourceNotFoundException.class, () -> postServiceImpl.getPostById(1));
//        verify(modelMapper).map(Mockito.<Object>any(), Mockito.<Class<Object>>any());
//        verify(postRepo).findById(eq(1));
//    }

    /**
     * Method under test: {@link PostServiceImpl#getPostsByCategory(Integer)}
     */
    @Test
    void GetPostsByCategory_Test() {
        // Arrange
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);
        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        when(postRepo.findByCategory(Mockito.<Category>any())).thenReturn(new ArrayList<>());

        // Act
        List<PostDto> actualPostsByCategory = postServiceImpl.getPostsByCategory(1);

        // Assert
        verify(postRepo).findByCategory(isA(Category.class));
        verify(categoryRepo).findById(eq(1));
        assertTrue(actualPostsByCategory.isEmpty());
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostsByCategory(Integer)}
     */
    @Test
    void GetPostsByCategory_Test2() {
        // Arrange
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);
        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        when(postRepo.findByCategory(Mockito.<Category>any()))
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L));

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> postServiceImpl.getPostsByCategory(1));
        verify(postRepo).findByCategory(isA(Category.class));
        verify(categoryRepo).findById(eq(1));
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostsByCategory(Integer)}
     */
    @Test
    void GetPostsByCategory_Test3() {
        // Arrange
        Optional<Category> emptyResult = Optional.empty();
        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> postServiceImpl.getPostsByCategory(1));
        verify(categoryRepo).findById(eq(1));
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostsByCategory(Integer)}
     */
    @Test
    void GetPostsByCategory_Test4() {
        // Arrange
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);
        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        CategoryDto category2 = new CategoryDto();
        category2.setCategoryDescription("Category Description");
        category2.setCategoryId(1);
        category2.setCategoryTitle("Dr");

        UserDto user = new UserDto();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());

        PostDto postDto = new PostDto();
        postDto.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        postDto.setCategory(category2);
        postDto.setContent("Not all who wander are lost");
        postDto.setPostId(1);
        postDto.setTitle("Dr");
        postDto.setUser(user);
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<PostDto>>any())).thenReturn(postDto);

        Category category3 = new Category();
        category3.setCategoryDescription("Category Description");
        category3.setCategoryId(1);
        category3.setCategoryTitle("Dr");
        category3.setPosts(new ArrayList<>());

        User user2 = new User();
        user2.setAbout("About");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setPosts(new ArrayList<>());
        user2.setRoles(new HashSet<>());

        Post post = new Post();
        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post.setCategory(category3);
        post.setContent("Not all who wander are lost");
        post.setPostId(1);
        post.setTitle("Dr");
        post.setUser(user2);

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(post);
        when(postRepo.findByCategory(Mockito.<Category>any())).thenReturn(postList);

        // Act
        List<PostDto> actualPostsByCategory = postServiceImpl.getPostsByCategory(1);

        // Assert
        verify(postRepo).findByCategory(isA(Category.class));
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(categoryRepo).findById(eq(1));
        assertEquals(1, actualPostsByCategory.size());
        assertSame(postDto, actualPostsByCategory.get(0));
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostsByCategory(Integer)}
     */
    @Test
    void GetPostsByCategory_Test5() {
        // Arrange
        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());
        Optional<Category> ofResult = Optional.of(category);
        when(categoryRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        CategoryDto category2 = new CategoryDto();
        category2.setCategoryDescription("Category Description");
        category2.setCategoryId(1);
        category2.setCategoryTitle("Dr");

        UserDto user = new UserDto();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new HashSet<>());

        PostDto postDto = new PostDto();
        postDto.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        postDto.setCategory(category2);
        postDto.setContent("Not all who wander are lost");
        postDto.setPostId(1);
        postDto.setTitle("Dr");
        postDto.setUser(user);
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<PostDto>>any())).thenReturn(postDto);

        Category category3 = new Category();
        category3.setCategoryDescription("Category Description");
        category3.setCategoryId(1);
        category3.setCategoryTitle("Dr");
        category3.setPosts(new ArrayList<>());

        User user2 = new User();
        user2.setAbout("About");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setPosts(new ArrayList<>());
        user2.setRoles(new HashSet<>());

        Post post = new Post();
        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post.setCategory(category3);
        post.setContent("Not all who wander are lost");
        post.setPostId(1);
        post.setTitle("Dr");
        post.setUser(user2);

        Category category4 = new Category();
        category4.setCategoryDescription("42");
        category4.setCategoryId(2);
        category4.setCategoryTitle("Mr");
        category4.setPosts(new ArrayList<>());

        User user3 = new User();
        user3.setAbout("42");
        user3.setEmail("john.smith@example.org");
        user3.setId(2);
        user3.setName("42");
        user3.setPassword("Password");
        user3.setPosts(new ArrayList<>());
        user3.setRoles(new HashSet<>());

        Post post2 = new Post();
        post2.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post2.setCategory(category4);
        post2.setContent("Content");
        post2.setPostId(2);
        post2.setTitle("Mr");
        post2.setUser(user3);

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(post2);
        postList.add(post);
        when(postRepo.findByCategory(Mockito.<Category>any())).thenReturn(postList);

        // Act
        List<PostDto> actualPostsByCategory = postServiceImpl.getPostsByCategory(1);

        // Assert
        verify(postRepo).findByCategory(isA(Category.class));
        verify(modelMapper, atLeast(1)).map(Mockito.<Object>any(), isA(Class.class));
        verify(categoryRepo).findById(eq(1));
        assertEquals(2, actualPostsByCategory.size());
        assertSame(postDto, actualPostsByCategory.get(0));
        assertSame(postDto, actualPostsByCategory.get(1));
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostsByUser(Integer)}
     */
    @Test
    void GetPostsByUser_Test() {
        // Arrange
        when(postRepo.findByUser(Mockito.<User>any())).thenReturn(new ArrayList<>());

        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());
        Optional<User> ofResult = Optional.of(user);
        when(userRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act
        List<PostDto> actualPostsByUser = postServiceImpl.getPostsByUser(1);

        // Assert
        verify(postRepo).findByUser(isA(User.class));
        verify(userRepo).findById(eq(1));
        assertTrue(actualPostsByUser.isEmpty());
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostsByUser(Integer)}
     */
    @Test
    void GetPostsByUser_Test2() {
        // Arrange
        when(postRepo.findByUser(Mockito.<User>any()))
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L));

        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());
        Optional<User> ofResult = Optional.of(user);
        when(userRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> postServiceImpl.getPostsByUser(1));
        verify(postRepo).findByUser(isA(User.class));
        verify(userRepo).findById(eq(1));
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostsByUser(Integer)}
     */
    @Test
    void GetPostsByUser_Test3() {
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
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<PostDto>>any())).thenReturn(postDto);

        Category category2 = new Category();
        category2.setCategoryDescription("Category Description");
        category2.setCategoryId(1);
        category2.setCategoryTitle("Dr");
        category2.setPosts(new ArrayList<>());

        User user2 = new User();
        user2.setAbout("About");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setPosts(new ArrayList<>());
        user2.setRoles(new HashSet<>());

        Post post = new Post();
        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post.setCategory(category2);
        post.setContent("Not all who wander are lost");
        post.setPostId(1);
        post.setTitle("Dr");
        post.setUser(user2);

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(post);
        when(postRepo.findByUser(Mockito.<User>any())).thenReturn(postList);

        User user3 = new User();
        user3.setAbout("About");
        user3.setEmail("jane.doe@example.org");
        user3.setId(1);
        user3.setName("Name");
        user3.setPassword("iloveyou");
        user3.setPosts(new ArrayList<>());
        user3.setRoles(new HashSet<>());
        Optional<User> ofResult = Optional.of(user3);
        when(userRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act
        List<PostDto> actualPostsByUser = postServiceImpl.getPostsByUser(1);

        // Assert
        verify(postRepo).findByUser(isA(User.class));
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        verify(userRepo).findById(eq(1));
        assertEquals(1, actualPostsByUser.size());
        assertSame(postDto, actualPostsByUser.get(0));
    }

    /**
     * Method under test: {@link PostServiceImpl#getPostsByUser(Integer)}
     */
    @Test
    void GetPostsByUser_Test4() {
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
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<PostDto>>any())).thenReturn(postDto);

        Category category2 = new Category();
        category2.setCategoryDescription("Category Description");
        category2.setCategoryId(1);
        category2.setCategoryTitle("Dr");
        category2.setPosts(new ArrayList<>());

        User user2 = new User();
        user2.setAbout("About");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setPosts(new ArrayList<>());
        user2.setRoles(new HashSet<>());

        Post post = new Post();
        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post.setCategory(category2);
        post.setContent("Not all who wander are lost");
        post.setPostId(1);
        post.setTitle("Dr");
        post.setUser(user2);

        Category category3 = new Category();
        category3.setCategoryDescription("42");
        category3.setCategoryId(2);
        category3.setCategoryTitle("Mr");
        category3.setPosts(new ArrayList<>());

        User user3 = new User();
        user3.setAbout("42");
        user3.setEmail("john.smith@example.org");
        user3.setId(2);
        user3.setName("42");
        user3.setPassword("Password");
        user3.setPosts(new ArrayList<>());
        user3.setRoles(new HashSet<>());

        Post post2 = new Post();
        post2.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post2.setCategory(category3);
        post2.setContent("Content");
        post2.setPostId(2);
        post2.setTitle("Mr");
        post2.setUser(user3);

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(post2);
        postList.add(post);
        when(postRepo.findByUser(Mockito.<User>any())).thenReturn(postList);

        User user4 = new User();
        user4.setAbout("About");
        user4.setEmail("jane.doe@example.org");
        user4.setId(1);
        user4.setName("Name");
        user4.setPassword("iloveyou");
        user4.setPosts(new ArrayList<>());
        user4.setRoles(new HashSet<>());
        Optional<User> ofResult = Optional.of(user4);
        when(userRepo.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act
        List<PostDto> actualPostsByUser = postServiceImpl.getPostsByUser(1);

        // Assert
        verify(postRepo).findByUser(isA(User.class));
        verify(modelMapper, atLeast(1)).map(Mockito.<Object>any(), isA(Class.class));
        verify(userRepo).findById(eq(1));
        assertEquals(2, actualPostsByUser.size());
        assertSame(postDto, actualPostsByUser.get(0));
        assertSame(postDto, actualPostsByUser.get(1));
    }

    /**
     * Method under test: {@link PostServiceImpl#searchPosts(String)}
     */
    @Test
    void SearchPosts_Test() {
        // Arrange
        when(postRepo.searchByTitle(Mockito.<String>any())).thenReturn(new ArrayList<>());

        // Act
        List<PostDto> actualSearchPostsResult = postServiceImpl.searchPosts("Keyword");

        // Assert
        verify(postRepo).searchByTitle(eq("%Keyword%"));
        assertTrue(actualSearchPostsResult.isEmpty());
    }

    /**
     * Method under test: {@link PostServiceImpl#searchPosts(String)}
     */
    @Test
    void SearchPosts_Test2() {
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
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<PostDto>>any())).thenReturn(postDto);

        Category category2 = new Category();
        category2.setCategoryDescription("Category Description");
        category2.setCategoryId(1);
        category2.setCategoryTitle("Dr");
        category2.setPosts(new ArrayList<>());

        User user2 = new User();
        user2.setAbout("About");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setPosts(new ArrayList<>());
        user2.setRoles(new HashSet<>());

        Post post = new Post();
        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post.setCategory(category2);
        post.setContent("Not all who wander are lost");
        post.setPostId(1);
        post.setTitle("Dr");
        post.setUser(user2);

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(post);
        when(postRepo.searchByTitle(Mockito.<String>any())).thenReturn(postList);

        // Act
        List<PostDto> actualSearchPostsResult = postServiceImpl.searchPosts("Keyword");

        // Assert
        verify(postRepo).searchByTitle(eq("%Keyword%"));
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
        assertEquals(1, actualSearchPostsResult.size());
        assertSame(postDto, actualSearchPostsResult.get(0));
    }

    /**
     * Method under test: {@link PostServiceImpl#searchPosts(String)}
     */
    @Test
    void SearchPosts_Test3() {
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
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<PostDto>>any())).thenReturn(postDto);

        Category category2 = new Category();
        category2.setCategoryDescription("Category Description");
        category2.setCategoryId(1);
        category2.setCategoryTitle("Dr");
        category2.setPosts(new ArrayList<>());

        User user2 = new User();
        user2.setAbout("About");
        user2.setEmail("jane.doe@example.org");
        user2.setId(1);
        user2.setName("Name");
        user2.setPassword("iloveyou");
        user2.setPosts(new ArrayList<>());
        user2.setRoles(new HashSet<>());

        Post post = new Post();
        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post.setCategory(category2);
        post.setContent("Not all who wander are lost");
        post.setPostId(1);
        post.setTitle("Dr");
        post.setUser(user2);

        Category category3 = new Category();
        category3.setCategoryDescription("42");
        category3.setCategoryId(2);
        category3.setCategoryTitle("Mr");
        category3.setPosts(new ArrayList<>());

        User user3 = new User();
        user3.setAbout("42");
        user3.setEmail("john.smith@example.org");
        user3.setId(2);
        user3.setName("42");
        user3.setPassword("Password");
        user3.setPosts(new ArrayList<>());
        user3.setRoles(new HashSet<>());

        Post post2 = new Post();
        post2.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post2.setCategory(category3);
        post2.setContent("Content");
        post2.setPostId(2);
        post2.setTitle("Mr");
        post2.setUser(user3);

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(post2);
        postList.add(post);
        when(postRepo.searchByTitle(Mockito.<String>any())).thenReturn(postList);

        // Act
        List<PostDto> actualSearchPostsResult = postServiceImpl.searchPosts("Keyword");

        // Assert
        verify(postRepo).searchByTitle(eq("%Keyword%"));
        verify(modelMapper, atLeast(1)).map(Mockito.<Object>any(), isA(Class.class));
        assertEquals(2, actualSearchPostsResult.size());
        assertSame(postDto, actualSearchPostsResult.get(0));
        assertSame(postDto, actualSearchPostsResult.get(1));
    }

    /**
     * Method under test: {@link PostServiceImpl#searchPosts(String)}
     */
    @Test
    void SearchPosts_Test4() {
        // Arrange
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<PostDto>>any()))
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", 42L));

        Category category = new Category();
        category.setCategoryDescription("Category Description");
        category.setCategoryId(1);
        category.setCategoryTitle("Dr");
        category.setPosts(new ArrayList<>());

        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());

        Post post = new Post();
        post.setAddedDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        post.setCategory(category);
        post.setContent("Not all who wander are lost");
        post.setPostId(1);
        post.setTitle("Dr");
        post.setUser(user);

        ArrayList<Post> postList = new ArrayList<>();
        postList.add(post);
        when(postRepo.searchByTitle(Mockito.<String>any())).thenReturn(postList);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> postServiceImpl.searchPosts("Keyword"));
        verify(postRepo).searchByTitle(eq("%Keyword%"));
        verify(modelMapper).map(isA(Object.class), isA(Class.class));
    }
}
