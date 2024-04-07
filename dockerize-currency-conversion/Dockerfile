FROM openjdk:21
VOLUME /tmp
EXPOSE 8100
ADD target/dockerize-currency-conversion.jar dockerize-currency-conversion.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /dockerize-currency-conversion.jar" ]