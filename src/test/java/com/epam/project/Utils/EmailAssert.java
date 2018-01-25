package com.epam.project.Utils;

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
        email.wait.until(ExpectedConditions.visibilityOf(mainEmailPage.logoYandex.element));
        Assert.assertTrue(mainEmailPage.write.isDisplayed(), "log in wasn't successfull");
    }

    public void checkExistanceDraft(Email email) {
        DraftEmailPage draftPage = new DraftEmailPage();
        draftPage.init(email.driver);
        email.wait.until(ExpectedConditions.visibilityOf(draftPage.recipient.element));
        Assert.assertTrue(draftPage.recipient.getText().contains(email.recepient.substring(0, 11)), "recipient of draft isn't correct");
        draftPage.recipient.click();
        CreateEmailForm createForm = new CreateEmailForm();
        createForm.init(email.driver);
        email.wait.until(ExpectedConditions.visibilityOf(createForm.subject.element));
        Assert.assertTrue(createForm.subject.getValue().contains(email.subject), "subject of draft isn't  correct");
        Assert.assertTrue(createForm.body.getText().contains(email.bodyEmail), "body of draft isn't correct");
    }

    public void checkNonExistenceDraft(Email email){
        MainEmailPage mainEmailPage = new MainEmailPage();
        mainEmailPage.init(email.driver);
        mainEmailPage.drafts.click();
        email.driver.navigate().refresh();
        DraftEmailPage draftPage = new DraftEmailPage();
        draftPage.init(email.driver);
        email.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertTrue(draftPage.emptyDraftFolder.getText().contains("В папке «Черновики» нет писем."), "email wasn't gone from drafts");
    }

    public void checkExistenceSentEmail(Email email){
        MainEmailPage mainEmailPage = new MainEmailPage();
        mainEmailPage.init(email.driver);
        mainEmailPage.sentEmails.click();
        SentEmailPage sentPage = new SentEmailPage();
        sentPage.init(email.driver);
        email.wait.until(ExpectedConditions.visibilityOf(sentPage.recipient.element));
        Assert.assertTrue(sentPage.recipient.getText().contains(email.recepient.substring(0, 11)), "email isn't in folder sent");
    }

}
