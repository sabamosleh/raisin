package com.test.raisin.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SinkRequest {
    String kind;
    String id;
}
