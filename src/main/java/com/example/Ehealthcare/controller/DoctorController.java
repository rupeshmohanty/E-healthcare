package com.example.Ehealthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ehealthcare.dto.RootDto;
// import com.example.Ehealthcare.entity.Appointment;
import com.example.Ehealthcare.entity.Diseases;
import com.example.Ehealthcare.entity.Doctor;
import com.example.Ehealthcare.entity.FAQ;
import com.example.Ehealthcare.entity.Prescription;
import com.example.Ehealthcare.service.AppointmentService;
import com.example.Ehealthcare.service.DiseasesService;
import com.example.Ehealthcare.service.DoctorService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/doctor")
public class DoctorController {
    
    @Autowired
    DiseasesService diseasesService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    DoctorService doctorService;

    @PostMapping("/diseases")
    RootDto addDiseaseInfo(@RequestBody Diseases diseases) {
        RootDto res = diseasesService.addDiseaseInfo(diseases);
        return res;
    }

    @GetMapping("/allAppointments")
    RootDto getAllAppointments() {
        RootDto res = appointmentService.allAppointments();
        return res;
    }

    @GetMapping("/acceptAppointment/{id}")
    RootDto acceptAppointment(@PathVariable("id") long id) {
        RootDto res = appointmentService.acceptAppointment(id);
        return res;
    }

    @GetMapping("/rejectAppointment/{id}")
    RootDto rejectAppointment(@PathVariable("id") long id) {
        RootDto res = appointmentService.rejectAppointment(id);
        return res;
    }
    
    @PostMapping("/uploadPrescription")
    RootDto rejectAppointment(@RequestBody Prescription prescription) {
        RootDto res = doctorService.writePrescription(prescription);
        return res;
    }

    @PostMapping("/addFaq")
    RootDto addFaq(@RequestBody FAQ faq) {
        RootDto res = doctorService.addFaq(faq);
        return res;
    }

    @PostMapping("/register")
    RootDto registerDoctor(@RequestBody Doctor doctor) {
        RootDto res = doctorService.registerDoctor(doctor);
        return res;
    }

    @PostMapping("/login")
    RootDto loginDoctor(@RequestBody Doctor doctor) {
        RootDto res = doctorService.loginDoctor(doctor);
        return res;
    }
}
