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

      

        // If the address is IPv6, try to convert it to IPv4
        String ip = request.getHeader("X-Forwarded-For");
        // If there are multiple IPs in the X-Forwarded-For header, get the first one (original client IP)
        if (ip != null && !ip.isEmpty()) {
            ip = ip.split(",")[0].trim();
        } else {
            // If X-Forwarded-For is empty, use the remote address
            ip = request.getRemoteAddr();
        }
        // Check if the IP is the IPv6 localhost (::1) and map it to IPv4 localhost (127.0.0.1)
        if ("::1".equals(ip)) {
            ip = "127.0.0.1";
        }
        // If the IP is in IPv6 format and mapped from IPv4, convert it
        else if (ip.contains(":") && ip.startsWith("::ffff:")) {
            ip = ip.substring(7);
        }

        System.out.println("my ip: " + ip);
        MoodResponse createdMood = moodService.createMood(dto, ip);
        return new ResponseEntity<>(createdMood, createdMood.getStatusCode());
    }
    public String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        // If there are multiple IPs in the X-Forwarded-For header, get the first one (original client IP)
        if (ip != null && !ip.isEmpty()) {
            ip = ip.split(",")[0].trim();
        } else {
            // If X-Forwarded-For is empty, use the remote address
            ip = request.getRemoteAddr();
        }
        // Check if the IP is the IPv6 localhost (::1) and map it to IPv4 localhost (127.0.0.1)
        if ("::1".equals(ip)) {
            ip = "127.0.0.1";
        }
        // If the IP is in IPv6 format and mapped from IPv4, convert it
        else if (ip.contains(":") && ip.startsWith("::ffff:")) {
            ip = ip.substring(7);
        }
        return ip;
     }
     

}
