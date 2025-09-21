package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    private By name = By.cssSelector("input[name='name']");

    private By email = By.xpath("/html/body/div/div/main/div/form/fieldset[2]/div/div/input");

    private By password = By.cssSelector("input[name='Пароль']");

    public By getError() {
        return error;
    }
    public String getErrorText() {
        return driver.findElement(error).getText();
    }
    private By error = By.cssSelector(".input__error.text_type_main-default");

    private By regButton = By.xpath(".//button[text()='Зарегистрироваться']");

    private By loginButton = By.className("Auth_link__1fOlj");



    @Step("заполнить поле имя")
    public void nameTest(String username) {
        WebElement element = driver.findElement(name);
        element.sendKeys(username);
    }

    @Step("заполнить поле емейл")
    public void emailTest(String userEmail) {
        WebElement element = driver.findElement(email);
        element.sendKeys(userEmail);
    }

    @Step("заполнить поле пароль")
    public void passwordTest(String userPassword) {
        WebElement element = driver.findElement(password);
        element.sendKeys(userPassword);
    }

    @Step("нажать на кнопку зарегистрироваться")
    public void regTest() {
        WebElement element = driver.findElement(regButton);
        element.click();
    }

    @Step("зарегистрировать юзера, заполнив поля")
    public void registration(String username, String userEmail, String userPassword) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(regButton));
        nameTest(username);
        emailTest(userEmail);
        passwordTest(userPassword);
        regTest();
    }

    @Step("кликнуть кнопку авторизации")
    public void loginButtonTest() {
        WebElement element = driver.findElement(loginButton);
        element.click();
    }

}
