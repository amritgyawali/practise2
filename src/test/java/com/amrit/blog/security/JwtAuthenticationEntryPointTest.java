package com.amrit.blog.security;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtAuthenticationEntryPoint.class})
@ExtendWith(SpringExtension.class)
class JwtAuthenticationEntryPointTest {
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    /**
     * Method under test:
     * {@link JwtAuthenticationEntryPoint#commence(HttpServletRequest, HttpServletResponse, AuthenticationException)}
     */
    @Test
    void Commence_Test() throws IOException, ServletException {
        // Arrange
        MockHttpServletRequest request = new MockHttpServletRequest();
        AddDefaultCharsetFilter.ResponseWrapper response = mock(AddDefaultCharsetFilter.ResponseWrapper.class);
        doNothing().when(response).sendError(anyInt(), Mockito.<String>any());

        // Act
        jwtAuthenticationEntryPoint.commence(request, response, new AccountExpiredException("Msg"));

        // Assert
        verify(response).sendError(eq(401), eq("Access Denined !!"));
    }
}
