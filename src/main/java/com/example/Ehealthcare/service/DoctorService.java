package com.example.Ehealthcare.service;

import com.example.Ehealthcare.dto.RootDto;
import com.example.Ehealthcare.entity.Prescription;

public interface DoctorService {
    RootDto writePrescription(Prescription prescription);
}
