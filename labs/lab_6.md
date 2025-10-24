

## Jenkins Jobs Scenarios

For each scenario, decide which Jenkins job type or configuration is most appropriate.

### Scenarios

#### 1. Single Project, Single Branch

You have a small project with only a main branch. You want Jenkins to build, test, and deploy this project automatically whenever you push changes to main.

**Question: Which Jenkins job type should you use?**

<details>
  <summary>Solution and Reasoning</summary>

**Solution**: Pipeline Job
**Reasoning**: Simple scenario, single branch. A Pipeline job with a Jenkinsfile covers build, test, and deploy steps.

</details>

#### 2. Multiple Feature Branches with PR Validation

Your team uses Git Flow. You want every feature branch to be automatically built when a pull request is created. Each PR should have its own pipeline and be deleted automatically if the branch is removed.
**Question: Which Jenkins job type fits this scenario?**

#### 3. Manual Build Trigger with Optional Tests

Sometimes you need to trigger a build manually, but optionally skip long-running tests for faster execution.
**Question: How should you configure the job to support this?**

#### 4. Testing Multiple Environments in Parallel

Your project must be tested in staging, QA, and production-like environments. You want parallel execution to reduce total build time.
**Question: Which Jenkins job configuration supports this efficiently?**

#### 5. Multi-Repository Integration

Your project depends on three separate Git repositories. The job should pull from all three, build them in the correct order, and fail if any repository fails to build.
**Question: How should you configure the Jenkins job?**

#### 6. Nightly Builds with Notification

Your team wants Jenkins to run nightly builds for regression testing. Additionally, the job should notify the team via email or Slack if the build fails.
**Question: Which job configuration and triggers are required?**

#### 7. Artifact Promotion Pipeline

You need a job that builds a project, archives artifacts, and then triggers a deployment job only if the artifacts pass automated tests.
**Question: How should this be configured in Jenkins?**

See the solutions [here](lab_6_solutions.md)

