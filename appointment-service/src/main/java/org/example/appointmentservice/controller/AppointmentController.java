package org.example.appointmentservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.appointmentservice.Service1.AppointmentService;
import org.example.appointmentservice.dto.APIResponse;
import org.example.appointmentservice.dto.AppointmentReq;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody AppointmentReq req) {
        try {
            return ResponseEntity.status(201).body(
                    APIResponse.builder()
                            .code(201)
                            .message("Tạo lịch khám thành công")
                            .data(appointmentService.save(req))
                            .build()
            );
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(
                    APIResponse.builder()
                            .code(400)
                            .message(e.getMessage())
                            .data(null)
                            .build()
            );
        }
    }
}
