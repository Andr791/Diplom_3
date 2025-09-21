package tests;

import driver.DriverExtension;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page.*;

import java.time.Duration;

import static steps.StepsApi.deleteUser;
import static steps.StepsApi.userCreate;


public class LoginTest {
    @RegisterExtension
    private DriverExtension ext = new DriverExtension();
    private WebDriver driver;
    private static String accessToken;

    @BeforeAll
    public static void createUser() {
        String email = "azxqwe1@mail.ru";
        String password = "10458617";
        String name = "Andrey";
        Response response = userCreate(email, password, name);
        accessToken = response.then().extract().body().path("accessToken");
    }

    @BeforeEach
    public void tearUp() {
        driver = ext.getDriver();
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    @Description("это UI-тест")
    public void logInThroughTheMainPage() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.loginTest();
        LoginPage loginPage = new LoginPage(driver);
        String email = "azxqwe1@mail.ru";
        String password = "10458617";
        loginPage.logIn(email, password);

        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorPage.getCreateOrderButton()));
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/";
        Assert.assertEquals(expectedUrl, currentUrl);

    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    @Description("это UI-тест")
    public void logInThroughYourPersonalAccount() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.lkTest();

        LoginPage loginPage = new LoginPage(driver);
        String email = "azxqwe1@mail.ru";
        String password = "10458617";
        loginPage.logIn(email, password);

        ConstructorPage constructorPage = new ConstructorPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorPage.getCreateOrderButton()));
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/";
        Assert.assertEquals(expectedUrl, currentUrl);
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    @Description("это UI-тест")
    public void logInUsingTheRegistrationForm() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.loginButtonTest();

        LoginPage loginPage = new LoginPage(driver);
        String email = "azxqwe1@mail.ru";
        String password = "10458617";
        loginPage.logIn(email, password);

        ConstructorPage constructorPage = new ConstructorPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorPage.getCreateOrderButton()));
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/";
        Assert.assertEquals(expectedUrl, currentUrl);
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    @Description("это UI-тест")
    public void logInViaTheRecoveryForm() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        RecoveryPage recoveryPage = new RecoveryPage(driver);
        recoveryPage.loginTest();

        LoginPage loginPage = new LoginPage(driver);
        String email = "azxqwe1@mail.ru";
        String password = "10458617";
        loginPage.logIn(email, password);

        ConstructorPage constructorPage = new ConstructorPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorPage.getCreateOrderButton()));
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/";
        Assert.assertEquals(expectedUrl, currentUrl);
    }

    @AfterAll
    public static void cleanup() {
        if (accessToken != null) {
            deleteUser(accessToken);
        }
    }
}
