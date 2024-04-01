FROM ubuntu:24.04
ENV TOMCAT_HOME=/u01/middleware/apache-tomcat-10.1.19
ENV PATH=$PATH:$TOMCAT_HOME/bin
ENV JAVA_HOME=/u01/middleware/jdk-17.0.1
ENV PATH=$PATH:$JAVA_HOME/bin

RUN apt update -y
RUN mkdir -p /u01/middleware

WORKDIR /u01/middleware
ADD https://download.java.net/java/GA/jdk17.0.1/2a2082e5a09d4267845be086888add4f/12/GPL/openjdk-17.0.1_linux-x64_bin.tar.gz .
RUN tar -xzvf openjdk-17.0.1_linux-x64_bin.tar.gz
RUN rm openjdk-17.0.1_linux-x64_bin.tar.gz
ADD https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.19/bin/apache-tomcat-10.1.19.tar.gz .
RUN tar -xzvf apache-tomcat-10.1.19.tar.gz
RUN rm apache-tomcat-10.1.19.tar.gz

COPY /target/order-service-0.0.1-SNAPSHOT.war apache-tomcat-10.1.19/webapps/
COPY run.sh apache-tomcat-10.1.19/bin
RUN chmod u+x apache-tomcat-10.1.19/bin/run.sh
EXPOSE 8080
ENTRYPOINT ["apache-tomcat-10.1.19/bin/run.sh"]
