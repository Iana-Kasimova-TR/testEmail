package com.epam.project.Objects;

import com.epam.project.Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Iana_Kasimova on 1/23/2018.
 */
public class Email {
   private User user;
   public String subject;
   public String bodyEmail;
   public String recepient;
   public WebDriver driver;
   public WebDriverWait wait;

    public Email(User user, String subject, String bodyEmail, String recepient, WebDriver driver){
      this.user = user;
      this.subject = subject;
      this.bodyEmail = bodyEmail;
      this.recepient = recepient;
      this.driver = driver;
      wait = new WebDriverWait(driver, 120);
    }

    public void logInEmail(){
        LoginPage loginPage = new LoginPage();
        loginPage.init(driver);
        loginPage.logIn(this.user);
    }

    public void createDraft() {
        MainEmailPage mainEmailPage = new MainEmailPage();
        mainEmailPage.init(driver);
        wait.until(ExpectedConditions.visibilityOf(mainEmailPage.logoYandex.element));
        mainEmailPage.writeEmail(this);
        mainEmailPage.sendToDraft(this);
    }


    public void deleteEmail() {
        MainEmailPage mainEmailPage = new MainEmailPage();
        mainEmailPage.init(driver);
        wait.until(ExpectedConditions.visibilityOf(mainEmailPage.remove.element));
        mainEmailPage.deleteEmail();
    }

    public void deleteSentEmail(){
        SentEmailPage sentPage = new SentEmailPage();
        sentPage.init(driver);
        sentPage.box.check();
        sentPage.remove.click();
    }

    public void sentDraft(){
        DraftEmailPage draftPage = new DraftEmailPage();
        draftPage.init(this.driver);
        wait.until(ExpectedConditions.visibilityOf(draftPage.recipient.element));
        draftPage.recipient.click();
        sentEmail();
    }

    public void sentEmail(){
        MainEmailPage mainPage = new MainEmailPage();
        mainPage.init(driver);
        wait.until(ExpectedConditions.visibilityOf(mainPage.sent.element));
        mainPage.sent();
        wait.until(ExpectedConditions.visibilityOf(mainPage.successfullMsg.element));
    }

    }

