

Please make sure the following tools are installed on your machine:

* **Docker 28.5+**.
* **Java 17+**.

#### Prerequisites

This guide assumes you have experience with:
- Building and debugging Java applications
- Using the Command Line (Linux or windows). Examples are shown using RHEL commands
- Basic usage of Docker containers


#### Sonarqube

We'll work using embedded database in an installation with evaluation purposes. 
Execute next commands:

* Run Docker

```
sudo systemctl start docker
```

* Download Sonarqube image
```
docker pull sonarqube
```

* Start the image
```
docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest
```

* Reach out localhost:9000 on your navigator and set the new admin password.
* However, you can make the installation using database or other elements following the instructions at [Sonar Docs](https://docs.sonarsource.com/sonarqube-community-build/server-installation/installing-the-database/#database-requirements)