package com.example.Ehealthcare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@Table(name = "testimonials")
@DynamicUpdate
public class Testimonials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "patientName")
    private String patientName;

    @Column(name = "testimonial")
    private String testimonial;

    @Column(name = "recommend")
    private String recommend;
}