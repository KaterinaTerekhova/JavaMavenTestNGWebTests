import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextTest {
    /**
     * Подтвердите, что на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html
     * в первом пункте списка пользователь видит текст
     *
     * IMPORTANT: Take your time! The more carefully you fill out this form
     * (especially the language name and description), the easier it will be for us and the faster
     * your language will show up on this page. We don't have the time to mess around with fixing your
     * descriptions etc.
     * Thanks for your understanding.
     */

    @Test
    public void testSubmiteLanguage() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/C:/Users/Королевна/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";

        String expectedResult = "IMPORTANT: Take your time! The more carefully you fill out this form " +
                "(especially the language name and description), the easier it will be for us and the faster" +
                " your language will show up on this page. We don't have the time to mess around with fixing " +
                "your descriptions etc. Thanks for your understanding.";

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

        WebElement important = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/ul/li"));

        String actualResult = important.getText();
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
}
