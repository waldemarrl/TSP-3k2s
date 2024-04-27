import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {
        // Установка пути к драйверу Chrome
        // Установка пути к драйверу Microsoft WebDriver
        System.setProperty("webdriver.edge.driver", "E:\\Belstu\\3k2s\\TSP\\laba9\\msedgedriver.exe");

        // Создание экземпляра WebDriver для Microsoft Edge
        WebDriver driver = new EdgeDriver();
        // Открытие веб-страницы
        driver.get("https://ru.investing.com/");

        By openMatches = By.xpath("//*[@id=\"bottom-nav-row\"]/div[2]/div/nav/ul/li[2]/a");
        WebElement openMatchesButton = driver.findElement(openMatches);
        openMatchesButton.click();

        By lastMatch= By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div[2]/div[1]/div[4]/div[2]/div[1]/table/tbody/tr[1]/td[2]/div/a/h4/span/span[2]");
        WebElement lastMatchButton = driver.findElement(lastMatch);
        lastMatchButton.click();

        WebElement hoverElement = driver.findElement(By.xpath("//*[@id=\"bottom-nav-row\"]/div[1]/nav/ul/li[9]/div[1]/a/span/span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();

        // Добавление задержки перед выполнением следующего действия
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        // Нахождение и выбор нужного элемента из выпадающего меню
        WebElement lastMatchButton1 = driver.findElement(By.xpath("//*[@id=\"bottom-nav-row\"]/div[1]/nav/ul/li[9]/div[2]/div/div[2]/div/ul/li[3]/a"));
        lastMatchButton1.click();
        By insertDataLocator= By.xpath("//*[@id=\"amount1\"]");
        WebElement insertData = driver.findElement(insertDataLocator);
        insertData.sendKeys("3");

        // Закрытие браузера
        driver.quit();
    }
}