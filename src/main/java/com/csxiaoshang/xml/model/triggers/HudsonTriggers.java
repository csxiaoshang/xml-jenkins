package com.csxiaoshang.xml.model.triggers;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class HudsonTriggers {
    private String spec;

    private boolean ignorePostCommitHooks;
}
