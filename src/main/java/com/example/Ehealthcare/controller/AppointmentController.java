package com.example.Ehealthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ehealthcare.dto.RootDto;
import com.example.Ehealthcare.service.AppointmentService;
import com.example.Ehealthcare.entity.Appointment;

@RestController
@RequestMapping(value = "/patient")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/bookAppointment")
    RootDto book(Appointment appointment) {
        RootDto res = appointmentService.bookAppointment(appointment);
        return res;
    }
}
