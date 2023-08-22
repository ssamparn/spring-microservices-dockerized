# Currency Conversion Micro Service

## Resources

- http://localhost:8100/currency-converter/from/EUR/to/INR/quantity/10

### Creating Containers
```bash
$ mvn clean package
```
### Running Containers

```bash
$ docker run --publish 8100:8100 --network currency-network --env CURRENCY_EXCHANGE_URI=http://currency-exchange-service:8000 ssamantr/dockerize-currency-conversion:1.0.0
```
### Push Containers to DockerHub
```bash
$ docker login
$ docker push ssamantr/dockerize-currency-conversion:1.0.0
```