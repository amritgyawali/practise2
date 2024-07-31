package com.amrit.blog.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@ContextConfiguration(classes = {SwagggerConfig.class})
@ExtendWith(SpringExtension.class)
class SwagggerConfigTest {
    @Autowired
    private SwagggerConfig swagggerConfig;

    /**
     * Method under test: {@link SwagggerConfig#api()}
     */
    @Test
    void Api_Test() {
        // Arrange and Act
        Docket actualApiResult = swagggerConfig.api();

        // Assert
        DocumentationType documentationType = actualApiResult.getDocumentationType();
        assertEquals("2.0", documentationType.getVersion());
        MediaType mediaType = documentationType.getMediaType();
        assertEquals("application", mediaType.getType());
        assertEquals("default", actualApiResult.getGroupName());
        assertEquals("json", mediaType.getSubtype());
        assertEquals("swagger", documentationType.getName());
        assertNull(mediaType.getSubtypeSuffix());
        assertNull(mediaType.getCharset());
        assertEquals(1.0d, mediaType.getQualityValue());
        assertFalse(mediaType.isWildcardType());
        assertTrue(mediaType.getParameters().isEmpty());
        assertTrue(mediaType.isConcrete());
        assertTrue(actualApiResult.isEnabled());
    }
}
