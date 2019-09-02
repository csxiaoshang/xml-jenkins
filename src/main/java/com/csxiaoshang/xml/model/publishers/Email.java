package com.csxiaoshang.xml.model.publishers;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Email {

    private String subject;

    private String body;

    @XmlElement(name = "recipientProviders")
    private RecipientProviders recipientProviders;

    private String attachmentsPattern;

    private boolean attachBuildLog;

    private boolean compressBuildLog;

    private String replyTo = "$PROJECT_DEFAULT_REPLYTO";

    private String contentType = "project";
}
