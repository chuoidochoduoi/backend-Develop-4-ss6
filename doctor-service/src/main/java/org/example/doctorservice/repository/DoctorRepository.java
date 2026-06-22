package org.example.doctorservice.repository;


import org.example.patientservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Patient, Long> {
}