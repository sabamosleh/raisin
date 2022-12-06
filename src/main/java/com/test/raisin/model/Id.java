package com.test.raisin.model;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Id implements Serializable {

    @XmlAttribute
    String value;
}