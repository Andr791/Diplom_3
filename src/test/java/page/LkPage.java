package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LkPage {

    private WebDriver driver;

    public LkPage(WebDriver driver){
        this.driver = driver;
    }

    public By getProfile() {
        return profile;
    }

    private By profile = By.xpath(".//a[text()='Профиль']");

    private By exit = By.xpath(".//button[text()='Выход']");

    @Step("кликнуть по кнопке выхода из ЛК")
    public void exitTest() {
        WebElement element = driver.findElement(exit);
        element.click();
    }

}

