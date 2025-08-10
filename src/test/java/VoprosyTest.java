import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class VoprosyTest {
    private WebDriver driver;

    @Test
    public void test() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // создать объект класса главной страницы
        General general = new General(driver);
        general.skolkoStoitTest();
        general.srazuNeskolkoTest();
        general.vremyaArendyTest();
        general.zakazSejchasTest();
        general.prodlitTest();
        general.zaryadkaTest();
        general.otmenaTest();
        general.mkadTest();
    }

    @AfterEach
    public void teardown() {
      //   Закрыть браузер
        driver.quit();
   }
}