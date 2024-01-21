package io.javabrains.moviecatalogservice.models;

import java.util.List;

public class UserRating {

    private List<Rating> ratings;

    public UserRating() {
    }

    public UserRating(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
