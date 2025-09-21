package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecoveryPage {

    private WebDriver driver;

    public RecoveryPage(WebDriver driver){
        this.driver = driver;
    }

    private By loginButton = By.className("Auth_link__1fOlj");


    @Step("кликнуть по кнопке входа")
    public void loginTest() {
        WebElement element = driver.findElement(loginButton);
        element.click();
    }

}
