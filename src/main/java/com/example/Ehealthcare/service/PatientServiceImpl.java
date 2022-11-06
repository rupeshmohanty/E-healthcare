package com.example.Ehealthcare.service;

import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.Ehealthcare.dto.PatientDetailsDto;
import com.example.Ehealthcare.dto.ResponseDetailsDto;
import com.example.Ehealthcare.dto.RootDto;
import com.example.Ehealthcare.entity.Diseases;
import com.example.Ehealthcare.entity.Patient;
import com.example.Ehealthcare.entity.Testimonials;
import com.example.Ehealthcare.repository.DiseasesDao;
import com.example.Ehealthcare.repository.PatientDao;
import com.example.Ehealthcare.repository.TestimonialsDao;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    DiseasesDao diseasesDao;

    @Autowired
    TestimonialsDao testimonialsDao;

    @Autowired
    PatientDao patientDao;

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

    @Override
    public RootDto writeTestimonial(Testimonials testimonials) {
        RootDto dto = new RootDto();
        ResponseDetailsDto res = new ResponseDetailsDto();
        Testimonials newTestimonials = new Testimonials();

        newTestimonials.setPatientName(testimonials.getPatientName());
        newTestimonials.setTestimonial(testimonials.getTestimonial());
        newTestimonials.setRecommend(testimonials.getRecommend());
        
        newTestimonials = testimonialsDao.save(newTestimonials);

        if(!ObjectUtils.isEmpty(newTestimonials)) {
            res.setResponseCode("200");
            res.setResponseStatus("Success");
            res.setResponseMessage("Testimonial posted");
            dto.setResponse(res);
        } else {
            res.setResponseCode("400");
            res.setResponseStatus("Failed");
            res.setResponseMessage("Unable to post testimonial");
            dto.setResponse(res);
        }

        return dto;
    }

    @Override
    public RootDto registerUser(Patient patient) {
        RootDto dto = new RootDto();
        ResponseDetailsDto res = new ResponseDetailsDto();
        
        Patient checkPatient = patientDao.getUser(patient.getEmail());

        if(!ObjectUtils.isEmpty(checkPatient)) {
            res.setResponseCode("400");
            res.setResponseStatus("Failed");
            res.setResponseMessage("This user already exists! Login to proceed");
            dto.setResponse(res);
        } else {
            Patient newPatient = new Patient();

            newPatient.setName(patient.getName());
            newPatient.setGender(patient.getGender());
            newPatient.setAge(patient.getAge());
            newPatient.setEmail(patient.getEmail());
            String encPassword = Base64.getEncoder().encodeToString(patient.getPassword().getBytes());
            newPatient.setPassword(encPassword);
            newPatient.setAddress(patient.getAddress());
            newPatient.setCreatedOn(new Date());
            newPatient = patientDao.save(newPatient);
            
            if(!ObjectUtils.isEmpty(newPatient)) {
                res.setResponseCode("200");
                res.setResponseStatus("Success");
                res.setResponseMessage("Patient registered");
                dto.setResponse(res);
            } else {
                res.setResponseCode("400");
                res.setResponseStatus("Failed");
                res.setResponseMessage("Unable to register new user!");
                dto.setResponse(res);
            }
        }

        return dto;
    }

    @Override
    public RootDto loginUser(Patient patient) {
        RootDto dto = new RootDto();
        ResponseDetailsDto res = new ResponseDetailsDto();
        Patient patientData = patientDao.getUser(patient.getEmail());

        if(!ObjectUtils.isEmpty(patientData)) {
            // decrypting the db password!
            byte[] decodedBytes = Base64.getDecoder().decode(patientData.getPassword());
            String dbPassword = new String(decodedBytes);

            if(patient.getPassword().equals(dbPassword)) {
                res.setResponseCode("200");
                res.setResponseStatus("Success");
                res.setResponseMessage("Logged in successfully");
                dto.setResponse(res);
                PatientDetailsDto patientDetails = new PatientDetailsDto();
                patientDetails.setId(patientData.getId());
                patientDetails.setEmail(patientData.getEmail());
                patientDetails.setName(patientData.getName());
                patientDetails.setAddress(patientData.getAddress());
                patientDetails.setAge(patientData.getAge());
                patientDetails.setGender(patientData.getGender());
                patientDetails.setCreatedOn(patientData.getCreatedOn());
                dto.setPatientDetails(patientDetails);
            } else {
                res.setResponseCode("400");
                res.setResponseStatus("Failed");
                res.setResponseMessage("Password does not match");
                dto.setResponse(res);
            }
        } else {
            res.setResponseCode("400");
            res.setResponseStatus("Failed");
            res.setResponseMessage("No such user is registered in our system");
            dto.setResponse(res);
        }

        return dto;
    }
    
}
