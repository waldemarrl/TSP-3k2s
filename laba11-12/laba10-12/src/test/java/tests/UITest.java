package tests;

import base.BaseTest;
import org.junit.Test;
import utils.LoggerConf;
import pages.ConvertPage;
import pages.DrawPage;
import pages.PortfolioPage;

public class UITest extends BaseTest {

    @Test
    public void portfolioTest() {
        LoggerConf.info("Starting portfolioTest.");
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        LoggerConf.info("Navigated to Portfolio Page.");
        portfolioPage.createListPortfolio("myListPortfolio");
        LoggerConf.info("Created list portfolio 'myListPortfolio'.");
        portfolioPage.createActivePortfolio("myActivePortfolio");
        LoggerConf.info("Created active portfolio 'myActivePortfolio'.");
        LoggerConf.info("Finished portfolioTest.");
    }

    @Test
    public void addPositionInListTest() {
        LoggerConf.info("Starting addPositionInListTest.");
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        LoggerConf.info("Navigated to Portfolio Page.");
        portfolioPage.addPositionInPortfolioList("GAZP");
        LoggerConf.info("Added position 'GAZP' in portfolio list.");
        LoggerConf.info("Finished addPositionInListTest.");
    }

    @Test
    public void addPositionInActiveTest() {
        LoggerConf.info("Starting addPositionInActiveTest.");
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        LoggerConf.info("Navigated to Portfolio Page.");
        portfolioPage.addPositionInPortfolioActive("GAZP", "10", "15");
        LoggerConf.info("Added position 'GAZP' with quantity '10' and price '15' in active portfolio.");
        LoggerConf.info("Finished addPositionInActiveTest.");
    }

    @Test
    public void deletePositionInListTest() {
        LoggerConf.info("Starting deletePositionInListTest.");
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        LoggerConf.info("Navigated to Portfolio Page.");
        portfolioPage.deletePositionList();
        LoggerConf.info("Deleted position in portfolio list.");
        LoggerConf.info("Finished deletePositionInListTest.");
    }

    @Test
    public void closePositionInActiveTest() {
        LoggerConf.info("Starting closePositionInActiveTest.");
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        LoggerConf.info("Navigated to Portfolio Page.");
        portfolioPage.closePositionActive();
        LoggerConf.info("Closed position in active portfolio.");
        LoggerConf.info("Finished closePositionInActiveTest.");
    }

    @Test
    public void deletePositionInActiveTest() {
        LoggerConf.info("Starting deletePositionInActiveTest.");
        addPositionInActiveTest();
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        LoggerConf.info("Navigated to Portfolio Page.");
        portfolioPage.deletePositionActive();
        LoggerConf.info("Deleted position in active portfolio.");
        LoggerConf.info("Finished deletePositionInActiveTest.");
    }

    @Test
    public void editPositionInActiveTest() {
        LoggerConf.info("Starting editPositionInActiveTest.");
        addPositionInActiveTest();
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        LoggerConf.info("Navigated to Portfolio Page.");
        portfolioPage.editPositionActive("15");
        LoggerConf.info("Edited position in active portfolio to new value '15'.");
        LoggerConf.info("Finished editPositionInActiveTest.");
    }

    @Test
    public void convertTest() {
        LoggerConf.info("Starting convertTest.");
        ConvertPage convertPage = new ConvertPage(driver);
        convertPage.goToConvertPage();
        LoggerConf.info("Navigated to Convert Page.");
        convertPage.convertUSD("15");
        LoggerConf.info("Converted 15 USD.");
        LoggerConf.info("Finished convertTest.");
    }

    @Test
    public void drawTest() {
        LoggerConf.info("Starting drawTest.");
        DrawPage drawPage = new DrawPage(driver);
        drawPage.goToDrawPage();
        LoggerConf.info("Navigated to Draw Page.");
        drawPage.drawLine();
        LoggerConf.info("Drew line on the canvas.");
        LoggerConf.info("Finished drawTest.");
    }
}
