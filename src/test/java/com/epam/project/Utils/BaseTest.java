package com.epam.project.Utils;

import com.epam.project.Asserts.EmailAssert;
import com.epam.project.Objects.Email;
import com.epam.project.Objects.User;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Iana_Kasimova on 1/23/2018.
 */
public class BaseTest {
    private static final String STARTPAGE = "https://yandex.ru/";

    public WebDriver driver;
    private WebDriverWait wait;
    public UserFactory userFactory;
    public String typeOfUser;
    public User user;
    public EmailAssert emailAssert;
    protected Email email;

    @BeforeClass
    public void setupClass(){
        ChromeDriverManager.getInstance().setup();
        userFactory = new UserFactory();
        emailAssert = new EmailAssert();
        typeOfUser = "simple";
    }

    @BeforeMethod
    public void setupTest(){
        driver = DriverSingletone.getWebDriverInstance();
        driver.get(STARTPAGE);
        driver.manage().window().maximize();
        user = userFactory.createUser(typeOfUser);
        email = new Email(user, "subject", "Hello!", "mikkimous555@gmail.com",driver);
        email.logInEmail();
    }

    @AfterMethod
    public void close(){
        email.logOutFromemail();
    }



    @AfterClass
    public void quit(){
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
