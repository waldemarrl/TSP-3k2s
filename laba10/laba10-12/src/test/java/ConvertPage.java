import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ConvertPage {
    private final WebDriver driver;
    private final By toolsBarLocator = By.xpath("//*[@id=\"bottom-nav-row\"]/div[1]/nav/ul/li[9]/div[1]/a/span/span");
    private final By convertLocator = By.xpath("//*[@id=\"bottom-nav-row\"]/div[1]/nav/ul/li[9]/div[2]/div/div[2]/div/ul/li[3]/a");
    private final By inputAmountLocator = By.xpath("//*[@id=\"amount1\"]");

    private static final String HOME_PAGE_URL = "https://ru.investing.com/";

    public ConvertPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToConvertPage() {
        driver.get(HOME_PAGE_URL);
    }
    public void convertUSD(String amount) {
        WebElement hoverElement = driver.findElement(toolsBarLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        WebElement lastMatchButton1 = driver.findElement(convertLocator);
        lastMatchButton1.click();
        WebElement insertData = driver.findElement(inputAmountLocator);
        insertData.sendKeys(amount);
    }
}
