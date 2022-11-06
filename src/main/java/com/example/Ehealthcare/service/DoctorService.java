package com.example.Ehealthcare.service;

import com.example.Ehealthcare.dto.RootDto;
import com.example.Ehealthcare.entity.Doctor;
import com.example.Ehealthcare.entity.FAQ;
import com.example.Ehealthcare.entity.Prescription;

public interface DoctorService {
    RootDto registerDoctor(Doctor doctor);
    RootDto loginDoctor(Doctor doctor);
    RootDto writePrescription(Prescription prescription);
    RootDto addFaq(FAQ faq);
}
