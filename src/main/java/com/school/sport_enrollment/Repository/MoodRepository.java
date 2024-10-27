package com.school.sport_enrollment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.sport_enrollment.Model.Mood;

public interface MoodRepository extends JpaRepository<Mood, Long>{

}
