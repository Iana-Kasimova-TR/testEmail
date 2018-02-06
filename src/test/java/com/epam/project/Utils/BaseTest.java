package com.epam.project.Utils;

import com.epam.project.Asserts.EmailAssert;
import com.epam.project.Objects.Email;
import com.epam.project.Objects.User;
import com.epam.project.Pages.MainEmailPage;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Iana_Kasimova on 1/23/2018.
 */
@CucumberOptions(strict = true, plugin = { "pretty","html: cucumber-html-reports", "json: cucumber-html-reports/cucumber.json" }, features = "src/test/resources/features/", glue = {"com.epam.project"})
public class BaseTest extends AbstractTestNGCucumberTests {

    public static WebDriver driver;
    public static UserFactory userFactory;
    public static WebDriverWait wait;;
    public static User user;
    public static EmailAssert emailAssert;
    protected Email email;

    @BeforeClass
    public void setupClass(){
        ChromeDriverManager.getInstance().setup();
        userFactory = new UserFactory();
        emailAssert = new EmailAssert();
        driver = DriverSingletone.getWebDriverInstance();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 120);
        user = BaseTest.userFactory.createUser("simple");
    }

    @AfterClass
    public void quit(){
        if(driver != null){
            driver.quit();
        }
    }

}
