

## Executing a Multibranch Project

- Install Blue Ocean plugin into Jenkins
- Switch to Blue Ocean View at localhost:8080/blue (you can switch again to the classic view at any moment)
- Create New Pipeline from Git. Set the properties:
    - Repository: /opt/sonar-jenkins-training
    - Credentials: not needed

OJO CREAR NUEVAS RAMAS PARA MULTIBRANCH


### Blue Ocean View
- Navigate to the Branches TAb  
- Click on branches and see the status of stages

Edicion de jenkins file

Ahora en ocean > pipeline > Branches > Edit (de cada rama) podemos editar el jenkinsfile visualmente:
  - Vemos environment
  - Editamos cada paso, vemos atributos availbable para pcada step


Añadimos jenkinsfile y dos ramas se testean >> mulitibranch
  Durante ejecución del pipe, en ocean, vemos como avanza


  Podems ver la consola de cada ejeución en vista normal a ldcha cmd

- Vision blue : vemos en cada ejecución > cada stage > trazas segmentadas por stage


Vista status
Al clickar en una rama vemos status y podemos acceder a logs

 en blue puedes filtrar por ramas en titulo y ver ejecución de cada una

 también ha saltado todas excepto la última end en main

### Classic View
- Navigate to the Classic View clicking to the button top right
- Start the new pipeline
- See the logs at 

    - vision normal no ocean: cada branch > abajo a izda numero de builds > click > console oputput


## Jenkinsfile

OJO en jenkins file debe estar ' withSonarQubeEnv('Sonarqube Training') {//Match con Jenkins config server global sonqrugbe'

 when { expression { !(env.BRANCH_NAME ==~ /feature\/.*/) } } // skip tests for `feature/*`


 Hacemo solo cambio en develop evitando main package


## Sonarqube

 Creamos nuevo proyecto Sonarqube
 Ahora desde Ocean hacemos click solo para develop