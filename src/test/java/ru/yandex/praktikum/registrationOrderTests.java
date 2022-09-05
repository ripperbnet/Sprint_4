package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import java.util.concurrent.TimeUnit;

public class registrationOrderTests {
    private WebDriver webDriver;

    @Before
    public void setupChrome() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After

    public void tearDownChrome() {
        webDriver.manage().deleteAllCookies();
        ((WebStorage) webDriver).getSessionStorage().clear();
        ((WebStorage) webDriver).getLocalStorage().clear();
        webDriver.quit();
    }

    @Test
    public void orderWithHeaderOrderButton() {   // Заказ по кнопке "Заказать" из хэдера
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOnCookieAcceptButton();
        mainPage.clickOnHeaderOrderButton();
        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.typeName("Иван");
        orderPage.typeSurname("Иванов");
        orderPage.typeAddress("ул. советская, д.3, кв. 55");
        orderPage.chooseMetroStation();
        orderPage.typePhone("+79253557619");
        orderPage.clickOnContinueButton();
        orderPage.clickOnDateField();
        orderPage.chooseDay();
        orderPage.chooseRentalPeriod();
        orderPage.chooseColorGrey();
        orderPage.typeCommentForCourier("Тестовый комментарий для курьера");
        orderPage.pressButtonToOrder();
        orderPage.pressNoButton();
        orderPage.pressButtonToOrder();
        orderPage.pressYesButton();
        boolean isDisplayed = orderPage.isOrderCreated();
        Assert.assertTrue("Order is not created, message not found", isDisplayed);
    }


    @Test
    public void orderWithBigOrderButton() {      // Заказ по большой кнопке "Заказать"
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOnCookieAcceptButton();
        mainPage.scrollDownWindow();
        mainPage.clickOnBigOrderButton();
        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.typeName("ИВАН");
        orderPage.typeSurname("ИВАНОВ");
        orderPage.typeAddress( "УЛ. СОВЕТСКАЯ, Д.3, КВ. 55");
        orderPage.chooseMetroStation();
        orderPage.typePhone("781017754894");
        orderPage.clickOnContinueButton();
        orderPage.clickOnDateField();
        orderPage.chooseDay();
        orderPage.chooseRentalPeriod();
        orderPage.chooseColorBlack();
        orderPage.typeCommentForCourier("");
        orderPage.pressButtonToOrder();
        orderPage.pressNoButton();
        orderPage.pressButtonToOrder();
        orderPage.pressYesButton();
        boolean isOrderCreated = orderPage.isOrderCreated();
        Assert.assertTrue("Order is not created, message not found", isOrderCreated);
    }
}