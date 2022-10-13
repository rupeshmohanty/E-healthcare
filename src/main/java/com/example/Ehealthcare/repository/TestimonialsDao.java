package com.example.Ehealthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ehealthcare.entity.Testimonials;

@Repository
public interface TestimonialsDao extends JpaRepository<Testimonials,Long>{
    
}
