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
@Table(name = "appointment")
@DynamicUpdate
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "patientType")
    private String patientType;

    @Column(name = "provider")
    private Long provider;

    @Column(name = "preferredTime")
    private String prefferedTime;

    @Column(name = "preferredDay")
    private String prefferedDay;

    @Column(name = "reason")
    private String reason;

    @Column(name = "additionalRequests")
    private String requests;
}
