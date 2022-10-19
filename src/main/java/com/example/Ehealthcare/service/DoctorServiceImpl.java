package com.example.Ehealthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.Ehealthcare.dto.ResponseDetailsDto;
import com.example.Ehealthcare.dto.RootDto;
import com.example.Ehealthcare.entity.Doctor;
import com.example.Ehealthcare.entity.FAQ;
import com.example.Ehealthcare.entity.Prescription;
import com.example.Ehealthcare.repository.DoctorDao;
import com.example.Ehealthcare.repository.FaqDao;
import com.example.Ehealthcare.repository.PrescriptionDao;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    PrescriptionDao prescriptionDao;

    @Autowired
    FaqDao faqDao;

    @Autowired
    DoctorDao doctorDao;

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

    @Override
    public RootDto addFaq(FAQ faq) {
        RootDto dto = new RootDto();
        ResponseDetailsDto res = new ResponseDetailsDto();
        FAQ newFaq = new FAQ();

        newFaq.setQuestion(faq.getQuestion());
        newFaq.setAnswer(faq.getAnswer());
        newFaq = faqDao.save(newFaq);

        if(!ObjectUtils.isEmpty(newFaq)) {
            res.setResponseCode("200");
            res.setResponseStatus("Success");
            res.setResponseMessage("FAQ added");
            dto.setResponse(res);
        } else {
            res.setResponseCode("400");
            res.setResponseStatus("Failed");
            res.setResponseMessage("Unable to add faq");
            dto.setResponse(res);
        }

        return dto;
    }

    @Override
    public RootDto addDoctor(Doctor doctor) {
        RootDto dto = new RootDto();
        ResponseDetailsDto res = new ResponseDetailsDto();
        Doctor newDoctor = new Doctor();

        newDoctor.setName(doctor.getName());
        newDoctor.setDepartment(doctor.getDepartment());
        newDoctor.setCertificate(doctor.getCertificate());
        newDoctor.setWorkingAt(doctor.getWorkingAt());
        newDoctor.setYoe(doctor.getYoe());
        newDoctor = doctorDao.save(newDoctor);

        if(!ObjectUtils.isEmpty(newDoctor)) {
            res.setResponseCode("200");
            res.setResponseStatus("Success");
            res.setResponseMessage("New doctor added");
            dto.setResponse(res);
            dto.setDoctor(newDoctor);
        } else {
            res.setResponseCode("400");
            res.setResponseStatus("Failed");
            res.setResponseMessage("Unable to add new doctor");
            dto.setResponse(res);
        }

        return dto;
    }
    
}
