package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPage {
    private WebDriver driver;

    public HeaderPage(WebDriver driver){
        this.driver = driver;
    }

    private By lk = By.xpath(".//p[text()='Личный Кабинет']");

    private By constructor = By.xpath(".//p[text()='Конструктор']");

    private By logo = By.xpath("/html/body/div/div/header/nav/div/a");

    @Step("кликнуть по разделу личный кабинет")
    public void lkTest() {
        WebElement element = driver.findElement(lk);
        element.click();
    }

    @Step("кликнуть по разделу конструктор")
    public void constructorTest() {
        WebElement element = driver.findElement(constructor);
        element.click();
    }

    @Step("кликнуть по логотипу сайта")
    public void logoTest() {
        WebElement element = driver.findElement(logo);
        element.click();
    }

}
