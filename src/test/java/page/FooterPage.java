package page;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterPage {
    private WebDriver driver;
    //конструктор класса
    public FooterPage(WebDriver driver){
        this.driver = driver;
    }
    // Кнопка куки
    private By cookieButton = By.className("App_CookieButton__3cvqF");

    // нажатие на кнопку куки
    @Test
    public void cookieButtonTest() {
        WebElement element = driver.findElement(cookieButton);
        element.click();
    }
}
