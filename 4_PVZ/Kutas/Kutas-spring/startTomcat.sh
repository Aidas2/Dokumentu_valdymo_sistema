#!/bin/bash

mvn clean install org.codehaus.cargo:cargo-maven2-plugin:1.7.0:run -Dcargo.maven.containerId=tomcat8x -Dcargo.servlet.port=8081 -Dcargo.maven.containerUrl=http://repo1.maven.org/maven2/org/apache/tomcat/tomcat/8.5.35/tomcat-8.5.35.zip
