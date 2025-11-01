

### Exercise 1: Web Login Test (Basic Test Case)

**Objective**: Automate a login flow on a local HTML page.

Steps:
1. Prepare Local HTML
2. Create a simple HTML file login.html:

<details>
  <summary>login.html</summary>

```
<html>
  <body>
    <h2>Login Page</h2>
    <form id="loginForm">
      <input type="text" id="username" placeholder="Username">
      <input type="password" id="password" placeholder="Password">
      <button type="button" id="loginBtn">Login</button>
    </form>
    <p id="welcomeMsg" style="display:none;">Welcome!</p>
    <script>
      document.getElementById('loginBtn').onclick = function() {
        if(document.getElementById('username').value == 'user' && document.getElementById('password').value == 'pass') {
          document.getElementById('welcomeMsg').style.display = 'block';
        }
      };
    </script>
  </body>
</html>

```
</details>

- Save it locally (e.g., C:\KatalonExercises\login.html).

2. Create Katalon Project
	- File → New → Project → Name: LocalWebLoginTest.
3. Create Test Case
	- File → New → Test Case → Name: TC_LocalLogin.
	- Open in Manual view.
4. Record / Add Steps
	- Record Web → enter local file URL: file:///C:/KatalonExercises/login.html.
	- Perform:
		- Enter username user → input field with id username.
		- Enter password pass → input field with id password.
		- Click Login button (loginBtn).

5. Verify Result
	- Add step: Verify Element Visible → element welcomeMsg.

6. Run Test
	- Toolbar → Run → Chrome/Firefox
	- Test should pass showing “Welcome!”.


### Exercise 2: Local API Simulation (JSON Request/Response)

**Objective**: Test a simple local JSON file as a “mock API” without external calls.

1. Create a Local JSON File

- user.json:


```
{
  "username": "user",
  "password": "pass",
  "role": "admin"
}

```

	- Save in your project folder.

2. Create Test Case
	- File → New → Test Case → Name: TC_LocalJSONTest.
	- Open Script view, add Groovy code:


```
import groovy.json.JsonSlurper

def jsonFile = new File('C:/KatalonExercises/user.json')
def data = new JsonSlurper().parse(jsonFile)
assert data.username == 'user'
assert data.role == 'admin'
println "Local JSON test passed!"

```

3. Run Test
	- Toolbar → Run → Console
	- Verify it prints: "Local JSON test passed!".


### Exercise 3: Data-Driven Local Test (Excel)

**Objective**: Test multiple username/password combinations locally.

1. Create Excel File
	- Name: LoginData.xlsx
	- Columns: username, password
	- Rows:

```
user, pass
test, 123
admin, admin

```

	- Save in project folder.

2. Add Test Data
	 - File → New → Test Data → Name: LocalLoginData
	 - Type: Excel → select file → Check “Has column names”

3. Create Test Case
	- File → New → Test Case → Name: TC_LocalDataDrivenLogin
	- Manual steps:
		1. Open browser → local file URL login.html
		2. Input username → bind to LocalLoginData.username
		3. Input password → bind to LocalLoginData.password
		4. Click Login
		5. Verify login success: check if “Welcome!” is displayed only for correct username/password.

4. Bind Test Data
	- Test Case → Test Data Binding → select LocalLoginData → All rows → OK
5. Run Test
	- Katalon executes each row in Excel locally.


