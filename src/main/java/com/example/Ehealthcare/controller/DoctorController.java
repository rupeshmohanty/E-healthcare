package com.example.Ehealthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ehealthcare.dto.RootDto;
// import com.example.Ehealthcare.entity.Appointment;
import com.example.Ehealthcare.entity.Diseases;
import com.example.Ehealthcare.entity.Prescription;
import com.example.Ehealthcare.service.AppointmentService;
import com.example.Ehealthcare.service.DiseasesService;
import com.example.Ehealthcare.service.DoctorService;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {
    
    @Autowired
    DiseasesService diseasesService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    DoctorService doctorService;

    @PostMapping("/diseases")
    RootDto addDiseaseInfo(Diseases diseases) {
        RootDto res = diseasesService.addDiseaseInfo(diseases);
        return res;
    }

    @PostMapping("/acceptAppointment")
    RootDto acceptAppointment(long id) {
        RootDto res = appointmentService.acceptAppointment(id);
        return res;
    }

    @PostMapping("/rejectAppointment")
    RootDto rejectAppointment(long id) {
        RootDto res = appointmentService.rejectAppointment(id);
        return res;
    }

    @PostMapping("/uploadPrescription")
    RootDto rejectAppointment(Prescription prescription) {
        RootDto res = doctorService.writePrescription(prescription);
        return res;
    }
}
