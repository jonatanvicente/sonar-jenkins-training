

### Test Sonarqube Platform

- Install Sonarqube using Docker Official Image
- Starts Sonarqube image using
```
docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest
```
- Reach out localhost:9000
- Set the admin login


### Modifying Sonarqube config

- Modify the port at sonar.properties and set 9090 port (located at docker/sonar/conf/sonar.properties)
- Starts Sonarqube using Docker Compose
```
docker compose -f docker/docker-compose.yml up --remove-orphans sonarqube -d
```



