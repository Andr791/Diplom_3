package tests;

import driver.DriverExtension;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page.LoginPage;
import page.RegisterPage;

import java.time.Duration;

import static steps.StepsApi.deleteUser;
import static steps.StepsApi.login;

public class RegisterTest {
    @RegisterExtension
    private DriverExtension ext = new DriverExtension();
    private WebDriver driver;
    private String accessToken;

    @BeforeEach
    public void tearUp() {
        driver = ext.getDriver();
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @Test
    @DisplayName("Регистрация - позитивный тест")
    @Description("это UI-тест")
    public void registerPozitive() {
        RegisterPage registerPage = new RegisterPage(driver);
        String email = "azxqwe1@mail.ru";
        String password = "10458617";
        String name = "Andrey";
        registerPage.registration(name, email, password);
        LoginPage loginPage = new LoginPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(loginPage.getHeader()));
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/login";
        Assert.assertEquals(expectedUrl, currentUrl);
        Response responseLogin = login(email, password);
        accessToken = responseLogin.then().extract().body().path("accessToken");
    }

    @Test
    @DisplayName("Регистрация - негативный тест")
    @Description("это UI-тест")
    public void registerNegative() {
        RegisterPage registerPage = new RegisterPage(driver);
        String email = "azxqwe1@mail.ru";
        String password = "10458";
        String name = "Andrey";
        registerPage.registration(name, email, password);
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(registerPage.getError()));
        Assert.assertEquals("Некорректный пароль", registerPage.getErrorText());
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/register";
        Assert.assertEquals(expectedUrl, currentUrl);
        Response responseLogin = login(email, password);
        accessToken = responseLogin.then().extract().body().path("accessToken");


    }
    @AfterEach
    public void cleanup() {
        if (accessToken != null) {
            deleteUser(accessToken);
        }
    }
}