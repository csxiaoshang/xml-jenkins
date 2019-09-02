package com.csxiaoshang.xml.model.scm;

import com.csxiaoshang.xml.model.scm.svn.Locations;
import com.csxiaoshang.xml.model.scm.svn.WorkspaceUpdater;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Scm {
    @XmlAttribute(name = "class")
    private String ClassXml;

    @XmlAttribute(name = "plugin")
    private String plugin;

    @XmlElement(name = "locations")
    private Locations locations;

    private String configVersion;

    @XmlElement(name = "userRemoteConfigs")
    private UserRemoteConfigs userRemoteConfigs;

    @XmlElement(name = "branches")
    private Branches branches;

    private String excludeRegions = "";

    private String includeRegions = "";

    private String excludeUsers = "";

    private String excludeRevprop = "";

    private String excludeCommitMessages = "";

    @XmlElement(name = "workspaceUpdater")
    private WorkspaceUpdater workspaceUpdater;

    private boolean ignoreDirPropChanges;

    private boolean filterChangelog;

    private String doGenerateSubmoduleConfigurations;

    @XmlElement(name = "submoduleCfg")
    private SubmoduleCfg submoduleCfg;

    @XmlElement(name = "extensions")
    private  Extensions extensions;


}
