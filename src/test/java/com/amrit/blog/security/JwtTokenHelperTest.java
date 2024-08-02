package com.amrit.blog.security;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtTokenHelperTest {

    private static final String SECRET_KEY = "testSecret";
    private static final String USERNAME = "testUser";
    private static final String TOKEN = "testToken";
    private static final long JWT_TOKEN_VALIDITY = 5 * 60 * 1000L;

    @InjectMocks
    private JwtTokenHelper jwtTokenHelper;

    @Mock
    private UserDetails userDetails;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        jwtTokenHelper.secret = SECRET_KEY;
        when(userDetails.getUsername()).thenReturn(USERNAME);
    }

    @Test
    public void testGetUsernameFromToken() {
        Claims claims = mock(Claims.class);
        when(claims.getSubject()).thenReturn(USERNAME);
        JwtTokenHelper spy = spy(jwtTokenHelper);
        doReturn(claims).when(spy).getAllClaimsFromToken(TOKEN);

        String username = spy.getUsernameFromToken(TOKEN);

        assertEquals(USERNAME, username);
    }

    @Test
    public void testGetExpirationDateFromToken() {
        Date expirationDate = new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY);
        Claims claims = mock(Claims.class);
        when(claims.getExpiration()).thenReturn(expirationDate);
        JwtTokenHelper spy = spy(jwtTokenHelper);
        doReturn(claims).when(spy).getAllClaimsFromToken(TOKEN);

        Date returnedDate = spy.getExpirationDateFromToken(TOKEN);

        assertEquals(expirationDate, returnedDate);
    }

    @Test
    public void testGenerateToken() {
        String token = jwtTokenHelper.generateToken(userDetails);
        assertNotNull(token);
    }

    @Test
    public void testValidateToken() {
        Claims claims = new DefaultClaims();
        claims.setSubject(USERNAME);
        claims.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY));
        JwtTokenHelper spy = spy(jwtTokenHelper);
        doReturn(claims).when(spy).getAllClaimsFromToken(anyString());

        Boolean isValid = spy.validateToken(TOKEN, userDetails);

        assertTrue(isValid);
    }

    @Test
    public void testIsTokenExpired() {
        Date futureDate = new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY);
        Date pastDate = new Date(System.currentTimeMillis() - JWT_TOKEN_VALIDITY);

        JwtTokenHelper spy = spy(jwtTokenHelper);
        doReturn(futureDate).when(spy).getExpirationDateFromToken(anyString());
        assertFalse(spy.isTokenExpired(TOKEN));

        doReturn(pastDate).when(spy).getExpirationDateFromToken(anyString());
        assertTrue(spy.isTokenExpired(TOKEN));
    }
}
