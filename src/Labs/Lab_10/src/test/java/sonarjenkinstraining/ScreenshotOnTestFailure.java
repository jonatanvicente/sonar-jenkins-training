package sonarjenkinstraining;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

public class ScreenshotOnTestFailure {
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown(TestInfo testInfo) throws Exception {
        try {
            driver.quit();
        } catch (Exception e) {}
    }

    @Test
    void takeScreenshotOnFailure() {
        try {
            driver.get("https://elpais.com/");
            assertEquals("Wrong Title", driver.getTitle()); // Intentionally wrong
        } catch (AssertionError e) {
            takeScreenshot("failure_test");
            throw e;
        }
    }

    void takeScreenshot(String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path dest = Paths.get("src/test/resources", name + "_"+ new Date().getTime()+".png");
            Files.move(src.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
