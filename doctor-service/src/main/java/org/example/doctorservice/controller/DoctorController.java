package org.example.doctorservice.controller;


import lombok.RequiredArgsConstructor;
import org.example.doctorservice.dto.APIResponse;
import org.example.doctorservice.dto.PatientReq;
import org.example.doctorservice.repository.DoctorRepository;
import org.example.doctorservice.service.DoctorService;
import org.example.patientservice.repository.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    private final PatientRepository patientRepository;

    private final DoctorRepository doctorRepository;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody PatientReq req) {
        return ResponseEntity.status(201).body(
                APIResponse.builder()
                        .code(201)
                        .message("Created")
                        .data(doctorService.save(req))
                        .build()
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return doctorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}