

## Test Jenkins Platform

- Install Jenkins using Docker Official Image (jenkins/jenkins:lts-jdk21)
```
docker pull jenkins/jenkins:lts-jdk21 
```

- Start Jenkins image using
```
docker run -p 8080:8080 -p 50000:50000 --restart=on-failure jenkins/jenkins:lts-jdk21
```
- Reach out localhost:8080
- Use the admin login (that it's showed at console during the installation) and set new password.
- Install the most used plugins


## Reviewing the config

- Start Jenkins using Docker Compose
```
docker compose -f docker/docker-compose.yml up --remove-orphans jenkins -d
```
- You can see all the Jenkins Container config mapped to the docker/jenkins/conf directory.
	- **Warning**: This directory contains a .gitignore file that prevents uploading its contents except config.xml
