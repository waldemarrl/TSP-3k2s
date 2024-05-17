package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By loginButtonLocator = By.xpath("//header//div[1]//section//li[1]/button/span");
    private final By loginMethodLocator = By.xpath("//form/button[4]/span");
    private final By usernameLocator = By.xpath("//form/div[3]/input");
    private final By passwordLocator = By.xpath("//form/div[5]/input");
    private final By confirmButtonLocator = By.xpath("//form/button");

    private static final String HOME_PAGE_URL = "https://ru.investing.com/";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToHomePage() {
        driver.get(HOME_PAGE_URL);
    }

    public void openLoginForm() {
        clickElement(loginButtonLocator);
        clickElement(loginMethodLocator);
    }

    public void login(String username, String password) {
        enterText(usernameLocator, username);
        enterText(passwordLocator, password);
        clickElement(confirmButtonLocator);
    }

    private void clickElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    private void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }
}
