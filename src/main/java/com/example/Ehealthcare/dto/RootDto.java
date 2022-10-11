package com.example.Ehealthcare.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import com.example.Ehealthcare.entity.Appointment;

@Data
@JsonInclude(Include.NON_NULL)
public class RootDto {
    @JsonProperty("response")
    private ResponseDetailsDto response;

    @JsonProperty("appointmentDetails")
    private Appointment appointmentDetails;
}
