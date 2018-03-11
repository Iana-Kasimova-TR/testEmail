package com.epam.project.Utils;

import com.epam.project.Asserts.EmailAssert;
import com.epam.project.Objects.Email;
import com.epam.project.Objects.User;
import com.epam.project.Pages.Page;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

/**
 * Created by Iana_Kasimova on 1/23/2018.
 */
public class BaseTest {
    private static final String STARTPAGE = "https://yandex.ru/";
    public final static Logger logger = Logger.getLogger(Page.class);

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
        logger.info("start test ");
        driver.get(STARTPAGE);
        logger.info("navigate to "+ STARTPAGE);
        driver.manage().window().maximize();
        user = userFactory.createUser(typeOfUser);
        email = new Email(user, "subject", "Hello!", "mikkimous555@gmail.com",driver);
        email.logInEmail();
    }

    @AfterMethod
    public void close(){
        email.logOutFromemail();
        logger.info("finish test");
    }

    @AfterMethod
    public void takeScreenshotOfFailureTest(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String screenshotName = "./Screenshots/"+result.getName();
                String scrPath = screenshotName + ".jpg";
                File copy = new File(scrPath);
                FileUtils.copyFile(screenshot, copy);
                logger.info("screenshot have being taken" + result.getName());
            } catch (IOException e) {
                logger.error("Failed to make screenshot");
            }
        }
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
