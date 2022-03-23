package io.javabrains.ratingsdataservice.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UserRatingTest {
    @Test
    public void testInitData() {
        UserRating userRating = new UserRating();
        userRating.initData("42");
        List<Rating> ratings = userRating.getRatings();
        assertEquals(2, ratings.size());
        assertEquals("42", userRating.getUserId());
        Rating getResult = ratings.get(1);
        assertEquals(4, getResult.getRating());
        Rating getResult1 = ratings.get(0);
        assertEquals(3, getResult1.getRating());
        assertEquals("100", getResult1.getMovieId());
        assertEquals("200", getResult.getMovieId());
    }
    
    @Test
    public void testConstructor() {
        UserRating actualUserRating = new UserRating();
        ArrayList<Rating> ratingList = new ArrayList<>();
        actualUserRating.setRatings(ratingList);
        actualUserRating.setUserId("42");
        assertSame(ratingList, actualUserRating.getRatings());
        assertEquals("42", actualUserRating.getUserId());
    }
}

