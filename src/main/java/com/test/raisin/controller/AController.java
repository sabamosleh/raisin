package com.test.raisin.controller;

import com.test.raisin.service.SourceAService;
import model.ResponseA;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class AController {

    private final SourceAService sourceAService;

    public AController(SourceAService sourceAService) {
        this.sourceAService = sourceAService;
    }

    @GetMapping(value = "/a")
    public String allIDs(){
        return sourceAService.getAsourceIds();
    }
}
