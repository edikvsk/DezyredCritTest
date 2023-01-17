package org.dezyred_test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //путь к драйверу
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //добавляю вейт
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //беру ссылку на страницу логина из conf.properties
        driver.get(ConfProperties.getProperty("login-page"));
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
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
        //нахожу тайтл
        String title = driver.getTitle();
        //сравниваю найденный тайтл с шаблоном
        Assert.assertTrue(title.equals("Login to Dezyred - World of The Hottest VR Porn Games | Dezyred"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}