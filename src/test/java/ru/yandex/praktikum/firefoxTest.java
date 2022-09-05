package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.html5.WebStorage;
import java.util.concurrent.TimeUnit;

public class firefoxTest {
    private WebDriver mozillaDriver;

    @Before
    public void setUpMozilla() {
        WebDriverManager.firefoxdriver().setup();
        mozillaDriver = new FirefoxDriver();
        mozillaDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mozillaDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void tearDownMozilla() {
        mozillaDriver.manage().deleteAllCookies();
        ((WebStorage) mozillaDriver).getSessionStorage().clear();
        ((WebStorage) mozillaDriver).getLocalStorage().clear();
        mozillaDriver.quit();
    }

    @Test
    public void orderFromMozillaBrowser() {
        MainPage mainPage = new MainPage(mozillaDriver);
        mainPage.clickOnCookieAcceptButton();
        mainPage.clickOnHeaderOrderButton();
        OrderPage orderPage = new OrderPage(mozillaDriver);
        orderPage.typeName("Тестовый");
        orderPage.typeSurname("Клиент");
        orderPage.typeAddress("ул. Тестовая, 1, подъезд1, этаж 1, домофон, 1");
        orderPage.chooseMetroStation();
        orderPage.typePhone("+79993332211");
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
        boolean isOrderCreated = orderPage.isOrderCreated();
        Assert.assertTrue("Order is not created, message not found", isOrderCreated);

    }
}
