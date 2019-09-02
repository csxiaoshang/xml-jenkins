package com.csxiaoshang.xml.model.scm;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class HudsonGit {

    private String url;
    private String credentialsId;
}
