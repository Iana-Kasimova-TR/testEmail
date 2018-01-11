package com.epam.project;

import com.epam.project.Pages.CreateEmailPage;
import com.epam.project.Pages.DraftEmailPage;
import com.epam.project.Pages.LoginPage;
import com.epam.project.Pages.MainEmailPage;
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
        logIn(driver, wait);
        writeEmail(driver, wait);
        WebElement reject = getElement(driver, wait, REJECT);
        reject.click();
        WebElement save = getElement(driver, wait, SAVE_IN_DRAFT);
        save.click();
        WebElement drafts = getElement(driver, wait, DRAFT);
        drafts.click();
        WebElement recipientDraft = getElement(driver, wait, RECIPIENT_OF_DRAFT);
        recipientDraft.click();
        WebElement sent = getElement(driver, wait, SENT_EMAIL);
        sent.click();
        drafts = getElement(driver, wait, DRAFT);
        drafts.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LINK_ON_INBOX)));
        Assert.assertTrue(driver.findElements(By.xpath(RECIPIENT_OF_DRAFT)).size() == 0, "email was gone from drafts");
        WebElement sentEmails = driver.findElement(By.xpath(SENT_EMAILS));
        sentEmails.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RECIPIENT_OF_DRAFT)));
        Assert.assertTrue(driver.findElements(By.xpath(RECIPIENT_OF_DRAFT)).size() != 0, "email in folder sent");
        WebElement email = driver.findElement(By.xpath(RECIPIENT_OF_DRAFT));
        email.click();
        delete(driver, wait);
    }


    public void logIn(WebDriver driver, WebDriverWait wait){
        WebElement fieldForLogin = driver.findElement(By.xpath(FIELD_FOR_LOGIN));
        fieldForLogin.sendKeys(USERNAME);
        WebElement fieldForPassword = driver.findElement(By.xpath(FIELD_FOR_PASSWORD));
        fieldForPassword.sendKeys(PASSWORD);
        WebElement buttonLogin = driver.findElement(By.xpath(BUTTON_LOGIN));
        buttonLogin.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGO_YANDEX)));
    }

    public void writeEmail(WebDriver driver, WebDriverWait wait){
        WebElement write = driver.findElement(By.xpath(WRITE_EMAIL));
        write.click();
        WebElement recepient = getElement(driver, wait, RECIPIENT);
        recepient.sendKeys(EMAIL);
        WebElement subject = driver.findElement(By.xpath(SUBJECT));
        subject.sendKeys(SUBJ);
        WebElement body = driver.findElement(By.xpath(BODY));
        Actions actions = new Actions(driver);
        actions.moveToElement(body);
        actions.click();
        actions.sendKeys(BODY_TEXT);
        actions.build().perform();
    }

    public void delete(WebDriver driver, WebDriverWait wait){
        WebElement remove = getElement(driver, wait, REMOVE);
        remove.click();

    }*/

    public WebElement getElement(WebDriver driver, WebDriverWait wait, String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement element = driver.findElement(By.xpath(xpath));
        return element;
    }
}
