

## Jenkins Jobs Scenarios

#### 1. Single Project, Single Branch

**Solution**: Pipeline Job
**Reasoning**: Simple scenario, single branch. A Pipeline job with a Jenkinsfile covers build, test, and deploy steps.

#### 2. Multiple Feature Branches with PR Validation

**Solution**: Multibranch Pipeline with PR integration
**Reasoning**: Multibranch Pipelines automatically discover branches. When combined with GitHub/GitLab PR triggers, each PR gets its own build. Deleted branches remove jobs automatically.

#### 3. Manual Build Trigger with Optional Tests

**Solution**: Parameterized Pipeline Job
**Reasoning**: Use a boolean parameter like RUN_LONG_TESTS. The build can be triggered manually, and the pipeline script can skip or include the tests based on the parameter.

#### 4. Testing Multiple Environments in Parallel

**Solution**: Pipeline Job with Parallel Stages
**Reasoning**: Jenkins pipelines allow parallel execution of stages. You can define staging, QA, and prod-like test stages in parallel to save time.

#### 5. Multi-Repository Integration

**Solution**: Pipeline Job with Multiple SCM Checkouts
**Reasoning**: Use multiple checkout steps in the pipeline for each repository. You can define dependencies and fail the build if any repo fails.

#### 6. Nightly Builds with Notification

**Solution**: Scheduled Pipeline or Freestyle Job with Build Triggers + Post-build Notifications
**Reasoning**: Use a cron schedule for nightly builds and configure email/Slack notifications in post-build actions or pipeline steps.

#### 7. Artifact Promotion Pipeline

**Solution**: Pipeline Job with Post-Build Actions and Downstream Job Trigger
**Reasoning**: The pipeline builds the project, archives artifacts, runs automated tests, and triggers a downstream deployment job only if tests succeed, ensuring safe promotion.