

References:

- [Jenkins Pipelines](https://www.jenkins.io/doc/book/pipeline/)
- [Sonarqube Docs - Branch and Pull Request Analysis](https://docs.sonarsource.com/sonarqube-server/analyzing-source-code/branch-analysis/introduction)



### How to configure coverage percentage in Jenkins and SonarQube

| Approach                      | Enforced in | Controls                    | Best for                      | Notes                |
| ----------------------------- | ----------- | --------------------------- | ----------------------------- | -------------------- |
| **1. Jenkins test stage**     | Jenkins     | Test pass %                 | Early validation              | Simple, fast         |
| **2. SonarQube Quality Gate** | SonarQube   | Coverage, code issues       | Governance, CI/CD integration | Requires Sonar setup |
| **3. Hybrid**                 | Both        | Test rate + Quality metrics | Enterprise setups             | Best of both worlds  |
| **4. Gradle JaCoCo**          | Build tool  | Coverage                    | Local enforcement             | Tool-independent     |


### 1.-Validation inside Jenkins (test results analysis)

🔸 **Mechanism**

Use Jenkins’ native or plugin-based test result analysis to check JUnit results and enforce a minimum pass rate before moving to SonarQube or deployment.

🔸 **Tools/Plugins**

	- JUnit plugin (junit step)
	- Quality Gates plugin
	- Conditional pipeline logic (using Groovy)


✅ **Pros**

- Immediate feedback (no need to wait for SonarQube).
- Fully local — works even without Sonar.

❌ **Cons**

- Limited to raw test results (coverage and complexity come only from Sonar).

<details>
  <summary>Example</summary>

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
</details>


## 2.- Validation inside SonarQube (quality gate enforcement)

🔸 **Mechanism**

Use SonarQube’s Quality Gates to define rules such as:
- Minimum test coverage (coverage >= 80%)
- Maximum duplicated code
- No critical issues, etc.

Then, in Jenkins, wait for the quality gate result and fail the pipeline if it doesn’t pass.

🔸 **Required plugins**

	- SonarQube Scanner for Jenkins
	- “Wait for Quality Gate” step


✅ **Pros**

- Centralized management via SonarQube’s UI (no Groovy logic).
- Enforces coverage and many other quality metrics.
- Integrates well for enterprise setups.

❌ **Cons**

- Requires SonarQube to have executed and reported results first.
- Slightly more delay in feedback.

<details>
  <summary>Example</summary>

```
pipeline {
  agent any

  stages {
    stage('Build and Test') {
      steps {
        sh './mvnw clean verify'
      }
    }

    stage('SonarQube Analysis') {
      steps {
        withSonarQubeEnv('SonarQubeServer') {
          sh './mvnw sonar:sonar'
        }
      }
    }

    stage('Quality Gate') {
      steps {
        timeout(time: 5, unit: 'MINUTES') {
          waitForQualityGate abortPipeline: true
        }
      }
    }

    stage('Deploy') {
      steps {
        echo 'Deploying...'
      }
    }
  }
}

```
</details>


## 3.- Hybrid approach (Jenkins + SonarQube)

🔸 **Mechanism**

You can combine both:
1. Check test pass rate locally (fast fail).
2. Run SonarQube analysis and enforce coverage and code quality via quality gate.



✅ **Pros**

- Early fail (fast feedback from test stage).
- Strong governance (Sonar rules for code coverage and quality gate).

<details>
  <summary>Example</summary>

```
stage('Check Tests') {
  steps {
    script {
      def testResult = junit '**/target/surefire-reports/*.xml'
      def passRate = (testResult.passCount * 100) / testResult.totalCount
      if (passRate < 90) {
        error "Test pass rate below 90%!"
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

stage('Quality Gate') {
  steps {
    timeout(time: 5, unit: 'MINUTES') {
      waitForQualityGate abortPipeline: true
    }
  }
}
```
</details>


## 4.- Optional — enforce via Maven profiles (lightweight)

If you use Gradle and JaCoCo, you can add coverage thresholds directly in your build.gradle:


<details>
  <summary>Example</summary>

```

test {
    testLogging {
        events "passed", "skipped", "failed"
    }
    jvmArgs "-Xshare:off"
    useJUnitPlatform()
    finalizedBy jacocoTestReport
}

jacocoTestReport {
    dependsOn test
    reports {
        xml.required = true
        csv.required = false
        html.outputLocation = layout.buildDirectory.dir('jacocoHtml')
    }
}

// JaCoCo configuration: https://docs.gradle.org/current/userguide/jacoco_plugin.html
jacocoTestCoverageVerification {
    violationRules {
        rule {
            limit {
                counter = 'LINE'
                value = 'COVEREDRATIO'
                minimum = 0.7
            }
        }
    }
}

sonar {
    properties {
        //property "sonar.jacoco.reportPaths", jacoco.reportsDirectory
    }


```
</details>

If coverage is below 70% (0.7), Maven will fail the build before Jenkins continues.
