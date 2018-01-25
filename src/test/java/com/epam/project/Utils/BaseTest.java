package com.epam.project.Utils;

import com.epam.project.Objects.Email;
import com.epam.project.Objects.User;
import com.epam.project.Pages.LoginPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Iana_Kasimova on 1/23/2018.
 */
public class BaseTest {
    private static final String STARTPAGE = "https://yandex.ru/";

    public WebDriver driver;
    private WebDriverWait wait;
    public User user;
    public EmailAssert emailAssert;
    protected Email email;

    @BeforeClass
    public void setupClass(){
        ChromeDriverManager.getInstance().setup();
        user = new User( "janekasimova", "Qwerty123456");
        emailAssert = new EmailAssert();
    }

    @BeforeMethod
    public void setupTest(){
        driver = new ChromeDriver();
        driver.get(STARTPAGE);
        driver.manage().window().maximize();
        email = new Email(user, "subject", "Hello!", "mikkimous555@gmail.com",driver);
        email.logInEmail();
    }

    @AfterMethod
    public void close(){
        if(driver != null){
            driver.quit();
        }
    }

    //Here run tests by RemoteWebDriver
    /*@BeforeMethod
    public void setupRemotetest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Iana_Kasimova\\Documents\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.WINDOWS);
        try {
            String hubHost = "localhost";
            driver = new RemoteWebDriver(new URL("http://" + hubHost + ":5555/wd/hub"), capabilities);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
    }*/

}
