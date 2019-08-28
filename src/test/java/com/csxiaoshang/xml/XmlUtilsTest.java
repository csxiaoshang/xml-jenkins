package com.csxiaoshang.xml;

import org.junit.Test;
import java.io.*;
import java.text.MessageFormat;

public class XmlUtilsTest {

    @Test
    public void readXml() throws IOException {
        System.out.println(    XmlUtils.readXml("D:\\github\\jenkins\\xmljenkins\\src\\main\\resources\\test.xml"));
        System.out.println("-----------------------------------------");
        MessageFormat messageFormat =new MessageFormat(XmlUtils.readXml("D:\\github\\jenkins\\xmljenkins\\src\\main\\resources\\test.xml"));
        String string = messageFormat.format(new Object[]{"xiaoming","asdf","asdf"});
        System.out.println("result "+ string);
        System.out.println(this.getClass());
    }

/*    @Test
    public void freemarker() throws ParserConfigurationException, SAXException, IOException, TemplateException {
        Configuration configuration = new Configuration();
        configuration.setDirectoryForTemplateLoading(new File("D:\\github\\jenkins\\xmljenkins\\src\\main\\resources\\templates"));
        Template template = configuration.getTemplate("/config.ftl");
        Map person = new HashMap();
        person.put("id",1);
        person.put("flag","svn");
        Map root =new HashMap();
        root.put("person",person);
       Writer out = new StringWriter();
        template.process(root,out);
        System.out.println(out);
    }*/
}