package com.csxiaoshang.xml.model.builders;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class EnvInjectBuilder {

    @XmlAttribute(name = "plugin")
    private String plugin = "envinject@2.1.3";

    @XmlElement(name = "info")
    private Info info;
}
