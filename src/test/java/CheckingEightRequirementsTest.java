import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Precondition: Если на странице по ссылке http://www.99-bottles-of-beer.net/submitnewlanguage.html ,
 * пользователь нажмет кнопку Submit Language,  не заполнив информацию в обязательных полях,
 * будет показана ошибка с текстом
 *
 * Error: Precondition failed - Incomplete Input.
 *
 * Подтвертите, что в тексте ошибки слова Error, Precondition, Incomplete и Input
 * написаны с большой буквы, а слово failed  написано  с маленькой буквы.
 * Так же подтвердите, что в тексте ошибки содержатся знаки :, -  и .
 */

public class CheckingEightRequirementsTest {
    @Test
    public void testCheckingRequirements(){

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/C:/Users/Королевна/chromedriver_win32/chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";


        String expectedResultWord1 = "Error";
        String expectedResultWord2 = "Precondition";
        String expectedResultWord3 = "Incomplete";
        String expectedResultWord4 = "Input";
        String expectedResultWord5 = "failed";
        String expectedResultSign1 = ":";
        String expectedResultSign2 = "-";
        String expectedResultSign3 = ".";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(url);

//        driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']" +
//                        "/p/input[@type='submit']")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebElement sentence = driver.findElement(By.xpath("//p[@style]"));

        Assert.assertEquals(sentence.getText().substring(0,5),expectedResultWord1);
        Assert.assertEquals(sentence.getText().substring(7,19),expectedResultWord2);
        Assert.assertEquals(sentence.getText().substring(29,39),expectedResultWord3);
        Assert.assertEquals(sentence.getText().substring(40,45),expectedResultWord4);
        Assert.assertEquals(sentence.getText().substring(20,26),expectedResultWord5);
        Assert.assertEquals(sentence.getText().substring(5,6),expectedResultSign1);
        Assert.assertEquals(sentence.getText().substring(27,28),expectedResultSign2);
        Assert.assertEquals(sentence.getText().substring(45),expectedResultSign3);

        driver.quit();
    }
}
