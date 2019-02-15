# Dementiell Veränderte Person

Dies ist der Microservice zur Verwaltung von dementiell veränderten Personen (DVP). 
Eine DVP hat die üblichen Attribute einer Person, sowie die ID des Ortungsmoduls 
der Schuhsohle. Weitere Informationen zu Details, wie der REST-API dem Eventing 
und dem allgemeinen Aufbau befinden sich im 
[Wiki](https://github.com/Archi-Lab/fae-team-2-dementiell-veraenderte-person/wiki).

## Prerequisites

* [Maven](https://maven.apache.org/install.html)
* [Docker](https://www.docker.com/)

## Getting Started

Projekt bauen
```
mvn install -DskipTests=true
```

Docker Image bauen:
```
docker-compose build
```

Docker Container starten:
```
docker-compose up
```

Mehrere Docker Container starten:
```
docker-compose up --scale dvp=2
```

## Acknowledgements

* Der Eventing Code wurde von [REWE Digital](https://github.com/rewe-digital/integration-patterns) übernommen.
* Die EntityUUID4 Klasse wurde von [Team 4](https://github.com/Archi-Lab/fae-team-4) übernommen. 
* Das docker-compose File ist an das vom [sample-microservice](https://github.com/Archi-Lab/sample-microservice) angelehnt.