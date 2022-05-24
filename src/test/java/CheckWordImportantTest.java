import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckWordImportantTest {

    /**
     * Подтвердите, что на странице по ссылке
     * пользователь видит предупреждение IMPORTANT:, написанное белыми буквами bold шрифтом на красном фоне,
     * и что все буквы - capital
     */

    @Test
    public void testWordImportant() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/C:/Users/Королевна/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";

        String expectedResult = "background-color: red; color: white;";
        String expectedResultFont = "700";
        String expectedResultCapital = "IMPORTANT:";


        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement bacground = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/ul/li" +
                        "/span")
                );
            String actualResult = bacground.getAttribute("style"); //написанное белыми буквами на красном фоне
            Assert.assertEquals(actualResult, expectedResult);

            String actualResultCapital = bacground.getText();        //все буквы - capital
            Assert.assertEquals(actualResultCapital,expectedResultCapital.toUpperCase());

        WebElement font = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/ul/li/span[@style='background-color:red; color: white']/b")
                );
        String actualResultFont1 = font.getCssValue("font-weight"); //через CSS шрифт
        Assert.assertEquals(actualResultFont1, expectedResultFont);

        String actualResultFontValue = font.getTagName();  //bold шрифтом
        Assert.assertEquals(actualResultFontValue, "b");

        driver.quit();
    }
}
