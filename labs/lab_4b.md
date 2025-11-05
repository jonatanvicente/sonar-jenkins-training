

## Integrating Sonarqube into Jenkins

⚠️**Warning:** Many of these steps are not recommended for production environments. You should modify them to include additional security layers before deploying.

Follow next steps:

1. **Jenkins: Install required plugins**
- In Jenkins, install the **following plugins**:
	- SonarQube Scanner Plugin
	- Pipeline: REST API
	- Authentication Tokens API

2. **Sonarqube: Create a token**
- Go to Account > My Account > Security
- **Generate a new token of type User with no expiration**
- Copy the generated token

3. **Jenkins: Create credentials**
- Navigate to Manage Jenkins > Security > Credentials
- Select the (global) domain.
- **Click Add Credentials** and set:
	- **Kind:** Secret text
	- **Secret:** Paste the SonarQube token value
	- **ID:** Provide a stable ID (e.g., sonar-token-id) — recommended for pipeline references
	- **Description:** SonarQube token for CI (optional)
	- **Scope:** Global (so all jobs/agents can access it)
- Click OK or Save.


4. **Jenkins: Add Credentials to Sonarqube config**
- Go to Manage Jenkins > System.
- Scroll to SonarQube Servers and configure:
	- **Name:** (choose any descriptive name)
	- **Server URL:** Usually http://localhost:9000 or http://sonarqube:9000 if using a Docker network
	- **Server authentication token:** Select the credential created in step 3


5. **Sonarqube: Create your project**
- Create a **New Project** of type Local Project.
- Fill in the project name and main branch name, then select the default instance.
- At the Analysis Method screen:
	- Choose **Locally**.
	- Select **Use existing token** and enter the token created in step 2.
	- Finally, select **Gradle** and review the instructions to modify your project (by adding the sonarqube task).


6. **Gradle: Add the SonarQube task to your build.gradle**
- Ensure your build.gradle file includes::
```
plugins {
    id "org.sonarqube" version "6.3.1.5724"
}

sonarqube {
    properties {
        property "sonar.projectKey", "sonar-jenkins-training"
        property "sonar.projectName", "sonar-jenkins-training"
        property "sonar.host.url", "http://sonarqube:9000"
        property "sonar.token", "xx"
    }
```

7. **Jenkins: Add the SonarQube task to your pipeline**
- In your **Job Configuration**:
	- Under **Environment**, enable Use secret text(s) or file(s) and set:
		- **Variable:** SONAR_TOKEN
		- **Credentials:** SonarQube token for CI (created in step 3)
		- Under **Build Steps**, add a new step called Invoke Gradle Script, and configure:
		- Use **Gradle Wrapper**: ✓
		- Make gradlew executable: ✓
		- Wrapper location: ${WORKSPACE}
		- Tasks: 
```
sonarqube -Dsonar.login=$SONAR_TOKEN -Dsonar.host.url=http://sonarqube:9000
```

8. **Test your pipeline**
- Commit a new change to your tmp repository.
- Check the Jenkins console output for the build results.
- Then navigate to SonarQube > Your Project — and ... **congratulations 🎉 your pipeline is working!**

