package com.test.raisin.config;

import com.test.raisin.Exception.Exception_406;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
//        String requestUrl = response.request().url();
//        Response.Body responseBody = response.body();
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());
        System.out.println("*****"+responseStatus);
        if (responseStatus.is4xxClientError()) {
            System.out.println("*** 406 saba");
            return new Exception_406();
        } else {
            System.out.println("*****"+responseStatus);
            return new Exception("Generic exception");
        }
    }
}
