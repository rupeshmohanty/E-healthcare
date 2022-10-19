package com.example.Ehealthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ehealthcare.entity.FAQ;

@Repository
public interface FaqDao extends JpaRepository<FAQ, Long>{
    
}
