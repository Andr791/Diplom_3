import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class VoprosyTest {
    private WebDriver driver;
    @BeforeEach
    public void tearup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }
    @Test
    public void test1() {
        General general = new General(driver);
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        general.skolkoStoitTest();
    }
    @Test
    public void test2() {
        General general = new General(driver);
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        general.srazuNeskolkoTest();
    }
    @Test
    public void test3() {
        General general = new General(driver);
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        general.vremyaArendyTest();
    }
    @Test
    public void test4() {
        General general = new General(driver);
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        general.zakazSejchasTest();
    }
    @Test
    public void test5() {
        General general = new General(driver);
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        general.prodlitTest();
    }
    @Test
    public void test6() {
        General general = new General(driver);
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        general.zaryadkaTest();
    }
    @Test
    public void test7() {
        General general = new General(driver);
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        general.otmenaTest();
    }
    @Test
    public void test8() {
        General general = new General(driver);
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
        general.mkadTest();
    }


    @AfterEach
    public void teardown() {
      //   Закрыть браузер
        driver.quit();
   }
}