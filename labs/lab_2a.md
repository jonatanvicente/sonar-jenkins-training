

## SonarLint

- Install SonarLint plugin in your IDE


## Analyze Sonarqube Platform

- Please, visit [Sonarqube Next](https://next.sonarqube.com/sonarqube/projects). 
Seek out project Kotlin, we will work over it. This project is a opensource globally accepted.


##### Project Information

- Navegue hacia la pestaña 'Project Information' y descargue el Regulatory Report de rama master.
**Questions:** 
(Si necesita, puede consultar [Sonarqube Metrics Definition](https://docs.sonarsource.com/sonarqube-server/user-guide/code-metrics/metrics-definition)
	- Analice las Open Issues del proyecto. ¿Son de categoría A, B, C, D o E?
	- ¿Qué significado tienen estas letras en:
		a) Security?
		b) Reliability?
		c) Maintainability?

##### Overview Tab
**Questions:** 
	- Why existing differences between New Code and Overall Code?

##### Issues Tab
**Questions:** 
- A qué se refiere el epígrafe **Issues**?
- Qué quiere decir el apartado **Severity**?
- Seleccione una Issue de la mayor severidad disponible. Localice dónde está la issue, porqué aparece y explique las formas de arreglarlo. Cómo sirve de ayuda Sonarqube para hacerlo?
- Apartado **Status / False positive**. A qué se refiere la expresión 'Falso Positivo'?

	```Ejemplo de un Falso Positivo
		* El sistema te muestra este aviso:
			⚠️ "Posible NullPointerException en la línea 42"
			Sin embargo, antes de esa línea ya se valida que la variable no es null.
			👉 En este caso, el aviso es un falso positivo.
	```
##### Security Hotspots Tab
- Analice las opciones entre To review, Acknowledged, Fixed o Safe hasta encontrar una issue de seguridad.
- Verifique la pestaña What's the risk? y como se solucionó la issue de seguridad

##### Dependency Risks Tab
- Clear all filters
**Questions:** 
- Seleccione **Risk Type / Prohibited Licensed**. Cuántas issues hay bajo este criterio, y porqué?

##### Inventory Tab
**Questions:** 
- Navegue por el directorio del proyecto. Qué versión del plugin sonarqube se está usando, y dónde puede verlo?

##### Security Reports Tab
**Questions:** 
- Desde el Security reports overview, descargue el **Security report**
- ¿Cuál es el rating de seguridad, y qué implica eso?

##### Measures Tab
**Questions:** 
- Desde el apartado **Project Overview**, indique el % de Coverage y la Technical Debt. ¿Qué indican?
- En **Maintainability**, indique el esfuerzo necesario para alcanzar el rating A.
- ¿Cuál es el índice de Cyclomatic and Cognitive Complexity?
- ¿Cuántos Falsos Positivos hay?