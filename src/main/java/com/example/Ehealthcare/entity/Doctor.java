package com.example.Ehealthcare.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@Table(name = "doctor")
@DynamicUpdate
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "department")
    private String department;

    @Column(name = "certificate")
    private String certificate;

    @Column(name = "yoe")
    private String yoe;

    @Column(name = "workingAt")
    private String workingAt;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_on")
    private Date createdOn;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_updatedon")
    private Date lastUpdatedOn;
}
