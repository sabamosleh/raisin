package com.test.raisin.service;

import com.test.raisin.client.SourceAclient;
import model.ResponseA;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SourceAService {

    public SourceAService(SourceAclient sourceAclient) {
        this.sourceAclient = sourceAclient;
    }

    private final SourceAclient sourceAclient;

    public String getAsourceIds(){
        List<String> ids = new ArrayList<>();
        ResponseA responseA = new ResponseA();
        responseA.setId("kkk");
        responseA.setStatus("kkk");
//        while (!responseA.getStatus().equals("done")){
//            responseA = sourceAclient.getIDsA();
//            System.out.println("*** "+responseA.getId());
            ids.add(sourceAclient.getIDsA());
//        }
            return responseA.getId();
    }


}
