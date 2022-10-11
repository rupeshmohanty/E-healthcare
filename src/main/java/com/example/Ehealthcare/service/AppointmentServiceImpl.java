package com.example.Ehealthcare.service;

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
    
}
