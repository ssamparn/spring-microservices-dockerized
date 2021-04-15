FROM openjdk:11
COPY target/dockerized-spring-app.jar dockerized-spring-app.jar
WORKDIR /tmp
EXPOSE 9090
ENTRYPOINT ["sh","-c","java -jar /dockerized-spring-app.jar"]
