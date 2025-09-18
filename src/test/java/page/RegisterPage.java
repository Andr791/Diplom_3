package page;

import org.junit.jupiter.api.Test;
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

    private By name = By.xpath(".//label[text()='Имя']");

    private By email = By.xpath(".//label[text()='Email']");

    private By password = By.xpath(".//label[text()='Пароль']");

    private By errorText = By.className("input__error text_type_main-default");

    private By reg = By.xpath(".//button[text()='Зарегистрироваться']");

    @Test
    public void nameTest(String username) {
        WebElement element = driver.findElement(name);
        element.sendKeys(username);
    }

    @Test
    public void emailTest(String userEmail) {
        WebElement element = driver.findElement(email);
        element.sendKeys(userEmail);
    }

    @Test
    public void passwordTest(String userPassword) {
        WebElement element = driver.findElement(password);
        element.sendKeys(userPassword);
    }

    @Test
    public void regTest() {
        WebElement element = driver.findElement(reg);
        element.click();
    }

    public void logIn(String username, String userEmail, String userPassword) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(reg));
        nameTest(username);
        emailTest(userEmail);
        passwordTest(userPassword);
        regTest();
    }

}
