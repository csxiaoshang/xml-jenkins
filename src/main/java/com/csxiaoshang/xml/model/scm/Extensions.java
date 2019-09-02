package com.csxiaoshang.xml.model.scm;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Extensions {

    @XmlElement(name = "hudson.plugins.git.extensions.impl.SubmoduleOption")
    private HudsonExtensions hudsonExtensions;
}
