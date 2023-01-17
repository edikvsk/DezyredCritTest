package org.dezyred_test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    //public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //путь к драйверу
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //добавляю вейт 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //беру ссылку на страницу логина из conf.properties
        driver.get(ConfProperties.getProperty("login-page"));
        loginPage = new LoginPage(driver);
        //dashboardPage = new ProfilePage(driver);
    }

    @Test
    public void loginTest() {
        //login/password лежат в conf.properties
        //подтверждаю возраст
        loginPage.clickAgreeBtn();
        //ввожу логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //жму кнопку логина
        loginPage.clickLoginBtn();
        //ввожу пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаю кнопку входа
        loginPage.clickPasswordBtn();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}