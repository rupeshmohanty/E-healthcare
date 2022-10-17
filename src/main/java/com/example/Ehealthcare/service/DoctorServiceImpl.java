package com.example.Ehealthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.Ehealthcare.dto.ResponseDetailsDto;
import com.example.Ehealthcare.dto.RootDto;
import com.example.Ehealthcare.entity.Prescription;
import com.example.Ehealthcare.repository.PrescriptionDao;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    PrescriptionDao prescriptionDao;

    @Override
    public RootDto writePrescription(Prescription prescription) {
        RootDto dto = new RootDto();
        ResponseDetailsDto res = new ResponseDetailsDto();
        Prescription newPrescription = new Prescription();

        newPrescription.setProviderId(prescription.getProviderId());
        newPrescription.setPatientName(prescription.getPatientName());
        newPrescription.setSickness(prescription.getSickness());
        newPrescription.setPriority(prescription.getPriority());
        newPrescription.setMedicines(prescription.getMedicines());
        newPrescription = prescriptionDao.save(newPrescription);
        
        if(!ObjectUtils.isEmpty(newPrescription)) {
            res.setResponseCode("200");
            res.setResponseStatus("Success");
            res.setResponseMessage("Patient prescription uploaded");
            dto.setResponse(res);
            dto.setPrescription(newPrescription);
        } else {
            res.setResponseCode("400");
            res.setResponseStatus("Failed");
            res.setResponseMessage("Unable to add patient prescription");
            dto.setResponse(res);
        }
        return dto;
    }
    
}
