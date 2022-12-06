package com.test.raisin.controller;

import com.test.raisin.client.SourceClient;
import com.test.raisin.service.SourceAService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXParseException;

@RestController
@RequestMapping(value = "/api/v1")
public class Controller {

    private final SourceAService sourceAService;
    private final SourceClient sourceClient;

    public Controller(SourceAService sourceAService, SourceClient sourceClient) {
        this.sourceAService = sourceAService;
        this.sourceClient = sourceClient;
    }

    @GetMapping(value = "/a")
    public ResponseEntity allIDs(){
        return ResponseEntity.ok(sourceAService.getAsourceIds());
    }

    @GetMapping(value = "/b")
    public ResponseEntity allIDsB() throws SAXParseException {
        return ResponseEntity.ok(sourceClient.getIDsB());
    }
}
