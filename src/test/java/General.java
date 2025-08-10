import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class General {
    private WebDriver driver;
    //конструктор класса
    public General(WebDriver driver){
        this.driver = driver;
    }
    // Сколько это стоит? И как оплатить?
    private By skolkoStoit = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");
    private By skolkoStoitText = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']/../../div[@class='accordion__panel']");
    // Хочу сразу несколько самокатов! Так можно?
    private By srazuNeskolko = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']");
    private By srazuNeskolkoText = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']/../../div[@class='accordion__panel']");
    // Как рассчитывается время аренды?
    private By vremyaArendy = By.xpath(".//div[text()='Как рассчитывается время аренды?']");
    private By vremyaArendyText = By.xpath(".//div[text()='Как рассчитывается время аренды?']/../../div[@class='accordion__panel']");
    // Можно ли заказать самокат прямо на сегодня?
    private By zakazSejchas = By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']");
    private By zakazSejchasText = By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']/../../div[@class='accordion__panel']");
    // Можно ли продлить заказ или вернуть самокат раньше?
    private By prodlit = By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']");
    private By prodlitText = By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']/../../div[@class='accordion__panel']");
    // Вы привозите зарядку вместе с самокатом?
    private By zaryadka = By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']");
    private By zaryadkaText = By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']/../../div[@class='accordion__panel']");
    // Можно ли отменить заказ?
    private By otmena = By.xpath(".//div[text()='Можно ли отменить заказ?']");
    private By otmenaText = By.xpath(".//div[text()='Можно ли отменить заказ?']/../../div[@class='accordion__panel']");
    // Я жизу за МКАДом, привезёте?
    private By mkad = By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']");
    private By mkadText = By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']/../../div[@class='accordion__panel']");

    @Test
    public void skolkoStoitTest() {
        WebElement element = driver.findElement(skolkoStoit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(skolkoStoitText));
        String text = driver.findElement(skolkoStoitText).getText();
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", text);
    }

    @Test
    public void srazuNeskolkoTest() {
        WebElement element = driver.findElement(srazuNeskolko);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(srazuNeskolkoText));
        String text = driver.findElement(srazuNeskolkoText).getText();
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", text);
    }

    @Test
    public void vremyaArendyTest() {
        WebElement element = driver.findElement(vremyaArendy);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(vremyaArendyText));
        String text = driver.findElement(vremyaArendyText).getText();
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", text);
    }

    @Test
    public void zakazSejchasTest() {
        WebElement element = driver.findElement(zakazSejchas);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(zakazSejchasText));
        String text = driver.findElement(zakazSejchasText).getText();
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", text);
    }

    @Test
    public void prodlitTest() {
        WebElement element = driver.findElement(prodlit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(prodlitText));
        String text = driver.findElement(prodlitText).getText();
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", text);
    }

    @Test
    public void zaryadkaTest() {
        WebElement element = driver.findElement(zaryadka);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(zaryadkaText));
        String text = driver.findElement(zaryadkaText).getText();
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", text);
    }

    @Test
    public void otmenaTest() {
        WebElement element = driver.findElement(otmena);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(otmenaText));
        String text = driver.findElement(otmenaText).getText();
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", text);
    }

    @Test
    public void mkadTest() {
        WebElement element = driver.findElement(mkad);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(mkadText));
        String text = driver.findElement(mkadText).getText();
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", text);
        }
    }
