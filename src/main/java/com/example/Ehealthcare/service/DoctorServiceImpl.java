package com.example.Ehealthcare.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.Ehealthcare.dto.DoctorDetailsDto;
import com.example.Ehealthcare.dto.ResponseDetailsDto;
import com.example.Ehealthcare.dto.RootDto;
import com.example.Ehealthcare.entity.Appointment;
import com.example.Ehealthcare.entity.Doctor;
import com.example.Ehealthcare.entity.FAQ;
import com.example.Ehealthcare.entity.Prescription;
import com.example.Ehealthcare.repository.AppointmentDao;
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
    
    @Autowired
    AppointmentDao appointmentDao;

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
    public RootDto registerDoctor(Doctor doctor) {
        RootDto dto = new RootDto();
        ResponseDetailsDto res = new ResponseDetailsDto();
        Doctor checkDoctor = doctorDao.getUser(doctor.getEmail());

        if(!ObjectUtils.isEmpty(checkDoctor)) {
            res.setResponseCode("400");
            res.setResponseStatus("Failed");
            res.setResponseMessage("You are already registered with us");
            dto.setResponse(res);
        } else {
            Doctor newDoctor = new Doctor();
            newDoctor.setName(doctor.getName());
            newDoctor.setEmail(doctor.getEmail());
            newDoctor.setDepartment(doctor.getDepartment());
            newDoctor.setCertificate(doctor.getCertificate());
            newDoctor.setYoe(doctor.getYoe());
            newDoctor.setWorkingAt(doctor.getWorkingAt());
            String encPassword = Base64.getEncoder().encodeToString(doctor.getPassword().getBytes());
            newDoctor.setPassword(encPassword);
            newDoctor.setStatus("Pending");
            newDoctor.setCreatedOn(new Date());
            
            // save the new doctor details
            newDoctor = doctorDao.save(newDoctor);

            if(!ObjectUtils.isEmpty(newDoctor)) {
                res.setResponseCode("200");
                res.setResponseStatus("Success");
                res.setResponseMessage("Doctor registered");
                dto.setResponse(res);
            } else {
                res.setResponseCode("400");
                res.setResponseStatus("Failed");
                res.setResponseMessage("Unable to save new doctor");
                dto.setResponse(res);
            }
        }
        
        return dto;
    }

    @Override
    public RootDto loginDoctor(Doctor doctor) {
        RootDto dto = new RootDto();
        ResponseDetailsDto res = new ResponseDetailsDto();
        Doctor doctorData = doctorDao.getUser(doctor.getEmail());

        if(!ObjectUtils.isEmpty(doctorData)) {
            // decrypting the db password
            byte[] decodedBytes = Base64.getDecoder().decode(doctorData.getPassword());
            String dbPassword = new String(decodedBytes);

            if(doctor.getPassword().equals(dbPassword)) {
                res.setResponseCode("200");
                res.setResponseStatus("Success");
                res.setResponseMessage("Logged in successfully!");
                dto.setResponse(res);
                DoctorDetailsDto doctorDetails = new DoctorDetailsDto();
                doctorDetails.setId(doctorData.getId());
                doctorDetails.setName(doctorData.getName());
                doctorDetails.setEmail(doctorData.getEmail());
                doctorDetails.setDepartment(doctorData.getDepartment());
                doctorDetails.setCertificate(doctorData.getCertificate());
                doctorDetails.setYoe(doctorData.getYoe());
                doctorDetails.setWorkingAt(doctorData.getWorkingAt());
                doctorDetails.setStatus(doctorData.getStatus());
                doctorDetails.setCreatedOn(doctorData.getCreatedOn());
                doctorDetails.setLastUpdatedOn(doctorData.getLastUpdatedOn());
                dto.setDoctorDetails(doctorDetails);
            } else {
                res.setResponseCode("400");
                res.setResponseStatus("Failed");
                res.setResponseMessage("Password does not match");
                dto.setResponse(res);
            }

        } else {
            res.setResponseCode("400");
            res.setResponseStatus("Failed");
            res.setResponseMessage("You are not registered with us");
            dto.setResponse(res);
        }

        return dto;
    }

	@Override
	public RootDto fetchAppointments(long id) {
		RootDto dto = new RootDto();
		ResponseDetailsDto res = new ResponseDetailsDto();
		List<Appointment> appointments = appointmentDao.getAppointments(id);
		
		if(!ObjectUtils.isEmpty(appointments)) {
			res.setResponseCode("200");
			res.setResponseStatus("Success");
			res.setResponseMessage("All appoinments fetched!");
			dto.setResponse(res);
			dto.setAppointments(appointments);
		} else {
			res.setResponseCode("400");
			res.setResponseStatus("Failed");
			res.setResponseMessage("No appointments found!");
			dto.setResponse(res);
		}
		
		return dto;
	}

	@Override
	public RootDto acceptAppoinment(long appId) {
		RootDto dto = new RootDto();
		ResponseDetailsDto res = new ResponseDetailsDto();
		Appointment appointment = appointmentDao.fetchAppointment(appId);
		
		if(!ObjectUtils.isEmpty(appointment)) {
			appointment.setStatus("Accepted");
			appointment = appointmentDao.save(appointment);
			
			res.setResponseCode("200");
			res.setResponseStatus("Success");
			res.setResponseMessage("Appointment accepted");
			dto.setResponse(res);
		} else {
			res.setResponseCode("400");
			res.setResponseStatus("Failed");
			res.setResponseMessage("Unable to accept the appointment");
			dto.setResponse(res);
		}
		
		return dto;
	}

	@Override
	public RootDto rejectAppoinment(long appId) {
		RootDto dto = new RootDto();
		ResponseDetailsDto res = new ResponseDetailsDto();
		Appointment appointment = appointmentDao.fetchAppointment(appId);
		
		if(!ObjectUtils.isEmpty(appointment)) {
			appointment.setStatus("Rejected");
			appointment = appointmentDao.save(appointment);
			
			res.setResponseCode("200");
			res.setResponseStatus("Success");
			res.setResponseMessage("Appointment rejected");
			dto.setResponse(res);
		} else {
			res.setResponseCode("400");
			res.setResponseStatus("Failed");
			res.setResponseMessage("Unable to reject appointment");
			dto.setResponse(res);
		}
		
		return dto;
	}
    
}
