package com.amrit.blog.security;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.amrit.blog.entities.User;
import io.jsonwebtoken.Claims;

import java.util.function.Function;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtTokenHelper.class})
@ExtendWith(SpringExtension.class)
class JwtTokenHelperTest {
    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    /**
     * Method under test: {@link JwtTokenHelper#getUsernameFromToken(String)}
     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void GetUsernameFromToken_Test() {
//        // TODO: Diffblue Cover was only able to create a partial test for this method:
//        //   Reason: No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   io.jsonwebtoken.MalformedJwtException: JWT strings must contain exactly 2 period characters. Found: 0
//        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:235)
//        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:481)
//        //       at io.jsonwebtoken.impl.DefaultJwtParser.parseClaimsJws(DefaultJwtParser.java:541)
//        //       at com.amrit.blog.security.JwtTokenHelper.getAllClaimsFromToken(JwtTokenHelper.java:41)
//        //       at com.amrit.blog.security.JwtTokenHelper.getClaimFromToken(JwtTokenHelper.java:35)
//        //       at com.amrit.blog.security.JwtTokenHelper.getUsernameFromToken(JwtTokenHelper.java:26)
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        // Arrange and Act
//        jwtTokenHelper.getUsernameFromToken("ABC123");
//    }

    /**
     * Method under test: {@link JwtTokenHelper#getExpirationDateFromToken(String)}
     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void GetExpirationDateFromToken_Test() {
//        // TODO: Diffblue Cover was only able to create a partial test for this method:
//        //   Reason: No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   io.jsonwebtoken.MalformedJwtException: JWT strings must contain exactly 2 period characters. Found: 0
//        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:235)
//        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:481)
//        //       at io.jsonwebtoken.impl.DefaultJwtParser.parseClaimsJws(DefaultJwtParser.java:541)
//        //       at com.amrit.blog.security.JwtTokenHelper.getAllClaimsFromToken(JwtTokenHelper.java:41)
//        //       at com.amrit.blog.security.JwtTokenHelper.getClaimFromToken(JwtTokenHelper.java:35)
//        //       at com.amrit.blog.security.JwtTokenHelper.getExpirationDateFromToken(JwtTokenHelper.java:31)
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        // Arrange and Act
//        jwtTokenHelper.getExpirationDateFromToken("ABC123");
//    }

    /**
     * Method under test: {@link JwtTokenHelper#getClaimFromToken(String, Function)}
     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void GetClaimFromToken_Test() {
//        // TODO: Diffblue Cover was only able to create a partial test for this method:
//        //   Reason: No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   io.jsonwebtoken.MalformedJwtException: JWT strings must contain exactly 2 period characters. Found: 0
//        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:235)
//        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:481)
//        //       at io.jsonwebtoken.impl.DefaultJwtParser.parseClaimsJws(DefaultJwtParser.java:541)
//        //       at com.amrit.blog.security.JwtTokenHelper.getAllClaimsFromToken(JwtTokenHelper.java:41)
//        //       at com.amrit.blog.security.JwtTokenHelper.getClaimFromToken(JwtTokenHelper.java:35)
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        // Arrange and Act
//        jwtTokenHelper.<Object>getClaimFromToken("ABC123", mock(Function.class));
//    }

    /**
     * Method under test: {@link JwtTokenHelper#generateToken(UserDetails)}
     */
    @Test
    void GenerateToken_Test() {
        // Arrange
        User userDetails = mock(User.class);
        when(userDetails.getUsername()).thenReturn("janedoe");

        // Act
        jwtTokenHelper.generateToken(userDetails);

        // Assert
        verify(userDetails).getUsername();
    }

    /**
     * Method under test: {@link JwtTokenHelper#validateToken(String, UserDetails)}
     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void ValidateToken_Test() {
//        // TODO: Diffblue Cover was only able to create a partial test for this method:
//        //   Reason: No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   io.jsonwebtoken.MalformedJwtException: JWT strings must contain exactly 2 period characters. Found: 0
//        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:235)
//        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:481)
//        //       at io.jsonwebtoken.impl.DefaultJwtParser.parseClaimsJws(DefaultJwtParser.java:541)
//        //       at com.amrit.blog.security.JwtTokenHelper.getAllClaimsFromToken(JwtTokenHelper.java:41)
//        //       at com.amrit.blog.security.JwtTokenHelper.getClaimFromToken(JwtTokenHelper.java:35)
//        //       at com.amrit.blog.security.JwtTokenHelper.getUsernameFromToken(JwtTokenHelper.java:26)
//        //       at com.amrit.blog.security.JwtTokenHelper.validateToken(JwtTokenHelper.java:69)
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        // Arrange and Act
//        jwtTokenHelper.validateToken("ABC123", new User());
//    }
}
