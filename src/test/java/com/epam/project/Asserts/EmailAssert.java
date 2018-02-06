package com.epam.project.Asserts;

import com.epam.project.Objects.Email;
import com.epam.project.Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Iana_Kasimova on 1/23/2018.
 */
public class EmailAssert {

    public void checkSuccessfullLogIn(WebDriver driver, WebDriverWait wait){
        MainEmailPage mainEmailPage = new MainEmailPage();
        mainEmailPage.init(driver);
        wait.until(ExpectedConditions.visibilityOf(mainEmailPage.getLogoYandex().element));
        Assert.assertTrue(mainEmailPage.getWrite().isDisplayed(), "log in wasn't successfull");
    }

    public void checkExistanceDraft(String recepient, String subject, String body, WebDriver driver, WebDriverWait wait) {
        DraftEmailPage draftPage = new DraftEmailPage();
        draftPage.init(driver);
        wait.until(ExpectedConditions.visibilityOf(draftPage.getRecipient().element));
        Assert.assertTrue(draftPage.getRecipient().getText().contains(recepient.substring(0, 11)), "recipient of draft isn't correct");
        draftPage.getRecipient().click();
        CreateEmailForm createForm = new CreateEmailForm();
        createForm.init(driver);
        wait.until(ExpectedConditions.visibilityOf(createForm.getSubject().element));
        Assert.assertTrue(createForm.getSubject().getValue().contains(subject), "subject of draft isn't  correct");
        Assert.assertTrue(createForm.getBody().getText().contains(body), "body of draft isn't correct");
    }

    public void checkNonExistenceDraft(WebDriver driver){
        MainEmailPage mainEmailPage = new MainEmailPage();
        mainEmailPage.init(driver);
        mainEmailPage.getDrafts().click();
        driver.navigate().refresh();
        DraftEmailPage draftPage = new DraftEmailPage();
        draftPage.init(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertTrue(draftPage.getEmptyDraftFolder().getText().contains("В папке «Черновики» нет писем."), "email wasn't gone from drafts");
    }

    public void checkExistenceSentEmail(String recepient, WebDriver driver, WebDriverWait wait){
        MainEmailPage mainEmailPage = new MainEmailPage();
        mainEmailPage.init(driver);
        mainEmailPage.getSentEmails().click();
        SentEmailPage sentPage = new SentEmailPage();
        sentPage.init(driver);
        wait.until(ExpectedConditions.visibilityOf(sentPage.getRecipient().element));
        Assert.assertTrue(sentPage.getRecipient().getText().contains(recepient.substring(0, 11)), "email isn't in folder sent");
    }

}
