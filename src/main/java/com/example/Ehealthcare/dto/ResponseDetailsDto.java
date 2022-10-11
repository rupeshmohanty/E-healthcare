package com.example.Ehealthcare.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ResponseDetailsDto {
    @JsonProperty("responseCode")
    private String responseCode;

    @JsonProperty("responseStatus")
    private String responseStatus;

    @JsonProperty("responseMessage")
    private String responseMessage;
}
