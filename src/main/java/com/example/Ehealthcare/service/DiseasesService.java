package com.example.Ehealthcare.service;

import com.example.Ehealthcare.dto.RootDto;
import com.example.Ehealthcare.entity.Diseases;

public interface DiseasesService {
    RootDto addDiseaseInfo(Diseases diseases);
}
