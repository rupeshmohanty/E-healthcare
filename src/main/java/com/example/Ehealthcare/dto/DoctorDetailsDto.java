package com.example.Ehealthcare.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class DoctorDetailsDto {
    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("department")
    private String department;

    @JsonProperty("certificate")
    private String certificate;

    @JsonProperty("yoe")
    private String yoe;

    @JsonProperty("workingAt")
    private String workingAt;

    @JsonProperty("status")
    private String status;

    @JsonProperty("createdOn")
    private Date createdOn;

    @JsonProperty("lastUpdatedOn")
    private Date lastUpdatedOn;
}
