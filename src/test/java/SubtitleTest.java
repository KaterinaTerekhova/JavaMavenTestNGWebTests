import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubtitleTest {

    @Test
    public void testSubtitleMenu() throws InterruptedException {
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

        WebElement subtitle = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='./submitnewlanguage.html']")
                );
        String actualResult = subtitle.getText();
        Assert.assertEquals(actualResult,expectedResult);

        Thread.sleep(2000);
        driver.quit();


    }
}
