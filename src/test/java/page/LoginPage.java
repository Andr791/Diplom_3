package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By email = By.cssSelector("input[name='name']");

    private By password = By.cssSelector("input[name='Пароль']");

    private By loginButton = By.xpath(".//button[text()='Войти']");

    public By getHeader() {
        return header;
    }

    private By header = By.xpath(".//h2[text()='Вход']");

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

    @Step("кликнуть по кнопке входа")
    public void loginTest() {
        WebElement element = driver.findElement(loginButton);
        element.click();
    }

    @Step("авторизоваться, введя емейл и пароль")
    public void logIn(String userEmail, String userPassword) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        emailTest(userEmail);
        passwordTest(userPassword);
        loginTest();
    }

}
