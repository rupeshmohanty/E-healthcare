package com.example.Ehealthcare.service;

import com.example.Ehealthcare.dto.RootDto;

public interface PatientService {
    RootDto getDiseaseInfo(String diseaseName);
}
