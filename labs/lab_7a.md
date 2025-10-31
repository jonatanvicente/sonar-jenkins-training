


## Executing a Multibranch Project

1. Install the Blue Ocean plugin in Jenkins.
2. Switch to the Blue Ocean View at localhost:8080/blue (you can switch back to the classic view at any time).
3. Create New Pipeline from Git. Set the properties:
    - Repository: /opt/sonar-jenkins-training
    - Credentials: not required
4. Create a new branch (e.g. develop) in your repository. Jenkins will start executing the multibranch project automatically


### Blue Ocean View

- Navigate to the Branches Tab  
- Click on a branch to view the status of each stage
- You can monitor pipeline execution and track its progress
- You can switch back to the Classic View at any time.
- Status view: Click on a branch to access its status and logs.
- Branches can be filtered by name to track execution progress easily.


#### Editing the Jenkinsfile

- Go to Blue Ocean > Pipeline > Branch > Edit (for each branch). You can edit the Jenkinsfile using the graphical interface:
    - Each step displays its available attributes.

- Ensure that the Jenkinsfile includes the attribute withSonarQubeEnv('Sonarqube Training') to match the Jenkins global configuration.
- To skip a step for certain branches, you can use an expression like:

```
 when { expression { !(env.BRANCH_NAME ==~ /feature\/.*/) } } // skip tests for `feature/*`
```

- **Test it by skipping any step when the develop branch is executing**

### Classic View
- Switch to the Classic View by clicking the button at the top right.
- Start the pipeline
- View logs by clicking on the desired branch.
- On the left bottom, click the build number to see the console output.


### Sonarqube

- Create new Project
- Link it to the new pipeline execution (multiproject setup).

