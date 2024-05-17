package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConvertPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By toolsBarLocator = By.xpath("//*[@id='bottom-nav-row']/div[1]/nav/ul/li[9]/div[1]/a/span/span");
    private final By convertLocator = By.xpath("//*[@id='bottom-nav-row']/div[1]/nav/ul/li[9]/div[2]/div/div[2]/div/ul/li[3]/a");
    private final By inputAmountLocator = By.id("amount1");

    private static final String HOME_PAGE_URL = "https://ru.investing.com/";

    public ConvertPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToConvertPage() {
        driver.get(HOME_PAGE_URL);
    }

    public void convertUSD(String amount) {
        WebElement hoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(toolsBarLocator));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();

        WebElement convertButton = wait.until(ExpectedConditions.elementToBeClickable(convertLocator));
        convertButton.click();

        WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(inputAmountLocator));
        amountInput.sendKeys(amount);
    }
}
