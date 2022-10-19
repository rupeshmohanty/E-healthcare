package com.example.Ehealthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ehealthcare.entity.Doctor;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, Long>{
    
}
