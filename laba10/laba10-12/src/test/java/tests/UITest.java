package tests;

import base.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import pages.ConvertPage;
import pages.DrawPage;
import pages.PortfolioPage;
import utils.LoggerConfig;

public class UITest extends BaseTest {
    private static final Logger logger = LoggerConfig.getLogger(UITest.class);

    @Test
    public void portfolioTest() {
        logger.info("Starting portfolioTest.");
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        logger.info("Navigated to Portfolio Page.");
        portfolioPage.createListPortfolio("myListPortfolio");
        logger.info("Created list portfolio 'myListPortfolio'.");
        portfolioPage.createActivePortfolio("myActivePortfolio");
        logger.info("Created active portfolio 'myActivePortfolio'.");
        logger.info("Finished portfolioTest.");
    }

    @Test
    public void addPositionInListTest() {
        logger.info("Starting addPositionInListTest.");
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        logger.info("Navigated to Portfolio Page.");
        portfolioPage.addPositionInPortfolioList("GAZP");
        logger.info("Added position 'GAZP' in portfolio list.");
        logger.info("Finished addPositionInListTest.");
    }

    @Test
    public void addPositionInActiveTest() {
        logger.info("Starting addPositionInActiveTest.");
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        logger.info("Navigated to Portfolio Page.");
        portfolioPage.addPositionInPortfolioActive("GAZP", "10", "15");
        logger.info("Added position 'GAZP' with quantity '10' and price '15' in active portfolio.");
        logger.info("Finished addPositionInActiveTest.");
    }

    @Test
    public void deletePositionInListTest() {
        logger.info("Starting deletePositionInListTest.");
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        logger.info("Navigated to Portfolio Page.");
        portfolioPage.deletePositionList();
        logger.info("Deleted position in portfolio list.");
        logger.info("Finished deletePositionInListTest.");
    }

    @Test
    public void closePositionInActiveTest() {
        logger.info("Starting closePositionInActiveTest.");
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        logger.info("Navigated to Portfolio Page.");
        portfolioPage.closePositionActive();
        logger.info("Closed position in active portfolio.");
        logger.info("Finished closePositionInActiveTest.");
    }

    @Test
    public void deletePositionInActiveTest() {
        logger.info("Starting deletePositionInActiveTest.");
        addPositionInActiveTest();
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        logger.info("Navigated to Portfolio Page.");
        portfolioPage.deletePositionActive();
        logger.info("Deleted position in active portfolio.");
        logger.info("Finished deletePositionInActiveTest.");
    }

    @Test
    public void editPositionInActiveTest() {
        logger.info("Starting editPositionInActiveTest.");
        addPositionInActiveTest();
        PortfolioPage portfolioPage = new PortfolioPage(driver);
        portfolioPage.goToPortfolioPage();
        logger.info("Navigated to Portfolio Page.");
        portfolioPage.editPositionActive("15");
        logger.info("Edited position in active portfolio to new value '15'.");
        logger.info("Finished editPositionInActiveTest.");
    }

    @Test
    public void convertTest() {
        logger.info("Starting convertTest.");
        ConvertPage convertPage = new ConvertPage(driver);
        convertPage.goToConvertPage();
        logger.info("Navigated to Convert Page.");
        convertPage.convertUSD("15");
        logger.info("Converted 15 USD.");
        logger.info("Finished convertTest.");
    }

    @Test
    public void drawTest() {
        logger.info("Starting drawTest.");
        DrawPage drawPage = new DrawPage(driver);
        drawPage.goToDrawPage();
        logger.info("Navigated to Draw Page.");
        drawPage.drawLine();
        logger.info("Drew line on the canvas.");
        logger.info("Finished drawTest.");
    }
}
