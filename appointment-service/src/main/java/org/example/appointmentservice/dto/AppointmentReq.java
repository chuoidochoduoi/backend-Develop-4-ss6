package org.example.appointmentservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentReq {
    private Long patientId;
    private Long doctorId;
    private LocalDateTime appointmentDate;
    private String reason;
}
