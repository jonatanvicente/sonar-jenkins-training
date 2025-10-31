

## Common WorkflowScenarios


| **Scenario**                       | **Jenkins Type**     | **Git Usage**              | **SonarQube Usage**   | **Typical Org**          |
| ---------------------------------- | -------------------- | -------------------------- | --------------------- | ------------------------ |
| **1. Basic CI**                    | Single pipeline      | Main branch                | Simple analysis       | Small team               |
| **2. PR Validation**               | Declarative pipeline | Feature branches           | PR decoration         | Mid-size team            |
| **3. Multi-Branch**                | Multibranch pipeline | Automated branch discovery | Branch analysis       | Active development teams |
| **4. CI + CD Quality Gate**        | Full pipeline        | Main & staging branches    | Blocking gate         | Mature CI/CD             |
| **5. Microservices (Shared Libs)** | Library-based        | Many repos                 | Consistent analysis   | Large enterprise         |
| **6. Parallel Module Analysis**    | Parallel pipeline    | Monorepo                   | Multiple project keys | Complex systems          |


### Scenarios

**_1. Basic CI Pipeline (Main Branch Only)_**

- **Purpose:** Continuous Integration on a single main branch.
- **Stack:** Jenkins + Git (any provider) + SonarQube (local or cloud).
- **See Jenkinsfile-samples/Jenkinsfile-1**

**Flow**

1. Developer commits/pushes to the main branch.
2. Git webhook triggers Jenkins.
3. Jenkins:
    - Pulls latest code.
    - Builds and runs tests.
    - Runs **SonarQube analysis**.
    - Waits for **Quality Gate**.
    - Publishes report or artifact.

**Typical use**

- Small teams or monolithic repositories.
- First CI/CD iteration.
- Ensures minimum code quality before merging.

---

**_2. Feature Branch / Pull Request Validation Pipeline_**

- **Purpose**: Validate code quality **before merging** into main.
- **See Jenkinsfile-samples/Jenkinsfile-2**

**Flow**

1. Developer creates feature branch → opens Pull Request (PR).
2. Git provider webhook triggers Jenkins.
3. Jenkins runs:
    - Build + unit tests.
    - SonarQube scan with **PR decoration** (comments in PR).
    - Reports results to SonarQube and optionally GitHub/GitLab.

**Typical use**

- Teams using **GitFlow or feature-branch** models.
- Enforce code quality before merging PRs.
- Faster feedback for developers.

---

**_3. Multi-Branch Pipeline (Automated per Branch)_**

**Purpose**: Automatically create pipelines for each branch.

**Flow**

- Jenkins **multibranch pipeline** scans a Git repository.
- Each branch automatically gets a pipeline.
- SonarQube analysis runs per branch (SonarQube Developer Edition or higher required).

**Benefits**

- Zero manual config per branch.
- Isolated analysis per branch.
- Seamless integration with Git-based workflows.

**Typical use**

- Repositories with many feature branches.
- Organizations wanting fully automated CI per branch.

---


**_4. Pipeline with Staged Quality Gates (CI + CD)_**

**Purpose**: Integrate code analysis into deployment pipelines.
- **See Jenkinsfile-samples/Jenkinsfile-4**

**Flow**

1. Jenkins builds, tests, and analyzes code.
2. If quality gate passes → package artifact.
3. Deploy automatically to staging.
4. Optionally run integration tests before production.


**Typical use**

- Continuous Delivery setups.
- Projects enforcing **quality gates as blockers** before deployment.

---

**_5. Microservices Architecture (Shared Libraries)_**

**Purpose**: Standardize pipelines across multiple repositories (microservices).
- **See Jenkinsfile-samples/Jenkinsfile-5**

**Flow**

- Each repo contains a minimal Jenkinsfile.
- Shared Jenkins library defines standardized stages:
    - _build()_
    - _test()_
    - _sonarAnalyze()_
    - _deploy()_

**Typical use**

- Medium or large organizations.
- 10+ microservices using the same CI/CD rules.
- Governance and consistency.

---

**_6. Parallel Branch/Module Analysis_**

**Purpose**: Large monorepos or modular systems.
- **See Jenkinsfile-samples/Jenkinsfile-6**

**Flow**

- Jenkins runs multiple SonarQube analyses in parallel (per module or component).
- Aggregates results in SonarQube dashboard.

**Typical use**

Repos containing frontend + backend or multiple services.