package com.school.sport_enrollment.Dto;

import com.school.sport_enrollment.Enums.Moods;

public class MoodDto {
    private Moods rating;

    private Integer intensity;

    public Integer getIntensity() {
        return intensity;
    }

    public void setIntensity(Integer intensity) {
        this.intensity = intensity;
    }

    public Moods getRating() {
        return rating;
    }

    public void setRating(Moods rating) {
        this.rating = rating;
    }
}
