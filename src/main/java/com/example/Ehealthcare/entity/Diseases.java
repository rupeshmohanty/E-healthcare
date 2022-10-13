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
@Table(name = "diseases")
@DynamicUpdate
public class Diseases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "symptoms")
    private String symptoms;

    @Column(name = "causes")
    private String causes;

    @Column(name = "seriousCauses")
    private String seriousCauses;

    @Column(name = "diagnosis")
    private String diagnosis;
}
