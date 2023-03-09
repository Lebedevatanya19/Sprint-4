import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {
    private WebDriver driver;
    private String URL="https://qa-scooter.praktikum-services.ru/";
    @Before
    public void homeUpPage() {
        driver = new ChromeDriver();
        driver.get(URL);
    }
    @Test
    public void homePageTest(){
        HomePage objHomePage=new HomePage(driver);
        objHomePage.testCookieButton();
        objHomePage.testAccordion0();
    }

    @Test
    public void homePageTest1(){
        HomePage objHomePage= new HomePage(driver);
        objHomePage.testCookieButton();
        objHomePage.testAccordion1();
    }
    @Test
    public void homePageTest2(){
        HomePage objHomePage= new HomePage(driver);
        objHomePage.testCookieButton();
        objHomePage.testAccordion2();

    }
    @Test
    public void homePageTest3(){
        HomePage objHomePage= new HomePage(driver);
        objHomePage.testCookieButton();
        objHomePage.testAccordion3();

    }

    @Test
    public void homePageTest4(){
        HomePage objHomePage= new HomePage(driver);
        objHomePage.testCookieButton();
        objHomePage.testAccordion4();
    }

    @Test
    public void homePageTest5(){
        HomePage objHomePage= new HomePage(driver);
        objHomePage.testCookieButton();
        objHomePage.testAccordion5();

    }
    @Test
    public void homePageTest6(){
        HomePage objHomePage= new HomePage(driver);
        objHomePage.testCookieButton();
        objHomePage.testAccordion6();

    }
    @Test
    public void homePageTest7(){
        HomePage objHomePage= new HomePage(driver);
        objHomePage.testCookieButton();
        objHomePage.testAccordion7();
    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}

