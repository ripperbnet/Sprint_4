package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage {

    private By nameField = By.xpath("//input[@placeholder='* Имя']"); // поле ввода имени

    private By surnameField = By.xpath("//input[@placeholder='* Фамилия']"); // поле ввода фамилии

    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']"); // поле ввода адреса

    private By metroStationField = By.xpath("//input[@class='select-search__input']"); // поле выбора метро

    private By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']"); // поле ввода телефона

    private By continueButton = By.xpath("//button[text()='Далее']"); // кнопка далее

    private By dateField = By.xpath("//input[@placeholder='* Когда привезти самокат']"); // кнопка открытия календаря

    private By dayInCalendar = By.cssSelector(".react-datepicker__day--001"); // выбор дня

    private By rentalPeriodOpen = By.className("Dropdown-placeholder"); // открытие списка периодов доставки

    private By rentalPeriodDropDown = By.xpath("//div[text()='сутки']"); // период "сутки"

    private By colorOfScooterBlack = By.id("black"); // чекбокс черного цвета

    private By colorOfScooterGrey = By.id("grey"); // чекбокс серого цвета

    private By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']"); // поле кометария для курьера

    private By finalOrderButton = By.cssSelector("[class='Button_Button__ra12g Button_Middle__1CSJM']"); // кнопка продолжения заказа

    private By yesButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][text()='Да']"); // кнопка "Да"

    private By noButton = By.xpath("//button[text()='Нет']"); // кнопка "Нет"

    private By orderCreatedMessage = By.xpath("//button[text()='Посмотреть статус']"); // Кнопка с надписью "Посмотреть статус"

    public OrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void setName(String name) {

        webDriver.findElement(nameField).sendKeys(name);
    }

    public void setSurname(String surname) {

        webDriver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddress(String address) {

        webDriver.findElement(addressField).sendKeys(address);
    }

    public void setPhone(String phone) {

        webDriver.findElement(phoneField).sendKeys(phone);
    }

    public void chooseMetroStation() {
        webDriver.findElement(metroStationField).click();
        webDriver.findElement(By.className("select-search__select")).click();
    }


    public void clickOnContinueButton() {

        webDriver.findElement(continueButton).click();
    }

    public void clickOnDateField() {

        webDriver.findElement(dateField).click();
    }

    public void chooseDay() {

        webDriver.findElement(dayInCalendar).click();
    }

    public void chooseRentalPeriod() {
        webDriver.findElement(rentalPeriodOpen).click();
        webDriver.findElement(rentalPeriodDropDown).click();
    }

    public void chooseColorBlack() {

        webDriver.findElement(colorOfScooterBlack).click();
    }

    public void chooseColorGrey() {
        webDriver.findElement(colorOfScooterGrey).click();

    }

    public void setCommentForCourier(String comment) {

        webDriver.findElement(commentField).sendKeys(comment);
    }

    public void pressButtonToOrder() {

        webDriver.findElement(finalOrderButton).click();
    }

    public void pressNoButton() {
        webDriver.findElement(noButton).click();
    }

    public void pressYesButton() {
        webDriver.findElement(yesButton).click();
    }

    public boolean isOrderCreated() {

        return webDriver.findElement(orderCreatedMessage).isDisplayed();
    }

    public void customerDate(String name, String surname, String address, String phone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setPhone(phone);
    }
}