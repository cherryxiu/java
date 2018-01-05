### 一、创建一个web工程

### 二、实现对spring的支持
> 1.实现对Sping的支持

Spring version:`Spring 3.0`
jar包：`Spring 3.0 AOP Libraries`,`Spring 3.0 Core Libraries`,`Spring 3.0 Persistence Core Libraries`,`Spring 3.0 Web Libraries`,
> 搭建springMVC环境
> 实现对Spring的支持
	在web.xml配置springMVC核心
	创建springMVC配置文件
	
> 创建控制器(在配置文件中进行扫描)

> 搭建mybatis环境
导mybatis必备包+数据库驱动包
创建mybatis主配置文件（连接数据库信息，映射器配置文件信息，全局配置，别名）
创建pojo
创建映射器(接口)
创建映射器配置文件(***.xml)，一定要配置在mybatis主配置文件里

>springMVC配置文件中配置数据源
将mybatis交给Spring管理（sqlSessionFactory）
mapper自动扫描







web.xml文件
```
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.5" 
	xmlns="http://java.sun.com/xml/ns/javaee" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
	http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
  <display-name></display-name>	
  <welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>
  <!-- 启动监听器 org.springframework.web-3.0.5.RELEASE.jar-->
  <listener>
  	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  <!-- 读取spring的配置文件 -->
  <context-param>
  	<param-name>contextConfigLocation</param-name>
  	<param-value>classpath:config/SpringMVC-servlet.xml</param-value>
  </context-param>
  
  <!-- 加载springmvc核心org.springframework.web.servlet-3.0.5.RELEASE.jar -->
  <servlet>
  	<servlet-name>SpringMVC</servlet-name>
  	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  	<!-- 指定SpringMVC路径 -->
  	<init-param>
  		<param-name>contextConfigLocation</param-name>
  		<param-value>classpath:config/SpringMVC-servlet.xml</param-value>
  	</init-param>
  </servlet>
  <servlet-mapping>
  	<servlet-name>SpringMVC</servlet-name>
  	<url-pattern>*.form</url-pattern>
  </servlet-mapping>
  
  
  
  <!-- 设置编码格式 -->
  <filter>
  		<filter-name>characterEncodingFilter</filter-name>
  		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
  		<init-param>
		  	<param-name>encoding</param-name>
		  	<param-value>UTF-8</param-value>
  		</init-param>
  		<init-param>
		  	<param-name>forceEncoding</param-name>
		  	<param-value>true</param-value>
  		</init-param>
  </filter>
  <filter-mapping>
  	<filter-name>characterEncodingFilter</filter-name>
  	<url-pattern>/*</url-pattern>
  </filter-mapping>
</web-app>
```

SpringMVC-servlet.xml文件
```
<?xml version="1.0" encoding="UTF-8"?>
<beans
	xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
						http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd
						http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd">


	<!-- 创建命名空间 -->
	
	
	<!-- 扫描控制器-->
	<context:component-scan base-package="com.cn.action,com.cn.service"></context:component-scan>
	
	<!-- 启动驱动 ，调用校验bean时会需要驱动-->
	<mvc:annotation-driven/>
	
	<!-- 注入校验bean -->
	<bean class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean"></bean>
	
	<!-- 导入外部的jdbc文件 -->
	<context:property-placeholder properties-ref="classpath:config/jdbc.properties"/>
	
	<!-- 连接数据源 -->
	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="${driver}"></property>
		<property name="url" value="${url}"></property>
		<property name="username" value="${username}"></property>
		<property name="password" value="${password}"></property>
	</bean>
	
	<!--将mybatis交给springmvc管理，直接生成sqlSession对象  -->
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"></property>
		<property name="configLocation" value="classpath:config/mybatis-config.xml"></property>
	</bean>
	
	<!-- 扫描mapper-->
	<!-- 为了把dao放入springmvc容器中，action、service层不用写在 xml中，因为可以用@service来放入容器，而dao层没有@service功能 -->
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="basePackage" value="com.cn.dao"></property>
		<property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
	</bean>
</beans>
```
Mybatis文件
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <settings>     
    	<!-- 允许JDBC支持生成的键 -->
        <setting name="useGeneratedKeys" value="true"/> 
    </settings>  
	<typeAliases>
		<!-- 配置数据类型的别名 -->
		<typeAlias type="com.cn.pojo.Manager"  alias="manager"/>
		
	</typeAliases>
	
	
</configuration>
```
jdbc.properties文件
```
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/userdata?characterEncoding=utf-8
username=root
password=111
```
