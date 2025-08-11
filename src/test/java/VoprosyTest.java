import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.GeneralPage;

public class VoprosyTest {
    private WebDriver driver;

    @Test
    public void test() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        GeneralPage general = new GeneralPage(driver);
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
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