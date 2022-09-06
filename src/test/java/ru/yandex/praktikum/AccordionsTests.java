package ru.yandex.praktikum;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class AccordionsTests {

    private WebDriver webDriver;

    @Before
    public void setupChrome() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
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
    public void checkFirstAccordionText() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOnCookieAcceptButton();
        mainPage.scrollDownWindow();
        mainPage.clickOnFirstAccordionPanel();
        mainPage.getTextFromFirstAccordion();
        assertTrue(webDriver.findElement(By.id("accordion__panel-0")).getText().contains("Сутки — 400 рублей. Оплата курьеру — наличными или картой."));
    }

    @Test
    public void checkSecondAccordionText() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOnCookieAcceptButton();
        mainPage.scrollDownWindow();
        mainPage.clickOnSecondAccordionPanel();
        mainPage.getTextFromSecondAccordion();
        assertTrue(webDriver.findElement(By.id("accordion__panel-1")).getText().contains("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."));
    }

    @Test
    public void checkThirdAccordionText() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOnCookieAcceptButton();
        mainPage.scrollDownWindow();
        mainPage.clickOnThirdAccordionPanel();
        mainPage.getTextFromThirdAccordion();
        assertTrue(webDriver.findElement(By.id("accordion__panel-2")).getText().contains("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."));
    }

    @Test
    public void checkFourthAccordionText() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOnCookieAcceptButton();
        mainPage.scrollDownWindow();
        mainPage.clickOnFourthAccordionPanel();
        mainPage.getTextFromFourthAccordion();
        assertTrue(webDriver.findElement(By.id("accordion__panel-3")).getText().contains("Только начиная с завтрашнего дня. Но скоро станем расторопнее."));
    }

    @Test
    public void checkFifthAccordionText() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOnCookieAcceptButton();
        mainPage.scrollDownWindow();
        mainPage.clickOnFifthAccordionPanel();
        mainPage.getTextFromFifthAccordion();
        assertTrue(webDriver.findElement(By.id("accordion__panel-4")).getText().contains("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."));
    }

    @Test
    public void checkSixthAccordionText() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOnCookieAcceptButton();
        mainPage.scrollDownWindow();
        mainPage.clickOnSixthAccordionPanel();
        mainPage.getTextFromSixthAccordion();
        assertTrue(webDriver.findElement(By.id("accordion__panel-5")).getText().contains("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."));
    }

    @Test
    public void checkSeventhAccordionText() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOnCookieAcceptButton();
        mainPage.scrollDownWindow();
        mainPage.clickOnSeventhAccordionPanel();
        mainPage.getTextFromSeventhAccordion();
        assertTrue(webDriver.findElement(By.id("accordion__panel-6")).getText().contains("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."));
    }

    @Test
    public void checkEigthAccordionText() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOnCookieAcceptButton();
        mainPage.scrollDownWindow();
        mainPage.clickOnEighthAccordionPanel();
        mainPage.getTextFromEighthAccordion();
        assertTrue(webDriver.findElement(By.id("accordion__panel-7")).getText().contains("Да, обязательно. Всем самокатов! И Москве, и Московской области."));
    }
}
