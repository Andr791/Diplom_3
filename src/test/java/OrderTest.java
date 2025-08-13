import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.FooterPage;
import page.OrderPage;

import java.util.stream.Stream;


public class OrderTest {
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
    public void testOrderUp(String username, String usersurname, String useraddress, int usermetro, String usertelephone, String userWhenToBring, String userRentalPeriod, String userColor, String userComment) {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.orderFlowUp(username, usersurname, useraddress, usermetro, usertelephone, userWhenToBring, userRentalPeriod, userColor, userComment);
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void testOrderDown(String username, String usersurname, String useraddress, int usermetro, String usertelephone, String userWhenToBring, String userRentalPeriod, String userColor, String userComment) {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.orderFlowDown(username, usersurname, useraddress, usermetro, usertelephone, userWhenToBring, userRentalPeriod, userColor, userComment);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("Андрей", "Рожков", "Елец, Костенко, 1", 1, "+79205018745", "01.09.2025", "сутки", "чёрный жемчуг", "коммент1"),
                Arguments.of("Иван", "Борисов", "Липецк, Центральная, 10", 2, "+74746768380", "30.09.2025", "двое суток", "серая безысходность", "коммент2")
        );
    }
    @AfterEach
    public void teardown() {
        //   Закрыть браузер
        driver.quit();
    }
}
