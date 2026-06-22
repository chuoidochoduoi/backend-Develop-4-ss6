package org.example.appointmentservice.Service1;


import org.example.appointmentservice.dto.AppointmentReq;
import lombok.RequiredArgsConstructor;
import org.example.appointmentservice.model.Appointment;
import org.example.appointmentservice.model.DoctorClient;
import org.example.appointmentservice.model.PatientClient;
import org.example.appointmentservice.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientClient patientClient;
    private final DoctorClient doctorClient;

    public Appointment save(AppointmentReq req) {

        if (!patientClient.existsById(req.getPatientId())) {
            throw new RuntimeException(
                    "Bệnh nhân không tồn tại với id: " + req.getPatientId()
            );
        }

        if (!doctorClient.existsById(req.getDoctorId())) {
            throw new RuntimeException(
                    "Bác sĩ không tồn tại với id: " + req.getDoctorId()
            );
        }

        Appointment appointment = new Appointment();
        appointment.setPatientId(req.getPatientId());
        appointment.setDoctorId(req.getDoctorId());
        appointment.setAppointmentDate(req.getAppointmentDate());
        appointment.setReason(req.getReason());
        appointment.setStatus("PENDING");

        return appointmentRepository.save(appointment);
    }
}
