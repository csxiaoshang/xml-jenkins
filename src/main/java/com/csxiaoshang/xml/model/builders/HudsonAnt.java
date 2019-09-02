package com.csxiaoshang.xml.model.builders;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class HudsonAnt {

    private String targets;

    private String antName;

    private String buildFile = "${WORKSPACE}/builddir/build.xml";

    private String properties;
}
