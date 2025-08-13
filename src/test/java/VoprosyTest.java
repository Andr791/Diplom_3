import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.FooterPage;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static page.GeneralPage.*;

public class VoprosyTest {
    private WebDriver driver;

    @BeforeEach
    public void tearUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        FooterPage footerPage = new FooterPage(driver);
        footerPage.cookieButtonTest();
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void testAnswersToQuestions(By locator, By locatorText, String expectedText) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(locatorText));
        String text = driver.findElement(locatorText).getText();
        assertEquals(expectedText, text);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(getSkolkoStoit(), getSkolkoStoitText(), "Сутки — 400 рублей. Оплата курьеру — наличными или картой."),
                Arguments.of(getSrazuNeskolko(), getSrazuNeskolkoText(), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."),
                Arguments.of(getVremyaArendy(), getVremyaArendyText(), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."),
                Arguments.of(getZakazSejchas(), getZakazSejchasText(), "Только начиная с завтрашнего дня. Но скоро станем расторопнее."),
                Arguments.of(getProdlit(), getProdlitText(), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."),
                Arguments.of(getZaryadka(), getZaryadkaText(), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."),
                Arguments.of(getOtmena(), getOtmenaText(), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."),
                Arguments.of(getMkad(), getMkadText(), "Да, обязательно. Всем самокатов! И Москве, и Московской области.")
        );
    }

    @AfterEach
    public void teardown() {
      //   Закрыть браузер
        driver.quit();
   }
}