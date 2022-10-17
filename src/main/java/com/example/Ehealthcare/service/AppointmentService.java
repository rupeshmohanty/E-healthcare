package com.example.Ehealthcare.service;

import com.example.Ehealthcare.dto.RootDto;
import com.example.Ehealthcare.entity.Appointment;

public interface AppointmentService {
    RootDto bookAppointment(Appointment appointment);
    RootDto acceptAppointment(long id);
    RootDto rejectAppointment(long id);
}
