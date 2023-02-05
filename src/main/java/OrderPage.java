import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;//Инициализировали драйвер
    }

    private final By buttonOrderUp = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    private By lowerOrderButton = By.className("Button_Middle__1CSJM");
    private final By nameField = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input");
    private final By surNameField = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/input");
    private final By addressField = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[3]/input");
    private final By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By phoneField = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[5]/input");
    //Локаторы для 1 й страницы
    private final By buttonNext =  By.xpath("//div/div[2]/div[3]/button");
    private final By dateField = By.xpath(".//div/div[2]/div[2]/div[1]/div/div/input");
    private final By periodField = By.xpath("//div/div[2]/div[2]/div[2]/div");
    private final By isBlackCheckbox = By.xpath(".//input[@id='black']");
    private final By isGreyCheckbox = By.xpath("//input[@id='grey']");
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By buttonOrd = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private By orderStatusCompleted = By.xpath("//*[contains(text(), 'Заказ оформлен')]");
//локаторы для 2 й страницы

    public void clickOrderButtonUp() {
        driver.findElement(buttonOrderUp).click();
    }
    //Метод определяющий нижня или верхняя кнопка
    public void chooseOrderButtonAndClick(String buttonLocation) {
        if (buttonLocation == "upper") {
            clickOrderButtonUp();
        } else if (buttonLocation == "lower") {
            clickOrderButtonDown();
        }
    }

    public void fillName(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    public void fillSurName(String surname){
        driver.findElement(surNameField).sendKeys(surname);
    }
    public void fillAddress(String address){
        driver.findElement(addressField).sendKeys(address);
    }
    public void fillMetroField(String metro){
        driver.findElement(metroField).click();
        WebElement stationMetro= driver.findElement(metroField);
        stationMetro.sendKeys(metro);
        driver.findElement(By.xpath("//div/div[2]/div[2]/div[4]/div/div[2]")).click();
    }
    public void fillPhone(String phone){
        driver.findElement(phoneField).sendKeys(phone);
    }
    //Обьедениее заполнения полей
    public void fillForm(String name,String surname,String address,String metro,String phone){
        // clickOrderButtonUp();
        fillName(name);
        fillSurName(surname);
        fillAddress(address);
        fillMetroField(metro);
        fillPhone(phone);
    }

    public void clickOrderButtonDown(){
        WebElement element = driver.findElement(lowerOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
    private By cookiesButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    public void clickSignInButton() {
        driver.findElement(cookiesButton).click();
    }
    public void clickButtonNext(){
        driver.findElement(buttonNext).click();

    }
    public void dataFill(){
        driver.findElement(dateField).click();
        driver.findElement(By.xpath("//div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[4]")).click();}
    public void periodFill(){
        driver.findElement(periodField).click();
        driver.findElement(By.xpath("//div/div[2]/div[2]/div[2]/div[2]/div[1]")).click();

    }
    public void clickBox( ){
        driver.findElement(isBlackCheckbox).click();
    }
    public void commentFill(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }
    public void  order(){
        driver.findElement(buttonOrd).click();
    }
    public void willIssue(){
        driver.findElement(By.xpath("//div/div[2]/div[5]/div[2]/button[2]")).click();
    }
    //Проверка появление окна Заказ оформлен
    public void checkOrderStatusCompleted(){
        assertEquals("Заказ оформлен Номер заказа: .  Запишите его: пригодится, чтобы отслеживать статус",getResultMessage());
    }
    public String getResultMessage(){
        return driver.findElement(orderStatusCompleted).getText();
    }
    public void rentFill(String comment){
        dataFill();
        periodFill();
        clickBox();
        commentFill(comment);
        order();
        willIssue();

    }

}
