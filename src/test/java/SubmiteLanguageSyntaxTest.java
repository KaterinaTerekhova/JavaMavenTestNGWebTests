import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SubmiteLanguageSyntaxTest {

    @Test
    public void testSubmiteLanguageSyntax() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/C:/Users/Королевна/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";

        //String expectedResult = "Error: Precondition failed - Incomplete Input.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement menuSubmiteButton = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@type='submit']")
                );
        menuSubmiteButton.click();

        WebElement menuError = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@type='submit']")
                );

        WebElement menuTextOfError = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/p"));


//        String actualResult = menuTextOfError.getText();
//        Assert.assertEquals(actualResult,expectedResult);
//        driver.quit();
    }
}
