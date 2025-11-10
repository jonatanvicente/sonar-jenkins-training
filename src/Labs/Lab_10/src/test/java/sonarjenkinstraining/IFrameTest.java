package sonarjenkinstraining;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class IFrameTest {

    @Test
    void interactWithIFrame() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");

        // Switch to iframe by id
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        // Clear existing text and type new text
        WebElement editor = driver.findElement(By.id("tinymce"));
        editor.clear();
        editor.sendKeys("Hello Selenium!");

        // Switch back to main content
        driver.switchTo().defaultContent();

        // Verify heading text
        String heading = driver.findElement(By.tagName("h3")).getText();
        assertEquals("An iFrame containing the TinyMCE WYSIWYG Editor", heading);

        driver.quit();
    }
}
