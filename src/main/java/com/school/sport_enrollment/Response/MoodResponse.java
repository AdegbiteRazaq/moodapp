package com.school.sport_enrollment.Response;

import org.springframework.http.HttpStatus;

public class MoodResponse {

    private Long data;
    private HttpStatus statusCode;
    private String message;

    public MoodResponse(Long data, HttpStatus statusCode, String message) {
        this.data = data;
        this.statusCode = statusCode;
        this.message = message;

    }

    public Long getData() {
        return data;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
