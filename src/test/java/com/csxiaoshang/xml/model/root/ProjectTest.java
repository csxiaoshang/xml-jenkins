package com.csxiaoshang.xml.model.root;

import com.csxiaoshang.xml.XmlUtils;
import com.csxiaoshang.xml.model.Properties;
import com.csxiaoshang.xml.model.scm.Scm;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;

import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;

public class ProjectTest {
    @Test
    public void convey2xml() throws JAXBException {
        Project project = new Project();
        project.setDescription("");
        Properties properties =new Properties();
        Scm scm = new Scm();
        project.setProperties(properties);
        project.setScm(scm);
        JAXBContext jaxbContext = JAXBContext.newInstance(Project.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
        Writer writer = new StringWriter();
        marshaller.marshal(project,writer);
        System.out.println(writer);
    }

    @Test
    public void reflectNewInstance() throws JAXBException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class project = Project.class;
        String projectName = project.getName();
        Object root = getRoot(projectName);
        JAXBContext jaxbContext = JAXBContext.newInstance(root.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
        Writer writer = new StringWriter();
        marshaller.marshal(root,writer);
        System.out.println(writer);
    }

    /**
     * 根据类全限定名递归注入依赖对象
     * @param className
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public Object getRoot(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clz = Class.forName(className);
        Object object = clz.newInstance();
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields){
            if (!field.isAnnotationPresent(XmlElement.class)){
                continue;
            }
            String fieldName = field.getType().getName();
            if (fieldName.contains("List")){
                continue;
            }
            Object fieldObj = getRoot(fieldName);
            field.setAccessible(true);
            field.set(object,fieldObj);
        }
        return object;
    }

    @Test
    public void test(){
        Class clz = Properties.class;
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields){
            String fieldName = field.getType().getName();
            System.out.println(fieldName);
        }
    }

    @Test
    public void testGetConfigXml() throws ClassNotFoundException, InstantiationException, IllegalAccessException, JAXBException {
        System.out.println(XmlUtils.getConfigXml());
    }

}