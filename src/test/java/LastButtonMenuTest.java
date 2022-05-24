import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LastButtonMenuTest {
    /**
     * Подтвердите, что на странице по базовой ссылке последний пункт меню называется Submit new Language
     *
     */

    @Test
    public void testLastButtonMenu() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/C:/Users/Королевна/chromedriver_win32/chromedriver.exe";
        String url = "https://www.99-bottles-of-beer.net/";

        String expectedResult = "Submit New Language";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement menuLastButton = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']")
                );
        menuLastButton.click();

        WebElement lastButton = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h2")
                );
        lastButton.click();

        String actualResult = lastButton.getText();
        Assert.assertEquals(actualResult,expectedResult);

        Thread.sleep(2000);
        driver.quit();
    }
}
