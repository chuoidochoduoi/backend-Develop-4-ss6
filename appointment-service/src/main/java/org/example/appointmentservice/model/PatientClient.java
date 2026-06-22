package org.example.appointmentservice.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class PatientClient {

    private final RestTemplate restTemplate;

    private static final String PATIENT_URL =
            "http://patient-service/api/v1/patients";

    public boolean existsById(Long patientId) {
        try {
            restTemplate.getForObject(
                    PATIENT_URL + "/" + patientId,
                    Object.class
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}