

## Adding git config to Jenkins

We'll work with a local installation of git. 

**Warning**: this configuration is only for testing purposes. **Using local repositories is not recommended in production environments.**

Follow this steps:

- Verify that the git plugin is installed in Jenkins. Go to Manage Jenkins → Plugins → Installed (or Available) Plugins and search for Git Plugin.
- Recommended: configure the git path. Go to Manage Jenkins → Git Installations → Path to Git executable. This should contain either the command git or the full path to the Git executable on your machine.
- Verify git is installed inside the container:

```
docker container ls
docker exec -it [containerId] bash
git -v # you should see git version
```

**Your first Jenkins Project**

1.- Go to **New Item** > Enter an **Item Name** > Select **'Freestyle Project'**
2.- In your new project, go to **Configure** and set:
	- **Git**: Repository URL: /opt/sonar-jenkins-training/.git
	- **Branch Specifier:** \*/main
3.- On the main project page, click the **Play button** to schedule a build **immediately**.
4.- You can **view all the builds executions**
5.- Navigate to one of the successful executions and **check the Console Output**.

**Questions:** 
1.- What type of information is shown in the Console Output, and how is it useful?	
2.- Browse to the Status menu in the build. What type of information is contained there, and how can it be used in connection with Git information?



