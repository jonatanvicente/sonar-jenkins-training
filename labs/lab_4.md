

## Adding git config to Jenkins

We'll work with a local installation of git. Execute next steps:

- Verify git plugin is installed in Jenkins. Check Manage Jenkins > Plugins > Installed (or Available) Plugins. Type 'git plugin'
- Recommended: configure git path. Verify options at Manage Jenkins > Git Installations > Path to git executable. This option must be contain the command or the full path to git executable located on your machine.
- Verify git is installed inside the container. To go into:

```
docker container ls
docker exec -it [containerId] bash
git -v # you must see git version
```




docker stop [container Id]
