package org.example.appointmentservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class APIResponse {
    private int code;
    private String message;
    private Object data;
}