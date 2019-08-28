package com.csxiaoshang.xml.model.scm;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class HudsonExtensions {
    private boolean disableSubmodules;

    private boolean recursiveSubmodules = true;

    private boolean trackingSubmodules;

    private boolean parentCredentials;
}
