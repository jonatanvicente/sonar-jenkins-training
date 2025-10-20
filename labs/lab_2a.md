

## SonarLint

- Install the SonarLint plugin in your IDE


## Analyzing Sonarqube Platform

- Please, visit [Sonarqube Next](https://next.sonarqube.com/sonarqube/projects). 
Locate the **Kotlin project** — we will be working with it.
This project is an open-source and globally recognized example.


##### Project Information

- Navigate to the **Project Information** tab and download the **Regulatory Report** from the master branch
**Questions:** 
(If necessary, you may refer to the [Sonarqube Metrics Definition](https://docs.sonarsource.com/sonarqube-server/user-guide/code-metrics/metrics-definition)
	- Analyze the **Open Issues** of the project. Do they fall under category **A, B, C, D**, or **E**?
	- What do these letters mean in the context of:
		a) **Security**?
		b) **Reliability**?
		c) **Maintainability**?

##### Overview Tab
**Questions:** 
- Why are there differences between **New Code** and **Overall Code**?

##### Issues Tab
**Questions:** 
- What does the **Issues** section refer to?
- What does the **Severity** field mean?
- Select one issue with the highest available severity. Identify where the issue occurs, why it appears, and describe possible ways to fix it.
How does SonarQube help in resolving it?
- In the **Status / False Positive** section — what does the expression “False Positive” mean?

> Example of a False Positive
>    * The system displays the following warning:
>        ⚠️ "Possible NullPointerException on line 42"
>      However, the variable is already checked for null before this line.
>        👉 In this case, the warning is a false positive.


##### Security Hotspots Tab
- Explore the available options (To **Review**, **Acknowledged**, **Fixed**, or **Safe**) until you find a security-related issue.
- Review the **What’s the risk?** section and explain how the issue was resolved.

##### Dependency Risks Tab
- Clear all filters
**Questions:** 
- Select **Risk Type / Prohibited Licensed**. How many issues fall under this criterion, and why?

##### Inventory Tab
**Questions:** 
- Browse through the project directory. Which version of the **SonarQube plugin** is being used, and where can you find it?

##### Security Reports Tab
**Questions:** 
- From the **Security Reports Overview**, download the **Security Report**.
- What is the **security rating**, and what does it imply?

##### Measures Tab
**Questions:** 
- From the **Project Overview** section, indicate the Coverage percentage and the Technical Debt. What do they represent?
- Under **Maintainability**, specify the effort required to achieve rating A.
- What are the **Cyclomatic Complexity** and **Cognitive Complexity** indices?
- How many **False Positives** are reported?