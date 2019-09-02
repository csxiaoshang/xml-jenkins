# xml-jenkins
 Generate config.xml for jenkins job
 
 ## What is the "xml-jenkins"?
 
Generate config.xml for jenkins job
  
 ## Getting Started
 
 If you like to use this library you need to add the library as a dependency
 to your project. This can be done by using a Maven dependency like the following: 
 
 ```xml
 <dependency>
    <groupId>com.github.csxiaoshang</groupId>
    <artifactId>xml-jenkins</artifactId>
    <version>1.0-SNAPSHOT</version>
 </dependency>
 ```
 
 
 ## Usage
 
 The `com.github.csxiaoshang.xml-jenkins` class provides the main entry
 point into the API. You can get xml String like this:
 
 ```java
 String xml= XmlUtils.getConfigXml();
 ```
 or:
 
  ```java
Project project= XmlUtils.getProject();
XmlUtils.setGitUrl(project,"https://github.com//demo/demo.git")
...
String xml = XmlUtils.getConfigXml(project);
 
  ```
 