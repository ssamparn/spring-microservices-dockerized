# Currency Exchange Micro Service

## Resources

- http://localhost:8000/currency-exchange/from/USD/to/INR

## H2 Console

- http://localhost:8000/h2-console

### Basic - currency-conversion-service,currency-exchange-service 

```bash
$ docker network create currency-network
$ docker run -p 8000:8000 --network=currency-network -d --name=currency-exchange-service ssamantr/dockerize-currency-exchange:1.0.0
$ docker run -p 8100:8100 --network=currency-network -d --name=currency-conversion-service --env CURRENCY_EXCHANGE_URI=http://currency-exchange-service:8000 ssamantr/dockerize-currency-conversion:1.0.0
```

### Push Containers to DockerHub
```bash
$ docker login
$ docker push ssamantr/dockerize-currency-exchange:1.0.0
```

### Run Containers from Docker Compose
```bash
$ docker-compose up
$ docker-compose up -d
```

### Scale Containers from Docker Compose
```bash
$ docker-compose scale currency-exchange-service=2
```
