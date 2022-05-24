import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeadTest {
    //Подтвердите, что на странице по базовой ссылке в правом верхнем углу
    // пользователь видит заголовок 99 Bottles of Beer

    @Test
    public void testHeadTitle() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/C:/Users/Королевна/chromedriver_win32/chromedriver.exe";
        String url = "https://www.99-bottles-of-beer.net/";

        String expectedResult = "99 Bottles of Beer";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement menuHead = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='header']/h1")
                );
        menuHead.click();

        String actualResult = menuHead.getText();
        Assert.assertEquals(actualResult,expectedResult);

        Thread.sleep(2000);
        driver.quit();
    }
}
