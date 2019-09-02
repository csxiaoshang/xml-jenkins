package com.csxiaoshang.xml.model.scm.svn;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkspaceUpdater {

    @XmlAttribute(name = "class")
    private String classXml = "hudson.scm.subversion.UpdateWithCleanUpdater";
}
