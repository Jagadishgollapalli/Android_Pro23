package com.example.savethestarve;

public class UserRating {
    private String userId;
    private int rating;

    public UserRating(String userId, int rating) {
        this.userId = userId;
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public int getRating() {
        return rating;
    }
}

