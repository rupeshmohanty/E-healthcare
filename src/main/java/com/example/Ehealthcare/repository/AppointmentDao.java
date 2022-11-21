package com.example.Ehealthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Ehealthcare.entity.Appointment;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Long>{
	@Query(value = "SELECT e FROM Appointment e WHERE e.provider = ?1")
    List<Appointment> getAppointments(long provider);
	
	@Query(value = "SELECT e FROM Appointment e WHERE e.id = ?1")
    Appointment fetchAppointment(long appId);
}
