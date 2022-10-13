package com.example.Ehealthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ehealthcare.dto.RootDto;
import com.example.Ehealthcare.service.AppointmentService;
import com.example.Ehealthcare.service.PatientService;
import com.example.Ehealthcare.entity.Appointment;
import com.example.Ehealthcare.entity.Diseases;
import com.example.Ehealthcare.entity.Testimonials;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {
    @Autowired
    AppointmentService appointmentService;

    @Autowired
    PatientService patientService;

    @PostMapping("/bookAppointment")
    RootDto book(Appointment appointment) {
        RootDto res = appointmentService.bookAppointment(appointment);
        return res;
    }

    @PostMapping("/search/diseases")
    RootDto book(Diseases diseases) {
        RootDto res = patientService.getDiseaseInfo(diseases.getName());
        return res;
    }

    @PostMapping("/testimonial")
    RootDto book(Testimonials testimonials) {
        RootDto res = patientService.writeTestimonial(testimonials);
        return res;
    }
}
