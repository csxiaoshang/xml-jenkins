package com.csxiaoshang.xml;

import com.csxiaoshang.xml.model.root.Project;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import java.io.*;
import java.lang.reflect.Field;

/**
 * 获取configXml接口工具类
 */
public class XmlUtils {


    public static String readXml(String path) throws IOException {
        FileReader fileReader = new FileReader(new File(path));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line = bufferedReader.readLine();
        while(line!=null){
            stringBuilder.append(line);
            stringBuilder.append("\n");
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return String.valueOf(stringBuilder);
}

    /**
     * 获取基本的configXml框架接口
     * @return  xml字符串
     * @throws JAXBException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static String getConfigXml() throws JAXBException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class project = Project.class;
        String projectName = project.getName();
        Object root = getRoot(projectName);
        JAXBContext jaxbContext = JAXBContext.newInstance(root.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
        Writer writer = new StringWriter();
        marshaller.marshal(root,writer);
        return String.valueOf(writer);
    }

    /**
     * 根据类全限定名递归注入依赖对象
     * @param className
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private static Object getRoot(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
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
}
