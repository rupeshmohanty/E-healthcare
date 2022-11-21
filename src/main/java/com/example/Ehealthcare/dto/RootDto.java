package com.example.Ehealthcare.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

import java.util.List;

import com.example.Ehealthcare.entity.Appointment;
import com.example.Ehealthcare.entity.Diseases;
import com.example.Ehealthcare.entity.Doctor;
import com.example.Ehealthcare.entity.Prescription;

@Data
@JsonInclude(Include.NON_NULL)
public class RootDto {
    @JsonProperty("response")
    private ResponseDetailsDto response;

    @JsonProperty("appointmentDetails")
    private Appointment appointmentDetails;

    @JsonProperty("diseaseDetails")
    private Diseases diseaseDetails;

    @JsonProperty("prescription")
    private Prescription prescription;

    @JsonProperty("doctor")
    private Doctor doctor;

    @JsonProperty("appointments")
    private List<Appointment> appointments;

    @JsonProperty("patientDetails")
    private PatientDetailsDto patientDetails;

    @JsonProperty("doctorDetails")
    private DoctorDetailsDto doctorDetails;

	public void setResponse(ResponseDetailsDto response) {
		this.response = response;
	}

	public void setAppointmentDetails(Appointment appointmentDetails) {
		this.appointmentDetails = appointmentDetails;
	}

	public void setDiseaseDetails(Diseases diseaseDetails) {
		this.diseaseDetails = diseaseDetails;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public void setPatientDetails(PatientDetailsDto patientDetails) {
		this.patientDetails = patientDetails;
	}

	public void setDoctorDetails(DoctorDetailsDto doctorDetails) {
		this.doctorDetails = doctorDetails;
	}
    
    
}
