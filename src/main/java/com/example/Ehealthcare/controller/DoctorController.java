package com.example.Ehealthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ehealthcare.dto.RootDto;
import com.example.Ehealthcare.entity.Diseases;
import com.example.Ehealthcare.service.DiseasesService;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {
    
    @Autowired
    DiseasesService diseasesService;

    @PostMapping("/diseases")
    RootDto addDiseaseInfo(Diseases diseases) {
        RootDto res = diseasesService.addDiseaseInfo(diseases);
        return res;
    }
}
