package org.dezyred_test.tests;

import org.dezyred_test.ConfProperties;
import org.dezyred_test.StringsProperties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.dezyred_test.page_objects.DashboardPage;
import org.dezyred_test.page_objects.LoginPage;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class LoginTest {
    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static WebDriver driver;

    private static Logger log = Logger.getLogger(LoginTest.class.getName());
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
        //проверяю отображение предупреждения о возрастном ограничении
        String agreementText = loginPage.getAgreementText();
        Assert.assertEquals(agreementText, StringsProperties.getProperty("agreementText"));
        //подтверждаю возраст
        loginPage.clickAgreeBtn();
        //проверяю что открыта страница логина
        String loginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginPageUrl, ConfProperties.getProperty("login-page"));
        //ввожу логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //жму кнопку логина
        loginPage.clickLoginBtn();
        //ввожу пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаю кнопку входа
        loginPage.clickPasswordBtn();
        //проверяю что открыта страница dashboard
        String title = driver.getTitle();
        Assert.assertEquals(title, ("Login to Dezyred - World of The Hottest VR Porn Games | Dezyred"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}