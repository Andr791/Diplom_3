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

public class GoToTest {
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
    @DisplayName("переход по клику на «Личный кабинет»")
    @Description("это UI-тест")
    public void transitionToPersonalAccount() {
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        String email = "azxqwe1@mail.ru";
        String password = "10458617";
        loginPage.logIn(email, password);

        ConstructorPage constructorPage = new ConstructorPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorPage.getCreateOrderButton()));
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.lkTest();

        LkPage lkPage = new LkPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(lkPage.getProfile()));
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/account/profile";
        Assert.assertEquals(expectedUrl, currentUrl);
    }

    @Test
    @DisplayName("переход из ЛК по клику на «Конструктор»")
    @Description("это UI-тест")
    public void transitionToTheDesigner() {
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        String email = "azxqwe1@mail.ru";
        String password = "10458617";
        loginPage.logIn(email, password);

        ConstructorPage constructorPage = new ConstructorPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorPage.getCreateOrderButton()));
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.lkTest();

        LkPage lkPage = new LkPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(lkPage.getProfile()));
        headerPage.constructorTest();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorPage.getCreateOrderButton()));

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/";
        Assert.assertEquals(expectedUrl, currentUrl);
    }

    @Test
    @DisplayName("переход из ЛК по клику на логотип Stellar Burgers")
    @Description("это UI-тест")
    public void transitionByClickingOnTheLogo() {
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        String email = "azxqwe1@mail.ru";
        String password = "10458617";
        loginPage.logIn(email, password);

        ConstructorPage constructorPage = new ConstructorPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorPage.getCreateOrderButton()));
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.lkTest();

        LkPage lkPage = new LkPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(lkPage.getProfile()));
        headerPage.logoTest();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorPage.getCreateOrderButton()));

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/";
        Assert.assertEquals(expectedUrl, currentUrl);
    }

    @Test
    @DisplayName("выход по кнопке «Выйти» в личном кабинете")
    @Description("это UI-тест")
    public void logoutFromYourPersonalAccount() {
        driver.get("https://stellarburgers.nomoreparties.site/login");

        LoginPage loginPage = new LoginPage(driver);
        String email = "azxqwe1@mail.ru";
        String password = "10458617";
        loginPage.logIn(email, password);

        ConstructorPage constructorPage = new ConstructorPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorPage.getCreateOrderButton()));
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.lkTest();

        LkPage lkPage = new LkPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(lkPage.getProfile()));
        lkPage.exitTest();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(loginPage.getHeader()));

        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://stellarburgers.nomoreparties.site/login";
        Assert.assertEquals(expectedUrl, currentUrl);
    }

    @Test
    @DisplayName("переход к разделу «Булки»")
    @Description("это UI-тест")
    public void goToTheBunsSection() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        ConstructorPage constructorPage = new ConstructorPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorPage.getBunTab()));
        constructorPage.saucesTabTest();
        constructorPage.bunTabTest();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(constructorPage.getBunTab(), "class", "current"));
    }

    @Test
    @DisplayName("переход к разделу «Соусы»")
    @Description("это UI-тест")
    public void goToTheSaucesSection() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        ConstructorPage constructorPage = new ConstructorPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorPage.getSaucesTab()));
        constructorPage.saucesTabTest();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(constructorPage.getSaucesTab(), "class", "current"));
    }

    @Test
    @DisplayName("переход к разделу «Начинки»")
    @Description("это UI-тест")
    public void goToTheFillingsSection() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        ConstructorPage constructorPage = new ConstructorPage(driver);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(constructorPage.getFillingTab()));
        constructorPage.fillingTabTest();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(constructorPage.getFillingTab(), "class", "current"));
    }

    @AfterAll
    public static void cleanup() {
        if (accessToken != null) {
            deleteUser(accessToken);
        }
    }
}
