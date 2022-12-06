package com.test.raisin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "msg")
@XmlAccessorType(XmlAccessType.FIELD)
public class Msg implements Serializable {
    @XmlElement(name = "id")
    private Id id;
}
