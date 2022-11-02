package com.example.Ehealthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ehealthcare.entity.Patient;

@Repository
public interface PatientDao extends JpaRepository<Patient, Long>{
    
}
