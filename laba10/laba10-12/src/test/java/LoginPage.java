import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private final WebDriver driver;
    private final By loginButtonLocator = By.xpath("//*[@id=\"__next\"]/header/div[1]/section/div[3]/ul/li[1]/button/span");
    private final By loginMethodLocator = By.xpath("//*[@id=\":rj:\"]/form/button[4]/span");
    private final By usernameLocator = By.xpath("//*[@id=\":rj:\"]/form/div[3]/input");
    private final By passwordLocator = By.xpath("//*[@id=\":rj:\"]/form/div[5]/input");
    private final By confirmButtonLocator = By.xpath("//*[@id=\":rj:\"]/form/button");
    private static final String HOME_PAGE_URL = "https://ru.investing.com/";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHomePage() {
        driver.get(HOME_PAGE_URL);
    }

    public void openLoginForm() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement loginMethod = driver.findElement(loginMethodLocator);
        loginMethod.click();
    }

    public void login(String username, String password) {
        WebElement inputUsername = driver.findElement(usernameLocator);
        WebElement inputPassword = driver.findElement(passwordLocator);
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement confirmButton = driver.findElement(confirmButtonLocator);
        confirmButton.click();
    }
}
