package com.example.Ehealthcare.service;

import com.example.Ehealthcare.dto.RootDto;
import com.example.Ehealthcare.entity.Patient;
import com.example.Ehealthcare.entity.Testimonials;

public interface PatientService {
    RootDto getDiseaseInfo(String diseaseName);
    RootDto writeTestimonial(Testimonials testimonials);
    RootDto registerUser(Patient patient);
    RootDto loginUser(Patient patient);
}
