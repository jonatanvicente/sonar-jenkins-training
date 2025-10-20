

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

