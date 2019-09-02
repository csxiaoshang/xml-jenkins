package com.csxiaoshang.xml.model.root;

import com.csxiaoshang.xml.model.Actions;
import com.csxiaoshang.xml.model.Properties;
import com.csxiaoshang.xml.model.builders.Builders;
import com.csxiaoshang.xml.model.publishers.Publishers;
import com.csxiaoshang.xml.model.scm.Scm;
import com.csxiaoshang.xml.model.triggers.Triggers;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * root element for ant  gradle and so on
 */
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {

    @XmlElement(name = "actions")
    private Actions actions;
    private String  description = "";
    private boolean keepDependencies;

    @XmlElement(name = "properties")
    private Properties properties;

    @XmlElement(name = "scm")
    private Scm scm;

    private boolean canRoam = true;

    private boolean disabled;

    private boolean blockBuildWhenDownstreamBuilding;

    private boolean blockBuildWhenUpstreamBuilding;

    @XmlElement(name = "triggers")
    private Triggers triggers;

    private boolean concurrentBuild;

    @XmlElement(name = "builders")
    private Builders builders;

    @XmlElement(name = "publishers")
    private Publishers publishers;
}
