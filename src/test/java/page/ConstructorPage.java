package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConstructorPage {

    private WebDriver driver;

    public ConstructorPage(WebDriver driver){
        this.driver = driver;
    }

    public By getCreateOrderButton() {
        return createOrderButton;
    }

    private By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");

    public By getLoginButton() {
        return loginButton;
    }

    private By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");

    public By getBunTab() {
        return bunTab;
    }

    public By getSaucesTab() {
        return saucesTab;
    }

    public By getFillingTab() {
        return fillingTab;
    }

    private By bunTab = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[1]");

    private By saucesTab = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[2]");

    private By fillingTab = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[3]");


    @Step("кликнуть по кнопке входа")
    public void loginTest() {
        WebElement element = driver.findElement(loginButton);
        element.click();
    }

    @Step("кликнуть по разделу булки")
    public void bunTabTest() {
        WebElement element = driver.findElement(bunTab);
        element.click();
    }

    @Step("кликнуть по разделу соусы")
    public void saucesTabTest() {
        WebElement element = driver.findElement(saucesTab);
        element.click();
    }

    @Step("кликнуть по разделу начинки")
    public void fillingTabTest() {
        WebElement element = driver.findElement(fillingTab);
        element.click();
    }

    }
