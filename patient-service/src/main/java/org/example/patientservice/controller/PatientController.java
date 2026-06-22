package org.example.patientservice.controller;



import lombok.RequiredArgsConstructor;
import org.example.patientservice.dto.APIResponse;
import org.example.patientservice.dto.PatientReq;
import org.example.patientservice.repository.PatientRepository;
import org.example.patientservice.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;
    private final PatientRepository patientRepository;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PatientReq req) {
        return ResponseEntity.status(201).body(
                APIResponse.builder()
                        .code(201)
                        .message("Created")
                        .data(patientService.save(req))
                        .build()
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return patientRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}