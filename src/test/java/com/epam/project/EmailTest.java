package com.epam.project;

import com.epam.project.Pages.*;
import io.github.bonigarcia.wdm.ChromeDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Unit test for simple App.
 */
public class EmailTest {

    WebDriver driver;
    WebDriverWait wait;

    private static final String STARTPAGE = "https://yandex.ru/";
    private static final String LOGIN = "//div[@title='janekasimova@yandex.ru']";
    private static final String EXIT = "//a[text()='Выход']";
    private static final String EMAIL = "mikkimous555@gmail.com";
    private static final String SUBJ = "hello";
    private static final String BODY_TEXT = "hello!";

    @BeforeClass
    public static void setupClass(){
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeMethod
    public void setupTest(){
        driver = new ChromeDriver();
        driver.get(STARTPAGE);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 120);
    }

    @AfterMethod
    public void close(){
        WebElement login = getElement(driver, wait, LOGIN);
        login.click();
        WebElement exit = getElement(driver, wait, EXIT);
        exit.click();
        if(driver != null){
            driver.quit();
        }
    }

    @Test
    public void loginTest() throws Exception{
        LoginPage loginPage = new LoginPage(driver,wait);
        MainEmailPage mainEmailPage = loginPage.logIn();
        Assert.assertTrue(mainEmailPage.getUrlOfMainPage().contains("inbox"), "log in was succesfull");
    }

    @Test
    public void draftTest() throws Exception{
        LoginPage loginPage = new LoginPage(driver,wait);
        MainEmailPage mainEmailPage = loginPage.logIn();
        CreateEmailPage createEmailPage = mainEmailPage.write();
        mainEmailPage =  createEmailPage.createDraft();
        DraftEmailPage draftEmailPage = mainEmailPage.getDrafts();
        Assert.assertTrue(draftEmailPage.recipient.get(0).getText().contains(EMAIL.substring(0, 11)), "recipient of draft is correct");
        createEmailPage = draftEmailPage.getDraftBody();
        Assert.assertTrue(createEmailPage.getValueOfSubject().contains(SUBJ),  "subject of draft is correct");
        Assert.assertTrue(createEmailPage.getTextBody().contains(BODY_TEXT), "body of draft is correct");
        createEmailPage.delete();
    }


    @Test
    public void SentEmailTest() throws Exception{
        LoginPage loginPage = new LoginPage(driver,wait);
        MainEmailPage mainEmailPage = loginPage.logIn();
        CreateEmailPage createEmailPage = mainEmailPage.write();
        mainEmailPage =  createEmailPage.createDraft();
        DraftEmailPage draftEmailPage = mainEmailPage.getDrafts();
        createEmailPage = draftEmailPage.getDraftBody();
        mainEmailPage =  createEmailPage.sentEmail();
        draftEmailPage = mainEmailPage.getDrafts();
        Thread.sleep(50000);//
        Assert.assertTrue(draftEmailPage.recipient.size() == 0, "email was gone from drafts");
        SentEmailPage sentEmailPage = draftEmailPage.getSentEmails();
        wait.until(ExpectedConditions.visibilityOf(sentEmailPage.recipient.get(0)));
        Assert.assertTrue(sentEmailPage.recipient.size() != 0, "email in folder sent");
        createEmailPage = sentEmailPage.getEmail();
        createEmailPage.delete();
    }



    public WebElement getElement(WebDriver driver, WebDriverWait wait, String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement element = driver.findElement(By.xpath(xpath));
        return element;
    }
}
