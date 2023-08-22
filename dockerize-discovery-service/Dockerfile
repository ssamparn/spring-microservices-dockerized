FROM openjdk:17
VOLUME /tmp
EXPOSE 8761
ADD target/dockerize-discovery-service.jar dockerize-discovery-service.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /dockerize-discovery-service.jar" ]