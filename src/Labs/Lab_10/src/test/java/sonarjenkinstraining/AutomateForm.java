package sonarjenkinstraining;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AutomateForm {
    @Test
    void fillForm() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        driver.findElement(By.name("my-text")).sendKeys("Jon Doe");
        driver.findElement(By.name("my-password")).sendKeys("12345");
        driver.findElement(By.name("my-check")).click();
        driver.findElement(By.name("my-radio")).click();
        driver.findElement(By.cssSelector("button")).click();

        WebElement message = driver.findElement(By.id("message"));
        assertEquals("Received!", message.getText());
        driver.quit();
    }
}

