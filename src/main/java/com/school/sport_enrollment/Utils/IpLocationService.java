package com.school.sport_enrollment.Utils;

import java.util.HashMap;
import java.util.Map;

public class IpLocationService {
    private Map<String, String> ipLocationMap;

    public IpLocationService() {
        ipLocationMap = new HashMap<>();
        // Pre-populate the HashMap with IP and location values
        ipLocationMap.put("71.89.155.154", "GA-HQ");
        ipLocationMap.put("166.130.69.148", "GA-HQ");
        ipLocationMap.put("24.247.16.123", "GA-HQ");
        ipLocationMap.put("24.247.16.90", "TCstore");
        ipLocationMap.put("198.109.107.33", "TCstore");
        ipLocationMap.put("97.83.113.38", "EM-DFC");
        ipLocationMap.put("35.131.239.218", "EM-DFC");
        ipLocationMap.put("69.89.113.124", "BZ");
        ipLocationMap.put("24.231.203.78", "FM");
        ipLocationMap.put("75.144.64.89", "AA");
        ipLocationMap.put("50.198.36.65", "AA");
        ipLocationMap.put("68.188.216.122", "CHX");
        ipLocationMap.put("198.0.100.97", "HL");
        ipLocationMap.put("104.36.74.243", "HL");
        ipLocationMap.put("67.22.7.127", "TC-CC");
        ipLocationMap.put("75.133.80.234", "EM-IT");
        ipLocationMap.put("68.188.137.81", "GA-PH");
        ipLocationMap.put("127.0.0.1", "Rukky's-House");

        // Add more IP-location pairs as needed
    }

    public String getLocationByIp(String ip) {
        // Check if the IP exists in the map
        return ipLocationMap.getOrDefault(ip, "EMAIL");
    }
}
