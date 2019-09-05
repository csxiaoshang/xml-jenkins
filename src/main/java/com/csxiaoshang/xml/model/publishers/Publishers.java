package com.csxiaoshang.xml.model.publishers;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Publishers {

    /**
     * 注解注释后 便不适用jenkins邮箱发送功能
     */
    //@XmlElement(name = "hudson.plugins.emailext.ExtendedEmailPublisher")
    private HudsonEmail hudsonEmail;
}
