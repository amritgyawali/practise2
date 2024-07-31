package com.amrit.blog.payloads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class PostResponseTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>default or parameterless constructor of {@link PostResponse}
     *   <li>{@link PostResponse#setContent(List)}
     *   <li>{@link PostResponse#setLastPage(boolean)}
     *   <li>{@link PostResponse#setPageNumber(int)}
     *   <li>{@link PostResponse#setPageSize(int)}
     *   <li>{@link PostResponse#setTotalElements(long)}
     *   <li>{@link PostResponse#setTotalPages(int)}
     *   <li>{@link PostResponse#getContent()}
     *   <li>{@link PostResponse#getPageNumber()}
     *   <li>{@link PostResponse#getPageSize()}
     *   <li>{@link PostResponse#getTotalElements()}
     *   <li>{@link PostResponse#getTotalPages()}
     *   <li>{@link PostResponse#isLastPage()}
     * </ul>
     */
    @Test
    void gettersAndSetters_Test() {
        // Arrange and Act
        PostResponse actualPostResponse = new PostResponse();
        ArrayList<PostDto> content = new ArrayList<>();
        actualPostResponse.setContent(content);
        actualPostResponse.setLastPage(true);
        actualPostResponse.setPageNumber(10);
        actualPostResponse.setPageSize(3);
        actualPostResponse.setTotalElements(1L);
        actualPostResponse.setTotalPages(1);
        List<PostDto> actualContent = actualPostResponse.getContent();
        int actualPageNumber = actualPostResponse.getPageNumber();
        int actualPageSize = actualPostResponse.getPageSize();
        long actualTotalElements = actualPostResponse.getTotalElements();
        int actualTotalPages = actualPostResponse.getTotalPages();

        // Assert that nothing has changed
        assertEquals(1, actualTotalPages);
        assertEquals(10, actualPageNumber);
        assertEquals(1L, actualTotalElements);
        assertEquals(3, actualPageSize);
        assertTrue(actualPostResponse.isLastPage());
        assertTrue(actualContent.isEmpty());
        assertSame(content, actualContent);
    }
}
