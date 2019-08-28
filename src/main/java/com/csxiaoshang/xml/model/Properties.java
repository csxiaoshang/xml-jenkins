package com.csxiaoshang.xml.model;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 *element Properties
 */

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Properties {

    @XmlElementWrapper(name = "hudson.security.AuthorizationMatrixProperty")
    @XmlElement(name = "permission")
    private List<String> permissions;
}
