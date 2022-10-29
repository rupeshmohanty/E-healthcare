package com.example.Ehealthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.Ehealthcare.dto.ResponseDetailsDto;
import com.example.Ehealthcare.dto.RootDto;
import com.example.Ehealthcare.entity.Appointment;
import com.example.Ehealthcare.repository.AppointmentDao;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    AppointmentDao appointmentDao;

    @Override
    public RootDto bookAppointment(Appointment appointment) {
        ResponseDetailsDto res = new ResponseDetailsDto();
        RootDto dto = new RootDto();
        Appointment newAppointment = new Appointment();

        newAppointment.setName(appointment.getName());
        newAppointment.setEmail(appointment.getEmail());
        newAppointment.setPhoneNumber(appointment.getPhoneNumber());
        newAppointment.setPatientType(appointment.getPatientType());
        newAppointment.setProvider(appointment.getProvider());
        newAppointment.setPrefferedTime(appointment.getPrefferedTime());
        newAppointment.setPrefferedDay(appointment.getPrefferedDay());
        newAppointment.setReason(appointment.getReason());
        newAppointment.setRequests(appointment.getRequests());
        newAppointment.setStatus("Pending");
        
        // saving the data!
        newAppointment = appointmentDao.save(newAppointment);

        if(!ObjectUtils.isEmpty(newAppointment)) {
            res.setResponseCode("200");
            res.setResponseStatus("Success");
            res.setResponseMessage("Appointment booked");
            dto.setResponse(res);
            dto.setAppointmentDetails(newAppointment);
        } else {
            res.setResponseCode("400");
            res.setResponseStatus("Failed");
            res.setResponseMessage("Unable to book appointment");
            dto.setResponse(res);
        }

        return dto;
    }

    @Override
    public RootDto acceptAppointment(long id) {
        RootDto dto = new RootDto();
        ResponseDetailsDto res = new ResponseDetailsDto();
        Appointment appointment = appointmentDao.findById(id).get();

        appointment.setStatus("Accepted");
        appointment = appointmentDao.save(appointment);

        if(!ObjectUtils.isEmpty(appointment)) {
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
    public RootDto rejectAppointment(long id) {
        RootDto dto = new RootDto();
        ResponseDetailsDto res = new ResponseDetailsDto();
        Appointment appointment = appointmentDao.findById(id).get();

        appointment.setStatus("Rejected");
        appointment = appointmentDao.save(appointment);

        if(!ObjectUtils.isEmpty(appointment)) {
            res.setResponseCode("200");
            res.setResponseStatus("Success");
            res.setResponseMessage("Appointment rejected");
            dto.setResponse(res);
        } else {
            res.setResponseCode("400");
            res.setResponseStatus("Failed");
            res.setResponseMessage("Unable to reject the appointment");
            dto.setResponse(res);
        }

        return dto;
    }

    @Override
    public RootDto allAppointments() {
        RootDto dto = new RootDto();
        ResponseDetailsDto res = new ResponseDetailsDto();
        List<Appointment> appointments = appointmentDao.findAll();

        if(!ObjectUtils.isEmpty(appointments)) {
            res.setResponseCode("200");
            res.setResponseStatus("Success");
            res.setResponseMessage("All appointments fetched");
            dto.setResponse(res);
            dto.setAppointments(appointments);
        } else {
            res.setResponseCode("400");
            res.setResponseStatus("Failed");
            res.setResponseMessage("Unable to fetch all the appointments");
            dto.setResponse(res);
        }

        return dto;
    }
    
}
