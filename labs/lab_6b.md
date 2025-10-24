

## Triggers

- Configure a Freestyle Jenkins Job to automatically trigger a build whenever there are changes in the Git repository:
1. Configure the job so that it polls the SCM for changes every 5 minutes and triggers a build only if there are changes.
2. Save the job and verify that it triggers a build when you push changes to the repository.

<details>
  <summary>Tip</summary>

- Go to your Freestyle Job
- Click Configure
- Scroll down to the Build Triggers section.
- Check the box Poll SCM.
- In the schedule field that appears, enter your polling schedule using cron syntax (e.g., H/5 * * * * to check every 5 minutes).
- **Important**: SCM Polling does not run the build on a fixed schedule — it only checks the repository. Jenkins will trigger the build only if changes are detected.

</details>