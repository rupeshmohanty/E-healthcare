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
@Table(name = "prescription")
@DynamicUpdate
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "providerId")
    private long providerId;

    @Column(name = "patientName")
    private String patientName;

    @Column(name = "sickness")
    private String sickness;

    @Column(name = "priority")
    private String priority;

    @Column(name = "medicines")
    private String medicines;
}
