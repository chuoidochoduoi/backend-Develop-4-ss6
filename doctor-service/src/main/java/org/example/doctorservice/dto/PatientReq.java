package org.example.doctorservice.dto;

import lombok.Data;

@Data
public class PatientReq {
    private String fullName;
    private String address;
    private String medicalHistory;
}