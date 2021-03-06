hireartists-rest
==================

Technologies 
------------

maven, https://maven.apache.org/download.cgi

The project is created using `maven-archetype-webapp`.


Dependency
----------

```
<project>
    [...]
    <!-- jackson mapper -->
    <dependency>
        <groupId>org.codehaus.jackson</groupId>
        <artifactId>jackson-mapper-asl
        </artifactId>
        <version>1.9.0</version>
    </dependency>
    
    <dependency>
        <groupId>org.codehaus.jackson</groupId>
        <artifactId>jackson-core-asl</artifactId>
        <version>1.9.0</version>
    </dependency>
    <!-- jackson mapper -->
    [...]
</project>
```


View Resolver
-------------
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:tx="http://www.springframework.org/schema/tx"
xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd"
xmlns:p="http://www.springframework.org/schema/p">

        <!-- Root Context: defines shared resources visible to all other web components -->
        <bean
        class="org.springframework.web.servlet.view.ContentNegotiatingViewResolver">
                <property name="mediaTypes">
                    <map>
                    <entry key="html" value="text/html" />
                    <entry key="json" value="application/json" />
                    </map>
                </property>
                <property name="viewResolvers">
                    <list>
                    <bean id="viewResolver"
                    class="org.springframework.web.servlet.view.InternalResourceViewResolver"
                    p:viewClass="org.springframework.web.servlet.view.JstlView"
                    p:prefix="/WEB-INF/jsp/" p:suffix=".jsp" />
                    </list>
                </property>
                <property name="defaultViews">
                    <list>
                    <bean
                    class="org.springframework.web.servlet.view.json.MappingJacksonJsonView" />
                    </list>
                </property>
        </bean>
        
        <import resource="classpath:/WEB-INF/rest-layers.xml" />
</beans>
```


run-app
-------

change `db.properties`

```
$ mvn jetty:run

http://localhost:8080/hire-artists/artist/list

```
