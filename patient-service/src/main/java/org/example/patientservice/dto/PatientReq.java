package org.example.patientservice.dto;

import lombok.Data;

@Data
public class PatientReq {
    private String fullName;
    private String address;
    private String medicalHistory;
}