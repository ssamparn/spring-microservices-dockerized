#FROM openjdk:11
#COPY target/dockerized-spring-app.jar dockerized-spring-app.jar
#WORKDIR /tmp
#EXPOSE 9090
#ENTRYPOINT ["sh","-c","java -jar /dockerized-spring-app.jar"]

FROM openjdk:11
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.containerize.springappdockerize.SpringAppDockerizeApplication"]
