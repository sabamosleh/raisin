package com.test.raisin.model;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


@Data
@XmlRootElement(name = "msg")
@XmlAccessorType(XmlAccessType.FIELD)
public class Msg implements Serializable {
    @XmlElement(name = "id")
    private Id id;
}
