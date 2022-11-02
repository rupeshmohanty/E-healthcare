package com.example.Ehealthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ehealthcare.dto.RootDto;
import com.example.Ehealthcare.service.AppointmentService;
import com.example.Ehealthcare.service.PatientService;
import com.example.Ehealthcare.entity.Appointment;
import com.example.Ehealthcare.entity.Diseases;
import com.example.Ehealthcare.entity.Patient;
import com.example.Ehealthcare.entity.Testimonials;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/patient")
public class PatientController {
    @Autowired
    AppointmentService appointmentService;

    @Autowired
    PatientService patientService;

    @PostMapping("/bookAppointment")
    RootDto book(@RequestBody Appointment appointment) {
        RootDto res = appointmentService.bookAppointment(appointment);
        return res;
    }

    @PostMapping("/search/diseases")
    RootDto book(@RequestBody Diseases diseases) {
        RootDto res = patientService.getDiseaseInfo(diseases.getName());
        return res;
    }

    @PostMapping("/testimonial")
    RootDto book(@RequestBody Testimonials testimonials) {
        RootDto res = patientService.writeTestimonial(testimonials);
        return res;
    }

    @PostMapping("/register")
    RootDto book(@RequestBody Patient patient) {
        RootDto res = patientService.registerUser(patient);
        return res;
    }
}
