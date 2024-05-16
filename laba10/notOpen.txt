import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class PortfolioPage {
    private final WebDriver driver;
    private final By addPortfolioLocator = By.xpath("//*[@id=\"fullColumn\"]/div[7]/div[3]/span");
    private final By listPortfolioLocator = By.xpath("//*[@id=\"addPortfolioPopup\"]/div[2]/div[1]");
    private final By activePortfolioLocator = By.xpath("//*[@id=\"addPortfolioPopup\"]/div[2]/div[2]");
    private final By portfolioNameLocator = By.xpath("//*[@id=\"newPortfolioText\"]");
    private final By createButtonLocator = By.xpath("//*[@id=\"createPortfolio\"]");

    private final By ListLocator = By.xpath("//*[@id=\"tab_54085528\"]");
    private final By ActiveLocator = By.xpath("//*[@id=\"tab_54085530\"]");
    private final By searchPositionListLocator = By.xpath("//*[@id=\"searchText_54085528\"]");
    private final By searchPositionActiveLocator = By.xpath("//*[@id=\"searchText_addPos_54085530\"]");
    private final By PositionLocator = By.xpath("//*[@id=\"searchRowIdtop_0\"]");
    private final By PositionCountLocator = By.xpath("//*[@id=\"a_amount_54085530\"]");
    private final By PositionCommissionLocator = By.xpath("//*[@id=\"a_comission_54085530\"]");
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
    }

    public void goToPortfolioPage() {
        driver.get(PORTFOLIO_PAGE_URL);
    }

    private void createPortfolio(By portfolioTypeLocator, String portfolioName) {
        WebElement addButton = driver.findElement(addPortfolioLocator);
        addButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement portfolioTypeButton = driver.findElement(portfolioTypeLocator);
        portfolioTypeButton.click();
        WebElement inputPortfolioName = driver.findElement(portfolioNameLocator);
        inputPortfolioName.sendKeys(portfolioName);
        WebElement createButton = driver.findElement(createButtonLocator);
        createButton.click();
    }

    public void createListPortfolio(String portfolioName) {
        createPortfolio(listPortfolioLocator, portfolioName);
    }

    public void createActivePortfolio(String portfolioName) {
        createPortfolio(activePortfolioLocator, portfolioName);
    }

    public void addPositionInPortfolioList(String PositionName) {
        goToPortfolio(ListLocator);
        WebElement inputPositionName = driver.findElement(searchPositionListLocator);
        inputPositionName.sendKeys(PositionName);
        WebElement selectPositionsButton = driver.findElement(PositionLocator);
        selectPositionsButton.click();
    }

    public void addPositionInPortfolioActive(String PositionName, String PositionCount, String PositionCommission) {
        goToPortfolio(ActiveLocator);
        WebElement inputPositionName = driver.findElement(searchPositionActiveLocator);
        inputPositionName.sendKeys(PositionName);
        WebElement selectPositionsButton = driver.findElement(PositionLocator);
        selectPositionsButton.click();
        WebElement inputPositionCount = driver.findElement(PositionCountLocator);
        inputPositionCount.sendKeys(PositionCount);
        WebElement inputPositionCommission = driver.findElement(PositionCommissionLocator);
        inputPositionCommission.sendKeys(PositionCommission);
        WebElement addPositionButton = driver.findElement(addPositionLocator);
        addPositionButton.click();
    }
    
    public void deletePositionList() {
        goToPortfolio(ListLocator);

        WebElement hoverElement = driver.findElement(selectPositionListLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();

        WebElement deleteButton = driver.findElement(deletePositionListLocator);
        deleteButton.click();
    }

    public void closePositionActive() {
        goToPortfolio(ActiveLocator);

        WebElement selectPositionButton = driver.findElement(selectPositionActiveLocator);
        selectPositionButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement deleteButton = selectPositionButton.findElement(closePositionActiveLocator);
        deleteButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement confirmDeleteButton = driver.findElement(confirmClosePositionActiveLocator);
        confirmDeleteButton.click();
    }

    public void deletePositionActive() {
        goToPortfolio(ActiveLocator);

        WebElement operationButton = driver.findElement(openOperationPositionActiveLocator);
        operationButton.click();

        WebElement hoverElement = driver.findElement(selectPositionActiveLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();

        WebElement selectPositionButton = driver.findElement(selectOperationPositionActiveLocator);
        selectPositionButton.click();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement deleteButton = selectPositionButton.findElement(deletePositionActiveLocator);
        deleteButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement confirmDeleteButton = driver.findElement(confirmDeletePositionActiveLocator);
        confirmDeleteButton.click();
    }

    public void editPositionActive(String PositionCount) {
        goToPortfolio(ActiveLocator);
        WebElement selectPositionButton = driver.findElement(selectPositionActiveLocator);
        selectPositionButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement editButton = selectPositionButton.findElement(editPositionActiveLocator);
        editButton.click();
        WebElement inputPositionCount = driver.findElement(editCountPositionActiveLocator);
        inputPositionCount.sendKeys(PositionCount);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        WebElement confirmEditButton = driver.findElement(confirmEditCountPositionActiveLocator);
        confirmEditButton.click();
    }

    public void goToPortfolio(By portfolioLocator) {
        WebElement portfolioButton = driver.findElement(portfolioLocator);
        portfolioButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }
}
