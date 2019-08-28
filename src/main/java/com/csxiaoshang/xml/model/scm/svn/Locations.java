package com.csxiaoshang.xml.model.scm.svn;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Locations {

    @XmlElement(name = "hudson.scm.SubversionSCM_-ModuleLocation")
    private HudsonSub hudsonSub;
}
