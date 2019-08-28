package com.csxiaoshang.xml.model.publishers;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ConfiguredTriggers {

    @XmlElement(name = "hudson.plugins.emailext.plugins.trigger.SuccessTrigger")
    private HudsonEmailTrigger hudsonEmailTrigger;
}
