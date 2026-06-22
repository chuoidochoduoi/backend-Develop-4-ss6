package org.example.doctorservice.service;


import lombok.RequiredArgsConstructor;
import org.example.doctorservice.dto.PatientReq;
import org.example.doctorservice.repository.DoctorRepository;
import org.example.patientservice.model.Patient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public Patient save(PatientReq req) {
        Patient patient = new Patient();
        patient.setFullName(req.getFullName());
        patient.setAddress(req.getAddress());
        patient.setMedicalHistory(req.getMedicalHistory());
        return doctorRepository.save(patient);
    }
}
