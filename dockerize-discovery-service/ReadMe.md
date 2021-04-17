# Discovery Service

## Resources

- http://localhost:8761

### Creating Containers
```bash
$ mvn clean package
```
### Running Containers

```bash
$ docker run --publish 8761:8761 --name discovery-server --network currency-network ssamantr/dockerize-discovery-service:0.0.1-SNAPSHOT
```
### Push Containers to DockerHub
```bash
$ docker login
$ docker push ssamantr/dockerize-discovery-service:0.0.1-SNAPSHOT
```