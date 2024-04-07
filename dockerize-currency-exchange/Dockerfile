FROM openjdk:21
VOLUME /tmp
EXPOSE 8000
ADD target/dockerize-currency-exchange.jar dockerize-currency-exchange.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /dockerize-currency-exchange.jar" ]