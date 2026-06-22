package org.example.appointmentservice.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class DoctorClient {

    private final RestTemplate restTemplate;

    private static final String DOCTOR_URL =
            "http://doctor-service/api/v1/doctors";

    public boolean existsById(Long doctorId) {
        try {
            restTemplate.getForObject(
                    DOCTOR_URL + "/" + doctorId,
                    Object.class
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}