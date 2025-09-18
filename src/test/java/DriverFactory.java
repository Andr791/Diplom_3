import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private WebDriver driver;

    public void initDriver() {
        if ("yandex".equals(System.getProperty("browser"))) {
            initYandex();
        } else {
            initYandex();
        }
    }

    public void setupChrome() {
        System.setProperty("webdriver.chrome.driver", "C:/f/chromedriver.exe");
        driver = new ChromeDriver();

    }


    private void initYandex() {
        System.setProperty("webdriver.chrome.driver", "C:/f/yandexdriver.exe");

        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

