package com.test.raisin.service;

import com.test.raisin.client.SourceAclient;
import com.test.raisin.model.Id;
import com.test.raisin.model.Msg;
import com.test.raisin.model.ResponseA;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SourceAService {

    public SourceAService(SourceAclient sourceAclient) {
        this.sourceAclient = sourceAclient;
    }

    private final SourceAclient sourceAclient;

    public List<String> getAsourceIds() {
        List<String> ids = new ArrayList<>();
        ResponseA responseA = ResponseA.builder().build();
        responseA.setId("0");
        responseA.setStatus("init");
        while (!responseA.getStatus().equals("done")) {
            try {
                responseA = sourceAclient.getIDsA();
                ids.add(responseA.getId());
            } catch (Exception e) {//todo: handle exception better
                getBsourceIds();
            }
        }
        return ids;
    }

    public List<String> getBsourceIds() {
        List<String> ids = new ArrayList<>();
        Msg message = new Msg();
        Id messageId = new Id();
        messageId.setValue("00");
        message.setId(messageId);
        while (message.getId() != null) {
            try {
                message = sourceAclient.getIDsB();
            } catch (Exception e) {//todo: handle exception better
                getAsourceIds();
            }
        }
        return ids;
    }
}


