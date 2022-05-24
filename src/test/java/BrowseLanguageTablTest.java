import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowseLanguageTablTest {
    /**
     *  Подтвердите, что нажав на пункт меню Browse Languages, пользователь увидит таблицу
     *  со следующими названиями для первого и второго столбцов:
     * Language
     * Author
     */

    @Test
    public void testBrowseLanguageTabl() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/C:/Users/Королевна/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net";

        String expectedResultFirstColumn = "Language";
        String expectedResultSecondColumn = "Author";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement firstSubtitle = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                        "/ul[@id='menu']/li/a[@href='/abc.html']")
                );
        firstSubtitle.click();

        WebElement firstColumn = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/table[@id='category']" +
                        "/tbody/tr/th[1]")
        );

        String actualResultFirstColumn = firstColumn.getText();
        Assert.assertEquals(actualResultFirstColumn,expectedResultFirstColumn);

        WebElement secodColumn = driver.
                findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/table[@id='category']" +
                        "/tbody/tr/th[2]")
                );
        String actualResultSecondColumn = secodColumn.getText();
        Assert.assertEquals(actualResultSecondColumn,expectedResultSecondColumn);

        driver.quit();
    }
}
