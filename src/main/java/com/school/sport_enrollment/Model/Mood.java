package com.school.sport_enrollment.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.school.sport_enrollment.Enums.Moods;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "mood")
public class Mood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sortable_date")
    private LocalDateTime sortableDate;

    @Column(name = "time")
    private String time;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "location")
    private String location;

    @Column(name = "rating")
    private Moods rating;

    @Column(name = "name")
    private String name;

    @Column(name ="department")
    private String department;

    @Column(name = "comments")
    private String comments;


    @PrePersist
    protected void onCreate() {
        sortableDate = LocalDateTime.now(); // Set LocalDateTime when the entity is created
        date = LocalDate.now(); // Set LocalDate when the entity is created
        time = formatTime(sortableDate);
    }

    public static String formatTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm:ss a");
        return dateTime.format(formatter);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Moods getRating() {
        return rating;
    }

    public void setRating(Moods rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }
}
