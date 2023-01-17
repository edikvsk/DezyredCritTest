package org.dezyred_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    //добавляю конструктор класса для инициализации полей класса
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //определяю локаторы
    @FindBy(id = "splash-screen__btn-agree")
    private WebElement btnAgree;

    @FindBy(id = "text-field-filled-leading")
    private WebElement loginField;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div[4]/button")
    private WebElement btnLogin;

    @FindBy(id = "text-field-filled-leading")
    private WebElement passwordField;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div[5]/button")
    private WebElement btnPassword;

    //методы
    public void clickAgreeBtn() {
        btnAgree.click();
    }

    public void clickLoginBtn() {
        btnLogin.click();
    }

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        passwordField.sendKeys(passwd);
    }

    public void clickPasswordBtn() {
        btnPassword.click();
    }
}

