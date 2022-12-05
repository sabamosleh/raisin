package com.test.raisin.client;

import model.ResponseA;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient(value = "AClient",url = "http://localhost:7299/source")
public interface SourceAclient {

    @GetMapping("/a")
    Map getIDsA();

    @RequestMapping(method = RequestMethod.GET, value = "/b")
    String getIDsB();
}
