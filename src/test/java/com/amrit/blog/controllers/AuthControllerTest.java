package com.amrit.blog.controllers;

import static org.mockito.Mockito.when;

import com.amrit.blog.entities.User;
import com.amrit.blog.payloads.JwtAuthRequest;
import com.amrit.blog.payloads.UserDto;
import com.amrit.blog.repositories.UserRepo;
import com.amrit.blog.security.JwtTokenHelper;
import com.amrit.blog.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.security.auth.UserPrincipal;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuthController.class})
@ExtendWith(SpringExtension.class)
class AuthControllerTest {
    @Autowired
    private AuthController authController;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtTokenHelper jwtTokenHelper;

    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private UserDetailsService userDetailsService;

    @MockBean
    private UserRepo userRepo;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link AuthController#createToken(JwtAuthRequest)}
     */
    @Test
    void CreateToken_Test() throws Exception {
        // Arrange
        when(jwtTokenHelper.generateToken(Mockito.<UserDetails>any())).thenReturn("ABC123");

        UserDto userDto = new UserDto();
        userDto.setAbout("About");
        userDto.setEmail("jane.doe@example.org");
        userDto.setId(1);
        userDto.setName("Name");
        userDto.setPassword("iloveyou");
        userDto.setRoles(new HashSet<>());
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<UserDto>>any())).thenReturn(userDto);
        when(userDetailsService.loadUserByUsername(Mockito.<String>any())).thenReturn(new User());
        when(authenticationManager.authenticate(Mockito.<Authentication>any()))
                .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));

        JwtAuthRequest jwtAuthRequest = new JwtAuthRequest();
        jwtAuthRequest.setPassword("iloveyou");
        jwtAuthRequest.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(jwtAuthRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "<JwtAuthResponse><token>ABC123</token><user><id>1</id><name>Name</name><email>jane.doe@example.org<"
                                        + "/email><about>About</about><roles/></user></JwtAuthResponse>"));
    }

    /**
     * Method under test: {@link AuthController#getUser(Principal)}
     */
    @Test
    void GetUser_Test() throws Exception {
        // Arrange
        UserDto userDto = new UserDto();
        userDto.setAbout("About");
        userDto.setEmail("jane.doe@example.org");
        userDto.setId(1);
        userDto.setName("Name");
        userDto.setPassword("iloveyou");
        userDto.setRoles(new HashSet<>());
        when(modelMapper.map(Mockito.<Object>any(), Mockito.<Class<UserDto>>any())).thenReturn(userDto);

        User user = new User();
        user.setAbout("About");
        user.setEmail("jane.doe@example.org");
        user.setId(1);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setPosts(new ArrayList<>());
        user.setRoles(new HashSet<>());
        Optional<User> ofResult = Optional.of(user);
        when(userRepo.findByEmail(Mockito.<String>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/auth/current-user/");
        requestBuilder.principal(new UserPrincipal("principal"));

        // Act and Assert
        MockMvcBuilders.standaloneSetup(authController)
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
     * Method under test: {@link AuthController#registerUser(UserDto)}
     */
    @Test
    void RegisterUser_Test() throws Exception {
        // Arrange
        UserDto userDto = new UserDto();
        userDto.setAbout("About");
        userDto.setEmail("jane.doe@example.org");
        userDto.setId(1);
        userDto.setName("Name");
        userDto.setPassword("iloveyou");
        userDto.setRoles(new HashSet<>());
        String content = (new ObjectMapper()).writeValueAsString(userDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(authController).build().perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}
