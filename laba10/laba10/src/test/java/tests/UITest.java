package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.ConvertPage;
import pages.DrawPage;
import pages.PortfolioPage;

public class UITest {
    @Before
    public void setUp() {
        driver = createDriver();
    }

    public static WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "E:\\Belstu\\3k2s\\TSP\\laba9\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\walde\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        return new ChromeDriver(options);
    }
    @Test
    public void portfolioTest() {
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        portfolioPage.createListPortfolio("myListPortfolio");
        portfolioPage.createActivePortfolio("myActivePortfolio");
    }

    @Test
    public void addPositionInListTest() {
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        portfolioPage.addPositionInPortfolioList("GAZP");
    }

    @Test
    public void addPositionInActiveTest() {
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        portfolioPage.addPositionInPortfolioActive("GAZP", "10", "15");
    }

    @Test
    public void deletePositionInListTest() {
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        portfolioPage.deletePositionList();
    }

    @Test
    public void closePositionInActiveTest() {
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        portfolioPage.closePositionActive();
    }

    @Test
    public void deletePositionInActiveTest() {
        addPositionInActiveTest();
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        portfolioPage.deletePositionActive();
    }

    @Test
    public void editPositionInActiveTest() {
        addPositionInActiveTest();
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        portfolioPage.editPositionActive("15");
    }

    @Test
    public void convertTest() {
        ConvertPage convertPage = new ConvertPage(driver);
        convertPage.goToConvertPage();
        convertPage.convertUSD("15");
    }

    @Test
    public void drawTest() {
        DrawPage drawPage = new DrawPage(driver);
        drawPage.goToDrawPage();
        drawPage.drawLine();
    }
    protected WebDriver driver;

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
