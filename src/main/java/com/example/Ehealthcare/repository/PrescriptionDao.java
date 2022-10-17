package com.example.Ehealthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ehealthcare.entity.Prescription;

@Repository
public interface PrescriptionDao extends JpaRepository<Prescription, Long>{
    
}
