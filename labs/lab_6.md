

## Jenkins Jobs Scenarios

For each scenario, decide which Jenkins job type or configuration is most appropriate.

### Scenarios

#### 1. Single Project, Single Branch

You have a small project with only a main branch. You want Jenkins to build, test, and deploy this project automatically whenever you push changes to main.

**Question: Which Jenkins job type should you use?**

<details>
  <summary>Solution and Reasoning</summary>

- **Solution**: Pipeline Job
- **Reasoning**: Simple scenario, single branch. A Pipeline job with a Jenkinsfile covers build, test, and deploy steps.

</details>

#### 2. Multiple Feature Branches with PR Validation

Your team uses Git Flow. You want every feature branch to be automatically built when a pull request is created. Each PR should have its own pipeline and be deleted automatically if the branch is removed.

**Question: Which Jenkins job type fits this scenario?**

<details>
  <summary>Solution and Reasoning</summary>

- **Solution**: Multibranch Pipeline with PR integration
- **Reasoning**: Multibranch Pipelines automatically discover branches. When combined with GitHub/GitLab PR triggers, each PR gets its own build. Deleted branches remove jobs automatically.

</details>

#### 3. Manual Build Trigger with Optional Tests

Sometimes you need to trigger a build manually, but optionally skip long-running tests for faster execution.

**Question: How should you configure the job to support this?**

<details>
  <summary>Solution and Reasoning</summary>

- **Solution**: Parameterized Pipeline Job
- **Reasoning**: Use a boolean parameter like RUN_LONG_TESTS. The build can be triggered manually, and the pipeline script can skip or include the tests based on the parameter.

</details>

#### 4. Testing Multiple Environments in Parallel

Your project must be tested in staging, QA, and production-like environments. You want parallel execution to reduce total build time.

**Question: Which Jenkins job configuration supports this efficiently?**

<details>
  <summary>Solution and Reasoning</summary>

- **Solution**: Pipeline Job with Parallel Stages
- **Reasoning**: Jenkins pipelines allow parallel execution of stages. You can define staging, QA, and prod-like test stages in parallel to save time.

</details>

#### 5. Multi-Repository Integration

Your project depends on three separate Git repositories. The job should pull from all three, build them in the correct order, and fail if any repository fails to build.

**Question: How should you configure the Jenkins job?**

<details>
  <summary>Solution and Reasoning</summary>

- **Solution**: Pipeline Job with Multiple SCM Checkouts
- **Reasoning**: Use multiple checkout steps in the pipeline for each repository. You can define dependencies and fail the build if any repo fails.

</details>

#### 6. Nightly Builds with Notification

Your team wants Jenkins to run nightly builds for regression testing. Additionally, the job should notify the team via email or Slack if the build fails.

**Question: Which job configuration and triggers are required?**

<details>
  <summary>Solution and Reasoning</summary>

- **Solution**: Scheduled Pipeline or Freestyle Job with Build Triggers + Post-build Notifications
- **Reasoning**: Use a cron schedule for nightly builds and configure email/Slack notifications in post-build actions or pipeline steps.

</details>

#### 7. Artifact Promotion Pipeline

You need a job that builds a project, archives artifacts, and then triggers a deployment job only if the artifacts pass automated tests.

**Question: How should this be configured in Jenkins?**

<details>
  <summary>Solution and Reasoning</summary>

- **Solution**: Pipeline Job with Post-Build Actions and Downstream Job Trigger
- **Reasoning**: The pipeline builds the project, archives artifacts, runs automated tests, and triggers a downstream deployment job only if tests succeed, ensuring safe promotion.

</details>

