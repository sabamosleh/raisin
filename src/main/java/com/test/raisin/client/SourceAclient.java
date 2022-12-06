package com.test.raisin.client;

import com.test.raisin.Exception.Exception_406;
import com.test.raisin.config.FeignConfig;
import com.test.raisin.model.Msg;
import com.test.raisin.model.ResponseA;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.xml.sax.SAXParseException;


@FeignClient(value = "AClient",url = "http://localhost:7299/source", configuration = FeignConfig.class)
public interface SourceAclient {

    @GetMapping("/a")
    ResponseA getIDsA() throws Exception_406;

    @GetMapping(value = "/b", produces = MediaType.APPLICATION_XML_VALUE)
    Msg getIDsB() throws HttpMessageNotReadableException;
}
