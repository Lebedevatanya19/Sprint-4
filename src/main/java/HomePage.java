import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import java.time.Duration;
public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    private By scrollQuestions=By.id ("accordion__heading-0");
    private By scrollQuestions1=By.id ("accordion__heading-1");
    private By scrollQuestions2=By.id ("accordion__heading-2");
    private By scrollQuestions3=By.id ("accordion__heading-3");
    private By scrollQuestions4=By.id ("accordion__heading-4");
    private By scrollQuestions5=By.id ("accordion__heading-5");
    private By scrollQuestions6=By.id ("accordion__heading-6");
    private By scrollQuestions7=By.id ("accordion__heading-7");
    private By openText = By.xpath("//div[@aria-expanded='true']/parent :: div/parent::div/div[@class='accordion__panel']/p");
    public final By cookieButton= By.xpath(".//button[@class='App_CookieButton__3cvqF']");
    public void waitForLoad(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-0")));
    }
    public void testAccordion0() {
        scrolToQuestion(scrollQuestions);
        waitForLoad();
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",getAccordionText(openText));
    }
    public void testAccordion1() {
        scrolToQuestion(scrollQuestions1);
        waitForLoad();
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",getAccordionText(openText));
    }
    public void testAccordion2() {
        scrolToQuestion(scrollQuestions2);
        waitForLoad();
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",getAccordionText(openText));
    }
    public void testAccordion3() {
        scrolToQuestion(scrollQuestions3);
        waitForLoad();
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.",getAccordionText(openText));
    }
    public void testAccordion4() {
        scrolToQuestion(scrollQuestions4);
        waitForLoad();
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",getAccordionText(openText));
    }
    public void testAccordion5() {
        scrolToQuestion(scrollQuestions5);
        waitForLoad();
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",getAccordionText(openText));
    }
    public void testAccordion6() {
        scrolToQuestion(scrollQuestions6);
        waitForLoad();
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",getAccordionText(openText));
    }
    public void testAccordion7() {
        scrolToQuestion(scrollQuestions7);
        waitForLoad();
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", getAccordionText(openText));
    }
    public void testCookieButton(){
        driver.findElement(cookieButton).click();
    }
    public void scrolToQuestion(By scrollQuestion) {
        WebElement textOne = driver.findElement(scrollQuestion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", textOne);
        textOne.click();
    }
    public String getAccordionText(By accordionPanel) {
        return driver.findElement(accordionPanel).getText();
    }
}

