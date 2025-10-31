

References:

- [Jenkins Pipelines](https://www.jenkins.io/doc/book/pipeline/)
- [Sonarqube Docs - Branch and Pull Request Analysis](https://docs.sonarsource.com/sonarqube-server/analyzing-source-code/branch-analysis/introduction)




| Approach                      | Enforced in | Controls                    | Best for                      | Notes                |
| ----------------------------- | ----------- | --------------------------- | ----------------------------- | -------------------- |
| **1. Jenkins test stage**     | Jenkins     | Test pass %                 | Early validation              | Simple, fast         |
| **2. SonarQube Quality Gate** | SonarQube   | Coverage, code issues       | Governance, CI/CD integration | Requires Sonar setup |
| **3. Hybrid**                 | Both        | Test rate + Quality metrics | Enterprise setups             | Best of both worlds  |
| **4. Maven JaCoCo**           | Build tool  | Coverage                    | Local enforcement             | Tool-independent     |


Validation inside Jenkins (test results analysis)
🔸 Mechanism

Use Jenkins’ native or plugin-based test result analysis to check JUnit results and enforce a minimum pass rate before moving to SonarQube or deployment.

🔸 Tools/Plugins
	- JUnit plugin (junit step)
	- Quality Gates plugin
	- Conditional pipeline logic (using Groovy)

```
pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        sh './mvnw clean package'
      }
    }

    stage('Test') {
      steps {
        junit '**/target/surefire-reports/*.xml'
      }
    }

    stage('Check Test Results') {
      steps {
        script {
          def testResult = junit '**/target/surefire-reports/*.xml'
          def passRate = (testResult.passCount * 100) / testResult.totalCount
          echo "Test pass rate: ${passRate}%"
          if (passRate < 80) {
            error "Build failed: test pass rate below threshold (80%)"
          }
        }
      }
    }

    stage('SonarQube Analysis') {
      steps {
        withSonarQubeEnv('SonarQubeServer') {
          sh './mvnw sonar:sonar'
        }
      }
    }
  }
}

```
