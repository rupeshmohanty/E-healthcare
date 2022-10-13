package com.example.Ehealthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.Ehealthcare.dto.ResponseDetailsDto;
import com.example.Ehealthcare.dto.RootDto;
import com.example.Ehealthcare.entity.Diseases;
import com.example.Ehealthcare.repository.DiseasesDao;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    DiseasesDao diseasesDao;

    @Override
    public RootDto getDiseaseInfo(String diseaseName) {
        RootDto dto = new RootDto();
        ResponseDetailsDto res = new ResponseDetailsDto();
        Diseases diseaseData = diseasesDao.getData(diseaseName);

        if(!ObjectUtils.isEmpty(diseaseData)) {
            res.setResponseCode("200");
            res.setResponseStatus("Success");
            res.setResponseMessage("Disease information fetched");
            dto.setResponse(res);
            dto.setDiseaseDetails(diseaseData);
        } else {
            res.setResponseCode("400");
            res.setResponseStatus("Failed");
            res.setResponseMessage("Unable to get info for the entered disease");
            dto.setResponse(res);
        }

        return dto;
    }
    
}
