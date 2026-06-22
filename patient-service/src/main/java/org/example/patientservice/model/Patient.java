package org.example.patientservice.model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private LocalDate dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String address;

    @Column(columnDefinition = "TEXT")
    private String medicalHistory;
}