
## 🧩 Open a Web Page and Verify Its Title

**Goal:** Get familiar with basic navigation and assertions

**Difficulty:** 🟢 Easy

**Steps:**

1. Launch a browser (e.g., Chrome).
2. Open `https://example.com`.
3. Verify that the page title is `"Example Domain"`.
4. Close the browser.

**Expected skills:**

* `WebDriver` initialization
* `getTitle()`
* `assertEquals()`

---

## 🧩 Locate Elements and Interact with Them

**Goal:** Practice finding elements using different locators

**Difficulty:** 🟢 Easy

**Scenario:** Use the [Google homepage](https://www.google.com).

**Steps:**

1. Open Google.
2. Locate the search box (`name="q"`) and type “Selenium WebDriver”.
3. Submit the search.
4. Wait until results appear (use `WebDriverWait`).
5. Verify that the title contains “Selenium WebDriver”.

**Expected skills:**

* `By.name`, `By.id`, `By.cssSelector`
* `sendKeys()`, `submit()`
* Explicit waits

---

## 🧩 Automate a Simple Form

**Goal:** Understand form automation and assertions

**Difficulty:** 🟡 Moderate

**Scenario:** Use [https://www.selenium.dev/selenium/web/web-form.html](https://www.selenium.dev/selenium/web/web-form.html).

**Steps:**

1. Open the page.
2. Fill in the text input and password fields.
3. Select a checkbox and a radio button.
4. Submit the form.
5. Assert that the result text equals “Received!”.

**Expected skills:**

* `findElement()`
* Interacting with forms (`click`, `sendKeys`, `submit`)
* Assertions

---

## 🧩 Handle Dynamic Content (Optional)

**Goal:** Use waits with dynamically loaded elements

**Difficulty:** 🟡 Moderate

**Scenario:** Use [https://the-internet.herokuapp.com/dynamic_loading/2](https://the-internet.herokuapp.com/dynamic_loading/2).

**Steps:**

1. Click “Start”.
2. Wait until “Hello World!” is visible.
3. Verify that the message is correct.

**Expected skills:**

* `WebDriverWait`
* `ExpectedConditions.visibilityOfElementLocated()`

---

## 🧩 Screenshot on Test Failure

**Goal:** Combine Selenium actions with test framework capabilities

**Difficulty:** 🟡 Moderate

**Steps:**

1. Automate a failing test (e.g., check wrong title).
2. Capture a screenshot when the test fails.
3. Save the image with the test name.

**Expected skills:**

* `TakesScreenshot`
* Integration with JUnit/TestNG hooks (`@After`, `@AfterMethod`)

---

## 🧩 Exercise 6: Handle a JavaScript Alert

1. Open the page: https://the-internet.herokuapp.com/javascript_alerts
2. Click the button labeled “Click for JS Alert”.
3. Switch to the alert, accept it, and verify that the result text says “You successfully clicked an alert”.

---

## 🧩 Exercise 7: Interact with an IFrame

1. Open the page: https://the-internet.herokuapp.com/iframe
2. Switch to the iframe containing the TinyMCE editor.
3. Clear the existing text and type: “Hello Selenium!”
4. Switch back to the main page and verify that the heading above the editor contains “An iFrame containing the TinyMCE WYSIWYG Editor”.

