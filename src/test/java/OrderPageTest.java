import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrderPageTest {
    private WebDriver driver;
    private String URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void orderPage() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get(URL);
    }

    @Test

    public void testOrderUp() {
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage. clickSignInButton();
        objOrderPage.clickOrderButtonUp();
        objOrderPage.chooseOrderButtonAndClick("upper");
        objOrderPage.fillForm("Таня","Лебедева","Москва","Сокольники","89526988464");
        objOrderPage.clickButtonNext();
        objOrderPage.rentFill("привет");
        objOrderPage.checkOrderStatusCompleted();//Метод отображение результата "Заказ сделан"
    }
    @Test

    public void testOrderDown() {
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage. clickSignInButton();
        objOrderPage.clickOrderButtonUp();
        objOrderPage.chooseOrderButtonAndClick("lower");
        objOrderPage.fillForm("Таня","Лебедева","Москва","Сокольники","89526988464");
        objOrderPage.clickButtonNext();
        objOrderPage.rentFill("привет");
        objOrderPage.checkOrderStatusCompleted();//Метод отображение результата "Заказ сделан"
    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}

