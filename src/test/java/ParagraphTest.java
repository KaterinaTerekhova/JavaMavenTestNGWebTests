import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParagraphTest {
    /**
     * Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/abc.html ,
     * первый пункт подменю называется 0-9
     */

    @Test
    public void testParagraph() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/C:/Users/Королевна/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net";

        String expectedResult = "0-9";

        System.setProperty(chromeDriver,driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement firstSubtitle = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']")
                );
        firstSubtitle.click();

        WebElement buttonName = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='0.html']")
            );

        String actualResult = buttonName.getText();
        Assert.assertEquals(actualResult,expectedResult);

        Thread.sleep(2000);
           driver.quit();
    }

}
