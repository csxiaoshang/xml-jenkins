package com.csxiaoshang.xml.model.builders;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Builders {

    @XmlElement(name = "hudson.tasks.Shell")
    private HudsonShell hudsonShell;

    @XmlElement(name = "EnvInjectBuilder")
    private EnvInjectBuilder envInjectBuilder;

    @XmlElement(name = "hudson.plugins.gradle.Gradle")
    private List<HudsonGradle> hudsonGradles;

    @XmlElement(name = "hudson.tasks.Ant")
    private List<HudsonAnt> hudsonAnts;

    @XmlElement(name = "hudson.tasks.Shell")
    private HudsonShell hudsonShellAfterBuild;
}
