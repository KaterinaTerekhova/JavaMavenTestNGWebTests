import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorsTest {

    @Test
    public void testAuthors() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/C:/Users/Королевна/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net";

        String expectedResult1 = "Oliver Schade";
        String expectedResult2 = "Gregor Scheithauer";
        String expectedResult3 = "Stefan Scheler";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement authorsSite = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='team.html']")
                );
        authorsSite.click();

        WebElement author1 = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[1]"));

        String actualResult1 =author1.getText();
        Assert.assertEquals(actualResult1,expectedResult1);

        WebElement author2 = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[2]"));

        String actualResult2 = author2.getText();
        Assert.assertEquals(actualResult2,expectedResult2);

        WebElement author3 = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[3]"));

        String actualResult3 = author3.getText();
        Assert.assertEquals(actualResult3,expectedResult3);

        driver.quit();
    }
}
