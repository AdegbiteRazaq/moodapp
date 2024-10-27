package com.school.sport_enrollment.Dto;

import com.school.sport_enrollment.Enums.Moods;

public class MoodDto {
    private Moods rating;

    public Moods getRating() {
        return rating;
    }

    public void setRating(Moods rating) {
        this.rating = rating;
    }
}
