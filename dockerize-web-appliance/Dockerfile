### to be used when creating docker image with spotify docker file maven plugin

#FROM openjdk:11
#COPY target/dockerize-web-appliance.jar dockerize-web-appliance.jar
#WORKDIR /tmp
#EXPOSE 9090
#ENTRYPOINT ["sh","-c","java -jar /dockerize-web-appliance.jar"]

### to be used when creating docker image with jib-maven-plugin

#FROM openjdk:11
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.containerize.web.appliance.ApplianceWebApplication"]
