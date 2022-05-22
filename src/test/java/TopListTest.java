import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Подтвердите, что на странице по базовой ссылке  пользователь НЕ увидит новые комментарии,
 * если нажмет на пункты меню Top List → New Comments
 */

public class TopListTest {
    @Test
    public void testTopList() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/C:/Users/Королевна/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net";


        String expectedResultNewComments = "";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement topList = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']" +
                        "/li/a[@href='/toplist.html']"));
        topList.click();

        WebElement comments = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']" +
                        "/li/a[@href='./newcomments.html']"));
        comments.click();

        WebElement noComments = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/p"));

        String actualResultNoComments = noComments.getText();
        if(actualResultNoComments == null) {
            Assert.assertEquals(actualResultNoComments, expectedResultNewComments);
        }
        driver.quit();
    }
}
