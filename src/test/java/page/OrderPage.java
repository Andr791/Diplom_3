package page;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;
    //конструктор класса
    public OrderPage(WebDriver driver){
        this.driver = driver;
    }
    // кнопка "заказать" верхняя
    private By orderUp = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    // кнопка "заказать" нижняя
    private By orderDown = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    // поле "имя"
    private By name = By.xpath(".//input[@placeholder='* Имя']");

    // поле "Фамилия"
    private By surname = By.xpath(".//input[@placeholder='* Фамилия']");

    // поле "Адрес"
    private By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // поле "Станция метро"
    private By metro = By.xpath(".//input[@placeholder='* Станция метро']");

    // поле "Телефон"
    private By telephone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // кнопка "Далее"
    private By next = By.xpath(".//button[text()='Далее']");

    // поле "Когда привезти самокат"
    private By whenToBring = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // поле "Срок аренды"
    private By rentalPeriod = By.xpath(".//span[@class='Dropdown-arrow']");

    // поле "Цвет самоката"
    private By color = By.className("Order_Title__3EKne");

    // поле "Комментарий для курьера"
    private By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // кнопка "Заказать"
    private By order = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");

    // кнопка "Да"
    private By yes = By.xpath(".//button[text()='Да']");

    // Блок "Заказ оформлен"
    private By ok = By.xpath("/html/body/div/div/div[2]/div[5]/div[text()='Заказ оформлен']");

    // Нажать верхнюю кнопку "Заказать"
    @Test
    public void orderUpTest() {
        WebElement element = driver.findElement(orderUp);
        element.click();
    }

    // Нажать нижнюю кнопку "Заказать"
    @Test
    public void orderDownTest() {
        WebElement element = driver.findElement(orderDown);
        element.click();
    }

    // Заполнить поле "Имя"
    @Test
    public void nameTest(String username) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(name));
        WebElement element = driver.findElement(name);
        element.sendKeys(username);
    }

    // Заполнить поле "Фамилия"
   @Test
    public void surnameTest(String usersurname) {
        WebElement element = driver.findElement(surname);
        element.sendKeys(usersurname);
    }

    // Заполнить поле "Адрес"
   @Test
    public void addressTest(String useraddress) {
        WebElement element = driver.findElement(address);
        element.sendKeys(useraddress);
    }

    // Заполнить поле "Станция метро"
   @Test
    public void metroTest(int usermetro) {
        WebElement element = driver.findElement(metro);
       element.click();
       driver.findElement(By.xpath(".//div[@class='select-search__select']/ul/li["+usermetro+"]")).click();
    }

    // Заполнить поле "Телефон"
    @Test
    public void telephoneTest(String usertelephone) {
        WebElement element = driver.findElement(telephone);
        element.sendKeys(usertelephone);
    }

    // Нажать кнопку "Далее"
    @Test
    public void nextTest() {
        WebElement element = driver.findElement(next);
        element.click();
    }

    // Заполнить поле "Когда привезти самокат"
    @Test
    public void whenToBringTest(String userWhenToBring) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(whenToBring));
        WebElement element = driver.findElement(whenToBring);
        element.sendKeys(userWhenToBring);
    }

    // Заполнить поле "Срок аренды"
    @Test
    public void rentalPeriodTest(String userRentalPeriod) {
        WebElement element = driver.findElement(rentalPeriod);
        element.click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-menu']/div[text()='"+userRentalPeriod+"']")).click();
    }

    // Заполнить поле "Цвет самоката"
    @Test
    public void colorTest(String userColor) {
        WebElement element = driver.findElement(By.xpath(".//label[text()='"+userColor+"']"));
        element.click();
    }

    // Заполнить поле "Комментарий курьера"
    @Test
    public void commentTest(String userComment) {
        WebElement element = driver.findElement(comment);
        element.sendKeys(userComment);

    }

    // Нажать кнопку "Заказать"
    @Test
    public void orderTest() {
        WebElement element = driver.findElement(order);
        element.click();
    }

    // Нажать кнопку "Да"
    @Test
    public void yesTest() {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(yes));
        WebElement element = driver.findElement(yes);
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(ok));

    }

    // флоу заказа через верхнюю кнопку
    @Test
    public void orderFlowUp(String username, String usersurname, String useraddress, int usermetro, String usertelephone, String userWhenToBring, String userRentalPeriod, String userColor, String userComment) {
        orderUpTest();
        nameTest(username);
        surnameTest(usersurname);
        addressTest(useraddress);
        metroTest(usermetro);
        telephoneTest(usertelephone);
        nextTest();
        whenToBringTest(userWhenToBring);
        rentalPeriodTest(userRentalPeriod);
        colorTest(userColor);
        commentTest(userComment);
        orderTest();
        yesTest();
    }

    // флоу заказа через нижнюю кнопку
    @Test
    public void orderFlowDown(String username, String usersurname, String useraddress, int usermetro, String usertelephone, String userWhenToBring, String userRentalPeriod, String userColor, String userComment) {
        orderDownTest();
        nameTest(username);
        surnameTest(usersurname);
        addressTest(useraddress);
        metroTest(usermetro);
        telephoneTest(usertelephone);
        nextTest();
        whenToBringTest(userWhenToBring);
        rentalPeriodTest(userRentalPeriod);
        colorTest(userColor);
        commentTest(userComment);
        orderTest();
        yesTest();
    }
}

