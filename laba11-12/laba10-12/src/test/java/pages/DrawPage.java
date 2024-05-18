package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DrawPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By selectToolLineLocator = By.xpath("//div[@id='drawing-toolbar']//span[2]/div/div/div/button");
    private final By canvasLocator = By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div/div[2]/div[1]/div[2]/div/canvas[2]");

    private static final String DRAW_PAGE_URL = "https://ru.tradingview.com/chart/NS9yIzTC/?symbol=MOEX%3AGAZP";

    public DrawPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToDrawPage() {
        driver.get(DRAW_PAGE_URL);
    }

    public void drawLine() {
        WebElement lineButton = wait.until(ExpectedConditions.elementToBeClickable(selectToolLineLocator));
        lineButton.click();

        WebElement canvas = wait.until(ExpectedConditions.visibilityOfElementLocated(canvasLocator));

        Actions actions = new Actions(driver);

        actions.moveToElement(canvas, 50, 50)
                .click()
                .moveByOffset(200, 0)
                .click()
                .build()
                .perform();
    }
}
