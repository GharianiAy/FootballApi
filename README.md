# FootballApi Project

## Requirements

For building and running the application you need:

- [Java 17](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3](https://maven.apache.org/download.cgi)

## How To Run

1. Install [MySQL](https://dev.mysql.com/downloads/installer/)
2. Execute command `git clone https://github.com/GharianiAy/FootballApi.git`
3. Execute command `cd FootballApi`
4. Configure datasource in *main/resources/application.yml*
```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/footdb
    username: username
    password: password
```
```
6. Execute command `mvn clean install`
7. run the project
8. The server is running on **localhost:8080**

## Explore Rest APIs
examples : 
    - curl --location 'http://localhost:8080/equipes?page=0&size=10&sortBy=name' \ --header 'Accept: application/json'
    
    - curl --location 'http://localhost:8080/equipes' \
--header 'Content-Type: application/json' \
--data '{
           "name": "PSG",
           "acronym": "PSG",
           "budget": 200.0
         }'
         
    - curl --location 'http://localhost:8080/joueurs'
         
    - curl --location 'http://localhost:8080/joueurs' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Dupont",
    "position": "Attaquant"
}'


To explore documentation, run the application and go to `http://localhost:8080/swagger-ui.html`
