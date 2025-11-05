package sonarjenkinstraining;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VerifyTitle {

    @Test
    void verifyTitle() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://elpais.com/");
        String title = driver.getTitle();
        assertEquals("EL PAÍS: el periódico global", title);
        driver.quit();
    }
}

