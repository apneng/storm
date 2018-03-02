spring+springMVC+mybatis框架整合

功能说明：用ssm框架组合实现简单增删改查

主要页面list.jsp
（ http://localhost:8080/storm/manage/list）

查找框提供模糊查询，可同时查找两张表中包含关键字的内容并返回到list中


开发工具：Eclipse
开发环境：基于windows  

数据库 MySQL
导入测试数据 doc/yankon.sql
请修改src/main/resources/jdbc.properties这个文件的数据库连接

jdk1.8
tomcat

主要jar包（可参见pom.xml）
1） spring 4.3.11.RELEASE
2） mybatis 3.4.5
3）mybatis-spring 1.3.1
4）javaee 7.0
5）mysql-connector-java 5.1.30
6）log4j 1.2.17
7） slf4j-api 1.7.7
8)fastjson 1.1.41
