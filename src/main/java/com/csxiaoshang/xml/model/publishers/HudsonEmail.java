package com.csxiaoshang.xml.model.publishers;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class HudsonEmail {

    private String recipientList;

    @XmlElement(name = "configuredTriggers")
    private ConfiguredTriggers configuredTriggers;

    private String contentType = "default";

    private String defaultSubject;

    private String defaultContent;

    private String attachmentsPattern = "";

    private String presendScript = "$DEFAULT_PRESEND_SCRIPT";

    private String postsendScript = "";

    private boolean attachBuildLog;

    private boolean compressBuildLog;

    private String replyTo = "$DEFAULT_REPLYTO";

    private boolean saveOutput;

    private boolean disabled;
}
