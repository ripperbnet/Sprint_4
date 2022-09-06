package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage extends BasePage {

    protected By cookieAcceptButton = By.xpath("//button[text()='да все привыкли']"); // кнопка закрытие окна об использовании куки

    protected By openFirstAccordionPanel = By.id("accordion__heading-0"); // кнопка открытия первого аккордеона

    protected By openSecondAccordionPanel = By.id("accordion__heading-1"); // кнопка открытия второго аккордеона

    protected By openThirdAccordionPanel = By.id("accordion__heading-2"); // кнопка открытия третьего аккордеона

    protected By openFourthAccordionPanel = By.id("accordion__heading-3"); // кнопка открытия чертвертого аккордеона

    protected By openFifthAccordionPanel = By.id("accordion__heading-4"); // кнопка открытия пятого аккордеона

    protected By openSixthAccordionPanel = By.id("accordion__heading-5"); // кнопка открытия шестого аккордеона

    protected By openSeventhAccordionPanel = By.id("accordion__heading-6"); // кнопка открытия седьмого аккордеона

    protected By openEighthAccordionPanel = By.id("accordion__heading-7"); // кнопка открытия восьмого аккордеона

    protected By headerOrderButton = By.xpath("//button[text()='Заказать']"); // кнопка заказа из хэдера

    protected By bigOrderButton = By.xpath("//button['.Button_Button__ra12g.//Button_UltraBig__UU3Lp']"); // большая кнопка заказа

    public MainPage(WebDriver webDriver) {

        super(webDriver);
    }

    public void clickOnCookieAcceptButton() {
        webDriver.findElement(cookieAcceptButton).click();
    }

    public void scrollDownWindow() {
        WebElement element = webDriver.findElement(openEighthAccordionPanel);
        ((JavascriptExecutor)webDriver).executeScript("scroll(0,400)", element);
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(openEighthAccordionPanel));
    }

    public void clickOnFirstAccordionPanel() {
        webDriver.findElement(openFirstAccordionPanel).click();
    }

    public void clickOnSecondAccordionPanel() {
        webDriver.findElement(openSecondAccordionPanel).click();

    }public void clickOnThirdAccordionPanel() {
        webDriver.findElement(openThirdAccordionPanel).click();
    }

    public void clickOnFourthAccordionPanel() {

        webDriver.findElement(openFourthAccordionPanel).click();
    }

    public void clickOnFifthAccordionPanel() {

        webDriver.findElement(openFifthAccordionPanel).click();
    }

    public void clickOnSixthAccordionPanel() {
        webDriver.findElement(openSixthAccordionPanel).click();
    }

    public void clickOnSeventhAccordionPanel() {

        webDriver.findElement(openSeventhAccordionPanel).click();
    }
    public void clickOnEighthAccordionPanel() {

        webDriver.findElement(openEighthAccordionPanel).click();
    }

    public void getTextFromFirstAccordion() {
        webDriver.findElement(openFirstAccordionPanel).getText();
    }

    public void getTextFromSecondAccordion() {

        webDriver.findElement(openSecondAccordionPanel).getText();
    }

    public void getTextFromThirdAccordion() {

        webDriver.findElement(openThirdAccordionPanel).getText();
    }

    public void getTextFromFourthAccordion() {

        webDriver.findElement(openFourthAccordionPanel).getText();
    }

    public void getTextFromFifthAccordion() {

        webDriver.findElement(openFifthAccordionPanel).getText();
    }

    public void getTextFromSixthAccordion() {

        webDriver.findElement(openSixthAccordionPanel).getText();
    }

    public void getTextFromSeventhAccordion() {

        webDriver.findElement(openSeventhAccordionPanel).getText();
    }

    public void getTextFromEighthAccordion() {

        webDriver.findElement(openEighthAccordionPanel).getText();
    }

    public void clickOnHeaderOrderButton() {

        webDriver.findElement(headerOrderButton).click();
    }

    public void clickOnBigOrderButton() {

        webDriver.findElement(bigOrderButton).click();
    }
}
