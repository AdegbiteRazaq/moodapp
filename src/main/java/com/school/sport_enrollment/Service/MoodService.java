package com.school.sport_enrollment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.school.sport_enrollment.Dto.MoodDto;
import com.school.sport_enrollment.Model.Mood;
import com.school.sport_enrollment.Repository.MoodRepository;
import com.school.sport_enrollment.Response.MoodResponse;
import com.school.sport_enrollment.Utils.IpLocationService;

@Service
public class MoodService {

    @Autowired
    private MoodRepository repo;

    public MoodResponse createMood(MoodDto dto, String ipAddress) {
        try {
            if (dto.getIntensity() < 1)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Invalid intensity intensity must be greater than 0");
            Mood newMood = new Mood();
            newMood.setRating(dto.getRating());
            newMood.setIntensity(dto.getIntensity());
            newMood.setLocation(new IpLocationService().getLocationByIp(ipAddress));
            Mood createdMood = repo.save(newMood);
            MoodResponse response = new MoodResponse(createdMood.getId(), HttpStatus.OK, "Mood successfully created");
            return response;

        } catch (ResponseStatusException e) {
            String message = e.getReason();
            Integer statusValue = e.getStatusCode().value();
            HttpStatus status = HttpStatus.valueOf(statusValue);

            MoodResponse response = new MoodResponse(null, status, message);
            return response;
        } catch (Exception e) {

            MoodResponse response = new MoodResponse(null, HttpStatus.INTERNAL_SERVER_ERROR, "An error occured");
            return response;
        }
    }
}
