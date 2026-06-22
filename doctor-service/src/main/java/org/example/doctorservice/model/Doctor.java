package org.example.doctorservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;
    private Integer experienceYears;
    private String email;
    private Boolean status;
}