package org.example.patientservice.service;


import lombok.RequiredArgsConstructor;
import org.example.patientservice.dto.PatientReq;
import org.example.patientservice.model.Patient;
import org.example.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient save(PatientReq req) {
        Patient patient = new Patient();
        patient.setFullName(req.getFullName());
        patient.setAddress(req.getAddress());
        patient.setMedicalHistory(req.getMedicalHistory());
        return patientRepository.save(patient);
    }
}
