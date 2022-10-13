package com.example.Ehealthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.Ehealthcare.dto.ResponseDetailsDto;
import com.example.Ehealthcare.dto.RootDto;
import com.example.Ehealthcare.entity.Diseases;
import com.example.Ehealthcare.repository.DiseasesDao;

@Service
public class DiseasesServiceImpl implements DiseasesService{

    @Autowired
    DiseasesDao diseasesDao;

    @Override
    public RootDto addDiseaseInfo(Diseases diseases) {
        RootDto dto = new RootDto();
        ResponseDetailsDto res = new ResponseDetailsDto();
        Diseases newDisease = new Diseases();

        newDisease.setName(diseases.getName());
        newDisease.setDescription(diseases.getDescription());
        newDisease.setSymptoms(diseases.getSymptoms());
        newDisease.setCauses(diseases.getCauses());
        newDisease.setSeriousCauses(diseases.getSeriousCauses());
        newDisease.setDiagnosis(diseases.getDiagnosis());

        newDisease = diseasesDao.save(newDisease);

        if(!ObjectUtils.isEmpty(newDisease)) {
            res.setResponseCode("200");
            res.setResponseStatus("Success");
            res.setResponseMessage("Disease info added");
            dto.setResponse(res);
            dto.setDiseaseDetails(newDisease);
        } else {
            res.setResponseCode("400");
            res.setResponseStatus("Failed");
            res.setResponseMessage("Unable to add disease info");
            dto.setResponse(res);
        }

        return dto;
    }
    
}
