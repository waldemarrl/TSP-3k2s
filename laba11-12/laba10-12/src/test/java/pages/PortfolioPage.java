package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PortfolioPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By addPortfolioLocator = By.xpath("//*[@id=\"fullColumn\"]/div[7]/div[3]/span");
    private final By listPortfolioLocator = By.xpath("//*[@id=\"addPortfolioPopup\"]/div[2]/div[1]");
    private final By activePortfolioLocator = By.xpath("//*[@id=\"addPortfolioPopup\"]/div[2]/div[2]");
    private final By portfolioNameLocator = By.xpath("//*[@id=\"newPortfolioText\"]");
    private final By createButtonLocator = By.xpath("//*[@id=\"createPortfolio\"]");

    private final By listLocator = By.xpath("//*[@id=\"tab_54085528\"]");
    private final By activeLocator = By.xpath("//*[@id=\"tab_54085530\"]");
    private final By searchPositionListLocator = By.xpath("//*[@id=\"searchText_54085528\"]");
    private final By searchPositionActiveLocator = By.xpath("//*[@id=\"searchText_addPos_54085530\"]");
    private final By positionLocator = By.xpath("//*[@id=\"searchRowIdtop_0\"]");
    private final By positionCountLocator = By.xpath("//*[@id=\"a_amount_54085530\"]");
    private final By positionCommissionLocator = By.xpath("//*[@id=\"a_comission_54085530\"]");
    private final By addPositionLocator = By.xpath("//*[@id=\"addPositionBtn_54085530\"]");

    private final By selectPositionListLocator = By.xpath("//*[@id=\"sort_13684\"]");
    private final By selectPositionActiveLocator = By.xpath("//tr[contains(@id, 'row_symbol') and contains(@id, '13684')]");
    private final By deletePositionListLocator = By.xpath("//*[@id=\"sort_13684\"]/td[21]/a");
    private final By closePositionActiveLocator = By.xpath("//tr[contains(@id, 'row_symbol') and contains(@id, '13684')]/td/div/div[1]/div/div[1]");
    private final By confirmClosePositionActiveLocator = By.xpath("//a[contains(@id, 'closeBtn') and contains(@id, 'row_symbol') and contains(@id, '13684')]");
    private final By openOperationPositionActiveLocator = By.xpath("//*[@id=\"li2_54085530\"]/a");
    private final By selectOperationPositionActiveLocator = By.xpath("//*[@id=\"delete_symbol\"]");
    private final By deletePositionActiveLocator = By.xpath("//div[contains(@id, 'row_symbol') and contains(@id, '13684')]");
    private final By confirmDeletePositionActiveLocator = By.xpath("/html/body/div[12]/div[3]/div/button[1]");

    private final By editPositionActiveLocator = By.xpath("//tr[contains(@id, 'row_symbol') and contains(@id, '13684')]/td/div/div[1]/div/div[2]");
    private final By editCountPositionActiveLocator = By.xpath("//input[contains(@id, 'amountrow_symbol') and contains(@id, '13684')]");
    private final By confirmEditCountPositionActiveLocator = By.xpath("//a[contains(@id, 'editBtn') and contains(@id, 'row_symbol') and contains(@id, '13684')]");

    private static final String PORTFOLIO_PAGE_URL = "https://ru.investing.com/portfolio/";

    public PortfolioPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToPortfolioPage() {
        driver.get(PORTFOLIO_PAGE_URL);
    }

    public void createListPortfolio(String portfolioName) {
        createPortfolio(listPortfolioLocator, portfolioName);
    }

    public void createActivePortfolio(String portfolioName) {
        createPortfolio(activePortfolioLocator, portfolioName);
    }


    public void goToPortfolio(By portfolioLocator) {
        clickElement(portfolioLocator);
    }

    private void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    private void hoverOverElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    private void createPortfolio(By portfolioTypeLocator, String portfolioName) {
        clickElement(addPortfolioLocator);
        clickElement(portfolioTypeLocator);
        enterText(portfolioNameLocator, portfolioName);
        clickElement(createButtonLocator);
    }

    public void addPositionInPortfolioList(String positionName) {
        goToPortfolio(listLocator);
        enterText(searchPositionListLocator, positionName);
        clickElement(positionLocator);
    }

    public void addPositionInPortfolioActive(String positionName, String positionCount, String positionCommission) {
        goToPortfolio(activeLocator);
        enterText(searchPositionActiveLocator, positionName);
        clickElement(positionLocator);
        enterText(positionCountLocator, positionCount);
        enterText(positionCommissionLocator, positionCommission);
        clickElement(addPositionLocator);
    }

    public void deletePositionList() {
        goToPortfolio(listLocator);
        hoverOverElement(selectPositionListLocator);
        clickElement(deletePositionListLocator);
    }

    public void closePositionActive() {
        goToPortfolio(activeLocator);
        clickElement(selectPositionActiveLocator);
        clickElement(closePositionActiveLocator);
        clickElement(confirmClosePositionActiveLocator);
    }

    public void deletePositionActive() {
        goToPortfolio(activeLocator);
        clickElement(openOperationPositionActiveLocator);
        hoverOverElement(selectPositionActiveLocator);
        clickElement(selectOperationPositionActiveLocator);
        clickElement(deletePositionActiveLocator);
        clickElement(confirmDeletePositionActiveLocator);
    }

    public void editPositionActive(String positionCount) {
        goToPortfolio(activeLocator);
        clickElement(selectPositionActiveLocator);
        clickElement(editPositionActiveLocator);
        enterText(editCountPositionActiveLocator, positionCount);
        clickElement(confirmEditCountPositionActiveLocator);
    }

}
