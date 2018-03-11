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

    public void checkSuccessfullLogIn(Email email){
        MainEmailPage mainEmailPage = new MainEmailPage();
        mainEmailPage.init(email.driver);
        email.wait.until(ExpectedConditions.visibilityOf(mainEmailPage.getLogoYandex().element));
        Assert.assertFalse(mainEmailPage.getWrite().isDisplayed(), "log in wasn't successfull");
    }

    public void checkExistanceDraft(Email email) {
        DraftEmailPage draftPage = new DraftEmailPage();
        draftPage.init(email.driver);
        try {
            email.wait.until(ExpectedConditions.visibilityOf(draftPage.getRecipient().element));
        }catch (Exception e){
            email.driver.navigate().refresh();
        }
        Assert.assertTrue(draftPage.getRecipient().getText().contains(email.recepient.substring(0, 11)), "recipient of draft isn't correct");
        draftPage.getRecipient().click();
        CreateEmailForm createForm = new CreateEmailForm();
        createForm.init(email.driver);
        email.wait.until(ExpectedConditions.visibilityOf(createForm.getSubject().element));
        Assert.assertTrue(createForm.getSubject().getValue().contains(email.subject), "subject of draft isn't  correct");
        Assert.assertTrue(createForm.getBody().getText().contains(email.bodyEmail), "body of draft isn't correct");
    }

    public void checkNonExistenceDraft(Email email){
        MainEmailPage mainEmailPage = new MainEmailPage();
        mainEmailPage.init(email.driver);
        mainEmailPage.getDrafts().click();
        email.driver.navigate().refresh();
        DraftEmailPage draftPage = new DraftEmailPage();
        draftPage.init(email.driver);
        email.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertTrue(draftPage.getEmptyDraftFolder().getText().contains("В папке «Черновики» нет писем."), "email wasn't gone from drafts");
    }

    public void checkExistenceSentEmail(Email email){
        MainEmailPage mainEmailPage = new MainEmailPage();
        mainEmailPage.init(email.driver);
        mainEmailPage.getSentEmails().click();
        SentEmailPage sentPage = new SentEmailPage();
        sentPage.init(email.driver);
        email.wait.until(ExpectedConditions.visibilityOf(sentPage.getRecipient().element));
        Assert.assertTrue(sentPage.getRecipient().getText().contains(email.recepient.substring(0, 11)), "email isn't in folder sent");
    }

}
