# camelexamples

maven archetype simple

mvn archetype:generate -DgroupId=NameYourGroup -DartifactId=NameYourArtifact -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false


mvn archetype camel

mvn archetype:generate  -DarchetypeGroupId=org.apache.camel.archetypes   -DarchetypeArtifactId=camel-archetype-spring   -DarchetypeVersion=2.14.4  -DgroupId=NameYourGroup   -DartifactId=NameYourArtifact 




monitoring camel with hawt.io
=========================================================
https://vimeo.com/141917680
https://www.youtube.com/watch?v=wSlCWJL0Q5I
https://opensourceconnections.com/blog/2015/06/03/hawt-makes-camel-hotter/
https://dzone.com/articles/apache-camel-web-dashboard
http://joaodiogovicente.blogspot.com/2015/04/manage-your-camel-app-with-hawtio_14.html

monitoring camel with moskito
================================================================================
https://blog.anotheria.net/msk/the-full-complete-integration-guide-to-moskito-step-0/
https://blog.anotheria.net/msk/the-complete-moskito-integration-guide-step-1/
https://github.com/anotheria/moskito-demo
https://confluence.opensource.anotheria.net/display/MSK/MoSKito-Essential+Integration+Guide

jolokia agent for hawt.io
===========================================================
http://localhost:8091/hawtio/welcome
This page allows you to connect to remote processes which already have a jolokia agent running inside them. You will need to know the host name, port and path of the jolokia agent to be able to connect. 
If the process you wish to connect to does not have a jolokia agent inside, please refer to the jolokia documentation for how to add a JVM, servlet or OSGi based agent inside it. 
https://jolokia.org/
https://jolokia.org/agent.html
https://jolokia.org/reference/html/agents.html#agents-war

testing camel
========================================================================
https://www.toptal.com/apache/integracion-optimizada-de-software-un-tutorial-de-apache-camel
Apache Camel tiene una funcionalidad bastante amplia para escribir rutas de prueba con componentes simulados. Es una herramienta poderosa pero escribir rutas separadas solo para las pruebas es un proceso que consume tiempo. Sería más eficiente ejecutar pruebas en las rutas de producción sin modificar su canalización. Camel tiene esta característica y puede implementarse utilizando el componente AdviceWith.



camel books
============================================================================00
https://vdocuments.site/camel-manual-2110.html
https://thesis.science.upjs.sk/~mperejda/files/bachelor/src/camelinaction.pdf
https://cds.cern.ch/record/1383861/files/CERN-THESIS-2011-098.pdf


camel 
Threading Model
Available as of Camel 2.3
============================================================00
https://people.apache.org/~dkulp/camel/threading-model.html
Camel leverages thread pools in the following places:
several EIP patterns supports using thread pools for concurrency
SEDA component for asynchronous connectivity
Threads DSL in the Camel route
ServicePool for pooling services
And some component provide thread pools by nature such as JMS, Jetty


camel blogs and podcasts
==================================================================
http://www.davsclaus.com/2017/01/great-podcast-about-apache-camel-from.html
https://www.javapubhouse.com/2017/01/episode-62-hm-whats-best-to-travel-this.html
https://help.eclipse.org/kepler/index.jsp?topic=%2Forg.eclipse.stardust.docs.camel%2Fhtml%2Fcamel%2Fcamel-introduction.html








           <velocity-version>1.4</velocity-version>
           <moskito.version>2.5.5</moskito.version>
               <moskito-control-agent>1.1.1</moskito-control-agent>
            <distributeme.version>2.1.3</distributeme.version>
            <apache-camel-version>2.14.4</apache-camel-version>



                <!-- Spring Boot -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
            <version>${spring-boot}</version>
        </dependency>


            <dependency>
                <groupId>org.apache.camel</groupId>
                <artifactId>camel-velocity</artifactId>
                <version>${apache-camel-version}</version>
                </dependency>




                <!--  Velocity -->
                <dependency>
                        <groupId>velocity</groupId>
                        <artifactId>velocity</artifactId>
                        <version>${velocity-version}</version>
                </dependency>




                <!-- Moskito -->
                <dependency>
                        <groupId>net.anotheria</groupId>
                        <artifactId>moskito-core</artifactId>
                        <version>${moskito.version}</version>
                </dependency>
                <dependency>
                        <groupId>net.anotheria</groupId>
                        <artifactId>moskito-aop</artifactId>
                        <version>${moskito.version}</version>
                </dependency>
                <dependency>
                        <groupId>org.moskito</groupId>
                        <artifactId>moskito-control-agent-rmi-endpoint-j6</artifactId>
                        <version>${moskito-control-agent}</version>
                </dependency>
                <dependency>
                        <groupId>org.moskito</groupId>
                        <artifactId>moskito-control-agent-j6</artifactId>
                        <version>${moskito-control-agent}</version>
                </dependency>
                <!-- Moskito -->




                <!-- DistributeMe dependencies -->
                <dependency>
                        <groupId>net.anotheria</groupId>
                        <artifactId>distributeme-core</artifactId>
                        <version>${distributeme.version}</version>
                </dependency>
                <dependency>
                        <groupId>net.anotheria</groupId>
                        <artifactId>distributeme-generator</artifactId>
                        <version>${distributeme.version}</version>
                </dependency>
                <dependency>
                        <groupId>net.anotheria</groupId>
                        <artifactId>distributeme-support</artifactId>
                        <version>${distributeme.version}</version>
                </dependency>

