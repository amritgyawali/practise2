package com.amrit.blog.config;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;

@ContextConfiguration(classes = {ContentConfig.class})
@ExtendWith(SpringExtension.class)
class ContentConfigTest {
    @Autowired
    private ContentConfig contentConfig;

    /**
     * Method under test:
     * {@link ContentConfig#configureContentNegotiation(ContentNegotiationConfigurer)}
     */
    @Test
    void ConfigureContentNegotiation_Test() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ContentNegotiationConfigurer.factory
        //     ContentNegotiationConfigurer.mediaTypes

        // Arrange and Act
        contentConfig.configureContentNegotiation(new ContentNegotiationConfigurer(new MockServletContext()));
    }

    /**
     * Method under test:
     * {@link ContentConfig#configureContentNegotiation(ContentNegotiationConfigurer)}
     */

}
