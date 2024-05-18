package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverManager.createDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
