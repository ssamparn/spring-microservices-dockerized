# Dockerfile has no use here as we are replying on Cloud Native Buildpack of Spring Boot

#FROM openjdk:17
#WORKDIR /tmp
#COPY target/dockerize-web-appliance.jar dockerize-web-appliance.jar
#EXPOSE 9090
#ENTRYPOINT ["sh","-c","java -jar /dockerize-web-appliance.jar"]

### to be used when creating docker image with jib-maven-plugin

#FROM openjdk:17
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.containerize.web.appliance.ApplianceWebApplication"]
