package com.test.raisin.controller;

import com.test.raisin.client.SourceAclient;
import com.test.raisin.service.SourceAService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXParseException;

@RestController
@RequestMapping(value = "/api/v1")
public class AController {

    private final SourceAService sourceAService;
    private final SourceAclient sourceAclient;

    public AController(SourceAService sourceAService, SourceAclient sourceAclient) {
        this.sourceAService = sourceAService;
        this.sourceAclient = sourceAclient;
    }

    @GetMapping(value = "/a")
    public ResponseEntity allIDs(){
        return ResponseEntity.ok(sourceAService.getAsourceIds());
    }

    @GetMapping(value = "/b")
    public ResponseEntity allIDsB() throws SAXParseException {
        return ResponseEntity.ok(sourceAclient.getIDsB());
    }
}
