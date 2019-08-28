package com.csxiaoshang.xml.model.triggers;

import com.csxiaoshang.xml.model.scm.svn.HudsonSub;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Triggers {

    @XmlElement(name = "hudson.triggers.SCMTrigger")
    private HudsonTriggers hudsonTriggers;
}
