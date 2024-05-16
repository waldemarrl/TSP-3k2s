import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class UnitTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private PortfolioPage portfolioPage;
    private ConvertPage convertPage;
    private DrawPage drawPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\Belstu\\3k2s\\TSP\\laba9\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
//        String proxyAddress = "83.169.17.201:80";
//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy(proxyAddress);

        options.addArguments("user-data-dir=C:\\Users\\walde\\AppData\\Local\\Google\\Chrome\\User Data");
//        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, как Gecko) Chrome/90.0.4430.93 Safari/537.36");

        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
        portfolioPage = new PortfolioPage(driver);
        convertPage = new ConvertPage(driver);
        drawPage = new DrawPage(driver);

    }

//    @Test
//    public void LoginTest() throws InterruptedException {
//        Thread.sleep(3000);
//        loginPage.goToHomePage();
//        Thread.sleep(3000);
//        loginPage.openLoginForm();
//        Thread.sleep(3000);
//        loginPage.login("lobanov.v.d@gmail.com", "06212111wgN");
//        Thread.sleep(2000);
//    }

    @Test
    public void PortfolioTest() throws InterruptedException {
        Thread.sleep(2000);
        portfolioPage.goToPortfolioPage();
        Thread.sleep(2000);
        portfolioPage.createListPortfolio("myListPortfolio");
        Thread.sleep(2000);
        portfolioPage.createActivePortfolio("myActivePortfolio");
        Thread.sleep(2000);
    }

    @Test
    public void addPositionInListTest() throws InterruptedException {
        Thread.sleep(2000);
        portfolioPage.goToPortfolioPage();
        Thread.sleep(2000);
        portfolioPage.addPositionInPortfolioList("GAZP");
        Thread.sleep(2000);
    }

    @Test
    public void addPositionInActiveTest() throws InterruptedException {
        Thread.sleep(2000);
        portfolioPage.goToPortfolioPage();
        Thread.sleep(2000);
        portfolioPage.addPositionInPortfolioActive("GAZP", "10", "15");
        Thread.sleep(2000);
    }
    
    @Test
    public void deletePositionInListTest() throws InterruptedException {
        Thread.sleep(2000);
        portfolioPage.goToPortfolioPage();
        Thread.sleep(2000);
        portfolioPage.deletePositionList();
        Thread.sleep(2000);
    }

    @Test
    public void closePositionInActiveTest() throws InterruptedException {
        Thread.sleep(2000);
        portfolioPage.goToPortfolioPage();
        Thread.sleep(2000);
        portfolioPage.closePositionActive();
        Thread.sleep(2000);
    }

    @Test
    public void deletePositionInActiveTest() throws InterruptedException {
        addPositionInActiveTest();
        Thread.sleep(2000);
        portfolioPage.goToPortfolioPage();
        Thread.sleep(2000);
        portfolioPage.deletePositionActive();
        Thread.sleep(2000);
    }

    @Test
    public void editPositionInActiveTest() throws InterruptedException {
        addPositionInActiveTest();
        Thread.sleep(2000);
        portfolioPage.goToPortfolioPage();
        Thread.sleep(2000);
        portfolioPage.editPositionActive("15");
        Thread.sleep(2000);
    }

    @Test
    public void convertTest() throws InterruptedException {
        Thread.sleep(2000);
        convertPage.goToConvertPage();
        Thread.sleep(2000);
        convertPage.convertUSD("15");
        Thread.sleep(2000);
    }

    @Test
    public void drawTest() throws InterruptedException {
        Thread.sleep(2000);
        drawPage.goToDrawPage();
        Thread.sleep(2000);
        drawPage.drawLine();
        Thread.sleep(2000);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
