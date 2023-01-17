package org.dezyred_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public WebDriver driver;

    //добавляю конструктор класса для инициализации полей класса
    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
