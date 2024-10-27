package com.school.sport_enrollment.Enums;

public enum Moods {
    ANXIOUS(1),
    RELAXED(2),
    HAPPY(3),
    SAD(4),
    ANGRY(5);

    private final int value;

    Moods(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

