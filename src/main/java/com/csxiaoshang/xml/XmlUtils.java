package com.csxiaoshang.xml;

import com.csxiaoshang.xml.model.builders.HudsonAnt;
import com.csxiaoshang.xml.model.builders.HudsonGradle;
import com.csxiaoshang.xml.model.root.Project;
import com.csxiaoshang.xml.model.scm.HudsonGit;
import com.csxiaoshang.xml.model.scm.Hudsonbranch;
import com.csxiaoshang.xml.model.scm.Scm;
import com.csxiaoshang.xml.model.scm.svn.HudsonSub;
import javafx.beans.property.ObjectProperty;
import lombok.extern.slf4j.Slf4j;

import javax.swing.text.html.Option;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.annotation.XmlElement;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 获取configXml接口工具类
 */
@Slf4j
public class XmlUtils {


    public static String readXml(String path) throws IOException {
        FileReader fileReader = new FileReader(new File(path));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return String.valueOf(stringBuilder);
    }

    /**
     * 获取基本的configXml框架接口
     *
     * @return xml字符串
     * @throws JAXBException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static String getConfigXml() throws JAXBException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class project = Project.class;
        String projectName = project.getName();
        Object root = getRoot(projectName);
        return writeXml(root);
    }

    /**
     * 根据传入Project获取configXml字符串
     * @param project
     * @return
     * @throws JAXBException
     */
    public static String getConfigXml(Project project) throws JAXBException {
        return writeXml(project);
    }

    /**
     * 获取xml根元素  根元素一般为<project></>
     *
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static Project getProject() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class project = Project.class;
        String projectName = project.getName();
        Object root = getRoot(projectName);
        return (Project) root;
    }

    private static Scm getScm(Project project) {
        return Optional.ofNullable(project)
                .map(p -> p.getScm())
                .orElse(null);
    }

    private static HudsonSub getHudsonSub(Project project) {
        return Optional.ofNullable(project)
                .map(p -> p.getScm())
                .map(scm -> scm.getLocations())
                .map(locations -> locations.getHudsonSub())
                .orElse(null);
    }

    private static HudsonGit getHudsonGit(Project project) {
        return Optional.ofNullable(project)
                .map(p -> p.getScm())
                .map(scm -> scm.getUserRemoteConfigs())
                .map(userRemoteConfigs -> userRemoteConfigs.getHudsonGit())
                .orElse(null);
    }

    /**
     * 设置git仓库url
     * @param project
     * @param url
     */
    public static void setGitUrl(Project project, String url) {
        getHudsonGit(project).setUrl(url);
    }

    /**
     * 设置git仓库凭据
     * @param project
     * @param credentialsId
     */
    public static void setGitCredentialsId(Project project, String credentialsId) {
        getHudsonGit(project).setCredentialsId(credentialsId);
    }

    /**
     * 设置git仓库代码分支
     * @param project
     * @param branch
     */
    public static void setGitBranch(Project project, String branch) {
        Optional.ofNullable(getScm(project))
                .map(scm -> scm.getBranches())
                .map(branches -> branches.getHudsonbranch())
                .ifPresent(hudsonBranch -> hudsonBranch.setName(branch));
    }

    /**
     * 设置svn仓库url
     * @param project
     * @param string
     */
    public static void setSvnUrl(Project project, String string) {
        getHudsonSub(project).setRemote(string);
    }

    /**
     * 设置svn仓库凭据
     * @param project
     * @param credentialsId
     */
    public static void setSvnCredentialsId(Project project, String credentialsId) {
        getHudsonSub(project).setCredentialsId(credentialsId);
    }

    /**
     * 设置构建之前shell命令
     * @param project
     * @param command
     */
    public static void setHudsonShell(Project project, String command) {
        Optional.ofNullable(project)
                .map(p -> p.getBuilders())
                .map(builders -> builders.getHudsonShell())
                .ifPresent(hudsonShell -> hudsonShell.setCommand(command));
    }

    /**
     * 添加gradle构建使用的参数和构建步骤（clean release等）
     * @param project
     * @param hudsonGradles
     */
    public static void setGradleConfig(Project project, List<HudsonGradle> hudsonGradles) {
        Optional.ofNullable(project)
                .map(p -> p.getBuilders())
                .ifPresent(builders -> builders.setHudsonGradles(hudsonGradles));
    }

    public static void setGradleConfig(Project project,HudsonGradle hudsonGradle){
        List<HudsonGradle> hudsonGradles = new ArrayList<>();
        hudsonGradles.add(hudsonGradle);
        Optional.ofNullable(project)
                .map(p -> p.getBuilders())
                .ifPresent(builders -> builders.setHudsonGradles(hudsonGradles));
    }

    /**
     * 添加ant构建使用的参数和构建步骤(clean release等)
     * @param project
     * @param hudsonAnt
     */
    public static void setAntConfig(Project project, HudsonAnt hudsonAnt){
        List<HudsonAnt> hudsonAnts = new ArrayList<>();
        hudsonAnts.add(hudsonAnt);
        Optional.ofNullable(project)
                .map(p -> p.getBuilders())
                .ifPresent(builders -> builders.setHudsonAnts(hudsonAnts));
    }

    public static void setAntConfig(Project project,List<HudsonAnt> hudsonAnts){
        Optional.ofNullable(project)
                .map(p -> p.getBuilders())
                .ifPresent(builders -> builders.setHudsonAnts(hudsonAnts));
    }

    /**
     * 添加构建之后的shell命令
     * @param project
     * @param command
     */
    public static void setHudsonShellAfterBuild(Project project,String command){
        Optional.ofNullable(project)
                .map(p -> p.getBuilders())
                .map(builders -> builders.getHudsonShellAfterBuild())
                .ifPresent(hudsonShell -> hudsonShell.setCommand(command));
    }


    /**
     * 根据类全限定名递归注入依赖对象
     *
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
        for (Field field : fields) {
            if (!field.isAnnotationPresent(XmlElement.class)) {
                continue;
            }
            String fieldName = field.getType().getName();
            if (fieldName.contains("List")) {
                continue;
            }
            Object fieldObj = getRoot(fieldName);
            field.setAccessible(true);
            field.set(object, fieldObj);
        }
        return object;
    }

    private static String writeXml(Object root) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(root.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
        Writer writer = new StringWriter();
        marshaller.marshal(root, writer);
        return String.valueOf(writer);
    }
}
