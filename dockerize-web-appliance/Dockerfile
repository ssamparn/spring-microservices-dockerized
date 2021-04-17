FROM openjdk:11
COPY target/appliance-web-app.jar appliance-web-app.jar
WORKDIR /tmp
EXPOSE 9090
ENTRYPOINT ["sh","-c","java -jar /appliance-web-app.jar"]

#FROM openjdk:11
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.containerize.web.appliance.ApplianceWebApplication"]
