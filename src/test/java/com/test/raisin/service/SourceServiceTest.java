package com.test.raisin.service;

import com.test.raisin.client.SourceClient;
import com.test.raisin.model.ResponseA;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class SourceServiceTest {

    @Mock
    SourceClient sourceClient;

    @Autowired
    SourceService sourceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sourceService = new SourceService(sourceClient);
    }

    @Test
    void getAsourceIds_200_OK(){

        //given
        ResponseA responseA = ResponseA.builder().build();
        responseA.setId(UUID.randomUUID().toString());
        responseA.setStatus("done");
        Mockito.when(sourceClient.getIDsA()).thenReturn(responseA);
        //when
        List<String> ids = sourceService.getAsourceIds();
        //then
        Assertions.assertNotNull(ids);
        Assertions.assertNotEquals(0,ids.size());
    }

}
