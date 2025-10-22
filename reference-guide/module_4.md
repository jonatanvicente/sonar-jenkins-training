

References:

- [Jenkins Integration](https://docs.sonarsource.com/sonarqube-server/analyzing-source-code/ci-integration/jenkins-integration)
- [DevOps Integration](https://docs.sonarsource.com/sonarqube-server/devops-platform-integration)
- [Jenkins System Administration](https://www.jenkins.io/doc/book/system-administration/)




### Project & Labs Utilities

- Please note the following details about the project Labs:
	- All Docker configurations (Jenkins and SonarQube containers) are located in the docker folder.

#### Jenkins container

- Jenkins configuration files are located in **docker/jenkins/conf**. Only the following files are uploaded to Git:
	- **.gitignore** - Prevents uploading all Jenkins config files
	- **config.xml** - Contains the main Jenkins configuration
	- **jenkins.model.JenkinsLocationConfiguration.xml** - contains Jenkins port configuration (please, be sure before changing its settins)
	- **init.groovy.d/allow-local-checkout.groovy** - configures Jenkins to allow using local repositories for Jobs. This behavior is not recommended in production environments.
- When you start the Jenkins container, the directory **/sonar-jenkins-training** is mapped inside the container at /opt/sonar-jenkins-training (as defined in docker-compose.yml). In any case (local or remote), **you should map a .git folder to allow Jenkins to function properly.**

## Docker Utilities

- List all running containers
```
docker container ls
```
- Access a container shell
```
docker exec -it [containerId] bash
```
- Stop a container
```
docker stop [containerId]
```
- Remove a container permanently
```
docker rm [containerId]
```
- A **Docker CheatSheet** is available in the project. You can also download it [here](https://docs.docker.com/get-started/docker_cheatsheet.pdf)