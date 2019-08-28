package com.csxiaoshang.xml.model.scm.svn;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class HudsonSub {
    private String remote;

    private String credentialsId;

    private String local = ".";

    private String depthOption = "infinity";

    private boolean ignoreExternalsOption = true;
}
