package com.csxiaoshang.xml.model.builders;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class HudsonGradle {

    private String switches;

    private String tasks;

    private String rootBuildScriptDir;

    private String buildFile;

    private String gradleName = "(Default)";

    private boolean userWrapper = true;

    private boolean makeExecutable;

    private boolean userWorkspaceAsHome;

    private String wrapperLocation = "${WORKSPACE}";

    private  boolean passAllAsSystemProperties;

    private String projectProperties = "";

    private boolean passAllAsProjectProperties;

}
