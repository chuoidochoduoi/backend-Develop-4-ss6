package org.example.appointmentservice.repository;

import org.example.appointmentservice.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    }

