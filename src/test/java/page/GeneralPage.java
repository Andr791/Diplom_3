package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GeneralPage {
    private WebDriver driver;
    //конструктор класса
    public GeneralPage(WebDriver driver){
        this.driver = driver;
    }
    // Сколько это стоит? И как оплатить?
    private static By skolkoStoit = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");
    private static By skolkoStoitText = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']/../../div[@class='accordion__panel']");
    // Хочу сразу несколько самокатов! Так можно?
    private static By srazuNeskolko = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']");
    private static By srazuNeskolkoText = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']/../../div[@class='accordion__panel']");
    // Как рассчитывается время аренды?
    private static By vremyaArendy = By.xpath(".//div[text()='Как рассчитывается время аренды?']");
    private static By vremyaArendyText = By.xpath(".//div[text()='Как рассчитывается время аренды?']/../../div[@class='accordion__panel']");
    // Можно ли заказать самокат прямо на сегодня?
    private static By zakazSejchas = By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']");
    private static By zakazSejchasText = By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']/../../div[@class='accordion__panel']");
    // Можно ли продлить заказ или вернуть самокат раньше?
    private static By prodlit = By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']");
    private static By prodlitText = By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']/../../div[@class='accordion__panel']");
    // Вы привозите зарядку вместе с самокатом?
    private static By zaryadka = By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']");
    private static By zaryadkaText = By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']/../../div[@class='accordion__panel']");
    // Можно ли отменить заказ?
    private static By otmena = By.xpath(".//div[text()='Можно ли отменить заказ?']");
    private static By otmenaText = By.xpath(".//div[text()='Можно ли отменить заказ?']/../../div[@class='accordion__panel']");
    // Я жизу за МКАДом, привезёте?
    private static By mkad = By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']");
    private static By mkadText = By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']/../../div[@class='accordion__panel']");


    public static By getSkolkoStoit() {
       return skolkoStoit;
    }

    public static By getSkolkoStoitText() {
        return skolkoStoitText;
    }

    public static By getSrazuNeskolko() {
     return srazuNeskolko;
    }

    public static By getSrazuNeskolkoText() {
        return srazuNeskolkoText;
    }

    public static By getVremyaArendy() {
      return vremyaArendy;
    }

    public static By getVremyaArendyText() {
        return vremyaArendyText;
    }

    public static By getZakazSejchas() {
      return zakazSejchas;
    }

    public static By getZakazSejchasText() {
        return zakazSejchasText;
    }

    public static By getProdlit() {
       return prodlit;
    }

    public static By getProdlitText() {
        return prodlitText;
    }

    public static By getZaryadka() {
     return zaryadka;
    }

    public static By getZaryadkaText() {
        return zaryadkaText;
    }

    public static By getOtmena() {
      return otmena;
    }

    public static By getOtmenaText() {
        return otmenaText;
    }

    public static By getMkad() {
      return mkad;
        }

    public static By getMkadText() {
        return mkadText;
    }
    }
