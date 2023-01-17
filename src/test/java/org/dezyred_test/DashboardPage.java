package org.dezyred_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public WebDriver driver;

    //добавляю конструктор класса для инициализации полей класса
    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //локаторы
    @FindBy(xpath = "*[@id=\"dashboard\"]/div/div[1]/div[2]/button")
    private WebElement btnLogOut;

    @FindBy(xpath = "//*[@id=\"dashboard\"]/div/div[1]/div[2]/button/span")
    private WebElement textLogout;

    //методы
    public void clickLogOutBtn() {
        btnLogOut.click();
    }
}
