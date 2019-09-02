package com.csxiaoshang.xml.model.scm;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class UserRemoteConfigs {

    @XmlElement(name = "hudson.plugins.git.UserRemoteConfig")
    private HudsonGit hudsonGit;
}
