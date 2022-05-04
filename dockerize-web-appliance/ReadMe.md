# Dockerize-Spring-App
Dockerize Web Applicance Application is a simple Spring Boot Application created and containerized for the purpose of Learning how to containerize a Spring based Java Application.

## To run the Application using Spring Boot Maven Plugin
```bash
mvn spring-boot:run
```

## Docker Commands - Creating Docker Image Manually

### 1) Build a .jar
```bash
$ mvn clean install
```

### 2) Set up prerequisites for running the .jar
```bash
$ docker run -dit openjdk:11
$ docker container ls
$ docker container exec container-id ls /tmp
```
> -d = --detached (option for running the container in detached mode) <br />
> -i = --interactive (option for running the container in interactive mode) <br />
> -t = --tty <br />

### 3) Copy the .jar into /tmp directory 
```bash
$ docker container cp target/appliance-web-app.jar container-id:/tmp
$ docker container exec <container-id> ls /tmp
```

### 4) Save the container changes into an image
```bash
$ docker container commit <container-id> appliance-web-app:latest
$ docker images
$ docker container ls
```

### 5) Run the .jar from the /tmp directory
```bash
$ docker container commit --change='CMD ["java","-jar","/tmp/appliance-web-app.jar"]' <container-id> appliance-web-app:latest
$ docker run -p 8080:8080 appliance-web-app:latest
```

## Docker File

### Basic
```bash
FROM openjdk:11
ADD target/hello-world-rest-api.jar hello-world-rest-api.jar
WORKDIR /tmp
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar /hello-world-rest-api.jar"]
```

### Genric
```bash
FROM openjdk:11
ADD target/*.jar app.jar
WORKDIR /tmp
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]
```

### To Build the Docker Image from Dockerfile
```bash
$ docker build -f Dockerfile -t appliance-web-app:latest .
```
```bash
$ docker images
$ docker container ls
$ docker run -p 8080:8080 appliance-web-app:latest
$ docker history appliance-web-app:latest
```

## Plugins

### Dockerfile Maven

> Spotify Maven plugin creates docker images with the help of a Dockerfile.

- From Spotify https://github.com/spotify/dockerfile-maven

```
<plugin>
	<groupId>com.spotify</groupId>
	<artifactId>dockerfile-maven-plugin</artifactId>
	<version>1.4.10</version>
	<executions>
		<execution>
			<id>default</id>
			<goals>
				<goal>build</goal>
			</goals>
		</execution>
	</executions>
	<configuration>
		<repository>in28min/${project.name}</repository>
		<tag>${project.version}</tag>
		<skipDockerInfo>true</skipDockerInfo>
	</configuration>
</plugin>
```

### Improve Caching of Images using Layers
#### CURRENT SITUATION

			--------------- 
			    FAT JAR
			--------------- 
			      JDK
			--------------- 

####  DESIRED SITUATION
			--------------- 
			    CLASSES   
			---------------
			 DEPENDENCIES 
			---------------
			     JDK      
			---------------

### Maven Dependency Plugin
```
<plugin>	
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-dependency-plugin</artifactId>
	<executions>
		<execution>
			<id>unpack</id>
			<phase>package</phase>
			<goals>
				<goal>unpack</goal>
			</goals>
			<configuration>
				<artifactItems>
					<artifactItem>
						<groupId>${project.groupId}</groupId>
						<artifactId>${project.artifactId}</artifactId>
						<version>${project.version}</version>
					</artifactItem>
				</artifactItems>
			</configuration>
		</execution>
	</executions>
</plugin>
```
### Corresponding Docker file

```bash
FROM openjdk:11
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/classes /app
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
ENTRYPOINT ["java","-cp","app:app/lib/*","com.containerize.springappdockerize.SpringAppDockerizeApplication"]
```

### To Build the Docker Image from Dockerfile
```bash
$ docker build -f Dockerfile -t spring-app-dockerize:latest .
```

### JIB Plugin
> JIB Maven plugin creates docker images without a Dockerfile.
#### "useCurrentTimestamp - true" discussion
- https://github.com/GooleContainerTools/jib/blob/master/docs/faq.md#why-is-my-image-created-48-years-ago
- https://github.com/GoogleContainerTools/jib/issues/413

```
<plugin>
	<groupId>com.google.cloud.tools</groupId>
	<artifactId>jib-maven-plugin</artifactId>
	<version>1.6.1</version>
	<configuration>
		<container>
			<creationTime>USE_CURRENT_TIMESTAMP</creationTime>
		</container>
	</configuration>
	<executions>
		<execution>
			<phase>package</phase>
			<goals>
				<goal>dockerBuild</goal>
			</goals>
		</execution>
	</executions>
</plugin>
```
### Few JIB Maven Plugin configuration
```
<configuration>
	<from>
		<image>openjdk:alpine</image>
	</from>
	<to>
		<image>${project.name}</image>
		<tags>
			<tag>${project.version}</tag>
			<tag>latest</tag>
		</tags>
	</to>
	<container>
		<jvmFlags>
			<jvmFlag>-Xms512m</jvmFlag>
		</jvmFlags>
		<mainClass>com.containerize.springappdockerize.SpringAppDockerizeApplication</mainClass>
		<ports>
			<port>9090</port>
		</ports>
	</container>
</configuration>
```

### fabric8io/docker-maven-plugin

> Fabric8 Maven plugin creates docker images with the help of a Dockerfile.

- https://dmp.fabric8.io/
- Remove Spotify Maven and JIB Plugins. Add the plugin shown below and configure property for jar file.

#### Supports
- Dockerfile
- Defining Dockerfile contents in POM XML.

#### Using Dockerfile

To build the image - "mvn clean package".
Successfully tagged spring-app-dockerize.
```bash
$ docker run -p 8080:8080 spring-app-dockerize:latest
```
```
<plugin>
	<groupId>io.fabric8</groupId>
	<artifactId>docker-maven-plugin</artifactId>
	<version>0.26.0</version>
	<executions>
		<execution>
			<id>docker-build</id>
			<phase>package</phase>
			<goals>
				<goal>build</goal>
			</goals>
		</execution>
	</executions>
</plugin>
```

```
<properties>
...
 <jar>${project.build.directory}/${project.build.finalName}.jar</jar>
</properties>
```

#### Using XML Configuration

```
<!-- To build the image - "mvn clean package" -->
<!-- TAG - 01-hello-world-rest-api:latest -->
<!-- docker run -p 8080:8080 01-hello-world-rest-api:latest -->
<plugin>
   <groupId>io.fabric8</groupId>
   <artifactId>docker-maven-plugin</artifactId>
   <version>0.26.0</version>
   <extensions>true</extensions>
   <configuration>
      <verbose>true</verbose>
      <images>
         <image>
            <name>${project.artifactId}</name>
            <build>
               <from>java:8-jdk-alpine</from>
               <entryPoint>
                  <exec>
                     <args>java</args>
                     <args>-jar</args>
                     <args>/maven/${project.build.finalName}.jar</args>
                  </exec>
               </entryPoint>
               <assembly>
                  <descriptorRef>artifact</descriptorRef>
               </assembly>
            </build>
         </image>
      </images>
   </configuration>
   <executions>
	<execution>
		<id>docker-build</id>
		<phase>package</phase>
		<goals>
			<goal>build</goal>
		</goals>
	</execution>
   </executions>
</plugin>
 ```
### To push the Docker Image to docker hub
```bash
$ docker push image-name:tag-name
$ docker push ssamantr/dockerize-web-appliance:0.0.1-SNAPSHOT
```
