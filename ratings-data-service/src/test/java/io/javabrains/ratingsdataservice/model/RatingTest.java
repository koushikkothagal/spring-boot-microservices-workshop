package io.javabrains.ratingsdataservice.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RatingTest {
    @Test
    public void testConstructor() {
        Rating actualRating = new Rating("42", 1);
        actualRating.setMovieId("42");
        actualRating.setRating(1);
        assertEquals("42", actualRating.getMovieId());
        assertEquals(1, actualRating.getRating());
    }
}

