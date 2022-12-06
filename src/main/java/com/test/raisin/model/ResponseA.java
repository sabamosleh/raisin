package com.test.raisin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@Data
@Builder
public class ResponseA {

    private String status;
    private String id;

}
