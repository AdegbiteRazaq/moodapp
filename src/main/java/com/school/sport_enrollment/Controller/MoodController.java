package com.school.sport_enrollment.Controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.sport_enrollment.Dto.MoodDto;
import com.school.sport_enrollment.Response.MoodResponse;
import com.school.sport_enrollment.Service.MoodService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/mood")
public class MoodController {

    @Autowired
    private MoodService moodService;

    @PostMapping("/create-mood")

    public ResponseEntity<MoodResponse> createMood(@RequestBody MoodDto dto, HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }

        // If the address is IPv6, try to convert it to IPv4
            try {
                InetAddress inetAddress = InetAddress.getByName(ipAddress);
                if (inetAddress instanceof java.net.Inet6Address) {
                    ipAddress = InetAddress.getByAddress(inetAddress.getAddress()).getHostAddress();
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }

        System.out.println("my ip: " + ipAddress);
        MoodResponse createdMood = moodService.createMood(dto, ipAddress);
        return new ResponseEntity<>(createdMood, createdMood.getStatusCode());
    }

}
