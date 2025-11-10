package sonarjenkinstraining;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;
public class JavascriptAlert {

    @Test
    void handleJSAlert() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Click the JS alert button
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        // Switch to alert and accept
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // Verify the result text
        String result = driver.findElement(By.id("result")).getText();
        assertEquals("You successfully clicked an alert", result);

        driver.quit();
    }
}
