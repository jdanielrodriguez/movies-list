# Cleverpy application test
### Installation
The application is encapsulated to be used with [docker-compose](https://docs.docker.com/compose/) so it is necessary to have the latest version of [Docker](https://www.docker.com/products/docker-desktop) installed, as well as [Node.js](https://nodejs.org/es/download/) to ensure that the deployments are done correctly.

## Prerequisites

What things you need to install the software and how to install them

```
openjdk version "1.8.0_312"
```
```
docker version "latest"
```
## BUILD the application 
```bash
 > ./gradlew build
```
```bash
 > docker-compose up --build
```

## BUILD AND UP Docker Compose 
```bash
 > docker-compose up --build   
```
```bash
 > docker-compose down <- down docker compose     `
```
## ROUTES

### POST /signup
```
curl -s -X POST \
  http://localhost:8080/signup \
  -H 'Content-Type: application/json' \
  -d '{"email":"test@test.com", "username":"test",  "password": "1234"}'
```

### POST /login
```
curl -s -X POST \
  http://localhost:8080/login \
  -H 'Content-Type: application/json' \
  -d '{"username":"test", "password": "1234"}'
```

### GET /discover/movies
```
curl -s -X GET \
  http://localhost:8080/discover/movies
```

### GET /movies/{movieId}
```
curl -s -X GET \
  http://localhost:8080/movies/{movieId}
```

### GET /movies/{movieId}/cast
```
curl -s -X GET \
  http://localhost:8080/movies/{movieId}/cast
```

### GET /cast/{castId}
```
curl -s -X GET \
  http://localhost:8080/cast/{castId}
```

### POST /favorites/{movieId}
```
curl -s -X POST \
  http://localhost:8080/favorites/{movieId} \
  -H 'Content-Type: application/json' 
```

### GET /favorites
```
curl -s -X GET \
  http://localhost:8080/favorites
```
To test the api you can use this link [http://localhost:8080](http://localhost:8080) or the POSTMAN collection including in this repo.

# DEMO
The API is currently deployed at [vultr.com](vultr.com) you can try it at this link [http://108.61.119.125:8080](http://108.61.119.125:8080)

## Acknowledgment
In advance I appreciate the interest in my profile, I hope to meet the expectations of the position.

## License
[MIT](https://choosealicense.com/licenses/mit/)

## Autor

* **Daniel Rodriguez** - [Deaniell61](https://github.com/Deaniell61)
  