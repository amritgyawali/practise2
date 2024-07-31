package com.amrit.blog.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.amrit.blog.payloads.UserDto;
import com.amrit.blog.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
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

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link UserController#createUser(UserDto)}
     */
    @Test
    void CreateUser_Test() throws Exception {
        // Arrange
        UserDto userDto = new UserDto();
        userDto.setAbout("About");
        userDto.setEmail("jane.doe@example.org");
        userDto.setId(1);
        userDto.setName("Name");
        userDto.setPassword("iloveyou");
        userDto.setRoles(new HashSet<>());
        String content = (new ObjectMapper()).writeValueAsString(userDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController).build().perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link UserController#deleteUser(Integer)}
     */
    @Test
    void DeleteUser_Test() throws Exception {
        // Arrange
        doNothing().when(userService).deleteUser(Mockito.<Integer>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/users/{userId}", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("<ApiResponse><message>User deleted Successfully</message><success>true</success></ApiResponse>"));
    }

    /**
     * Method under test: {@link UserController#deleteUser(Integer)}
     */
    @Test
    void DeleteUser_Test2() throws Exception {
        // Arrange
        doNothing().when(userService).deleteUser(Mockito.<Integer>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/users/{userId}", 1);
        requestBuilder.characterEncoding("Encoding");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("<ApiResponse><message>User deleted Successfully</message><success>true</success></ApiResponse>"));
    }

    /**
     * Method under test: {@link UserController#getAllUsers()}
     */
    @Test
    void GetAllUsers_Test() throws Exception {
        // Arrange
        when(userService.getAllUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/users/");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("<List/>"));
    }

    /**
     * Method under test: {@link UserController#getAllUsers()}
     */
    @Test
    void GetAllUsers_Test2() throws Exception {
        // Arrange
        when(userService.getAllUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/users/");
        requestBuilder.characterEncoding("Encoding");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("<List/>"));
    }

    /**
     * Method under test: {@link UserController#getSingleUser(Integer)}
     */
    @Test
    void GetSingleUser_Test() throws Exception {
        // Arrange
        UserDto userDto = new UserDto();
        userDto.setAbout("About");
        userDto.setEmail("jane.doe@example.org");
        userDto.setId(1);
        userDto.setName("Name");
        userDto.setPassword("iloveyou");
        userDto.setRoles(new HashSet<>());
        when(userService.getUserById(Mockito.<Integer>any())).thenReturn(userDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/users/{userId}", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<UserDto><id>1</id><name>Name</name><email>jane.doe@example.org</email><about>About</about><roles/>"
                                        + "</UserDto>"));
    }

    /**
     * Method under test: {@link UserController#updateUser(UserDto, Integer)}
     */
    @Test
    void UpdateUser_Test() throws Exception {
        // Arrange
        UserDto userDto = new UserDto();
        userDto.setAbout("About");
        userDto.setEmail("jane.doe@example.org");
        userDto.setId(1);
        userDto.setName("Name");
        userDto.setPassword("iloveyou");
        userDto.setRoles(new HashSet<>());
        String content = (new ObjectMapper()).writeValueAsString(userDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/users/{userId}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController).build().perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}
