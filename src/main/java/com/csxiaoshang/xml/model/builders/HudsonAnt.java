package com.csxiaoshang.xml.model.builders;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class HudsonAnt {

    /**
     * Ant 构建步骤
     */
    private String targets;

    private String antName;

    private String buildFile = "${WORKSPACE}/builddir/build.xml";

    /**
     * Ant 构建参数
     */
    private String properties;
}
