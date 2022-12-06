package com.test.raisin.service;

import com.test.raisin.client.SourceAclient;
import com.test.raisin.model.Id;
import com.test.raisin.model.Msg;
import com.test.raisin.model.ResponseA;
import com.test.raisin.model.SinkRequest;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.SetUtils;
import org.apache.maven.settings.SettingsUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SourceAService {

    Set<String> aSet = new HashSet<>();
    Set<String> bSet = new HashSet<>();

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
                aSet.add(responseA.getId());
                ids.add(responseA.getId());
            } catch (Exception e) {//todo: handle exception better
                getBsourceIds();
            }
        }
        createSinkRecords();
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
                bSet.add(message.getId().getValue());
            } catch (Exception e) {//todo: handle exception better
                System.out.println("message : "+message);
                aSet.add(sourceAclient.getIDsA().getId());
            }
        }
        return ids;
    }

    public void createSinkRecords(){

       Set diffSet =  SetUtils.difference(aSet,bSet);
       diffSet.forEach(
                 (k)->sourceAclient.sendRecords( new SinkRequest("orphaned", (String) k))
       );

        Collection<String>  similars = CollectionUtils.intersection(aSet,bSet);
        similars.forEach(
                (k)->sourceAclient.sendRecords( new SinkRequest("joined", k))

        );
    }
}


