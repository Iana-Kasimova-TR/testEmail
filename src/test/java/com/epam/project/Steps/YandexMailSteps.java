package com.epam.project.Steps;

import com.epam.project.Objects.Email;
import com.epam.project.Objects.User;
import com.epam.project.Pages.DraftEmailPage;
import com.epam.project.Pages.LoginPage;
import com.epam.project.Pages.MainEmailPage;
import com.epam.project.Pages.SentEmailPage;
import com.epam.project.Utils.BaseTest;
import com.epam.project.Utils.DriverSingletone;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Iana_Kasimova on 05-Feb-18.
 */
public class YandexMailSteps {

    private static final String STARTPAGE = "https://yandex.ru/";

    @Given("^user navigates to yandex login mail page$")
    public void navigateToLoginpage(){
        BaseTest.driver.get(STARTPAGE);
    }

    @When("^log in mail yandex$")
    public void logInEmail(){
        User user = BaseTest.userFactory.createUser("simple");
        LoginPage loginPage = new LoginPage();
        loginPage.init(BaseTest.driver);
        loginPage.logIn(user);
    }

    @When("^write \"(.*)\" to \"(.*)\" with subject \"(.*)\"$")
    public void createEmail(String body, String recepient, String subject){
        MainEmailPage mainEmailPage = new MainEmailPage();
        mainEmailPage.init(BaseTest.driver);
        BaseTest.wait.until(ExpectedConditions.visibilityOf(mainEmailPage.getLogoYandex().element));
        Email email = new Email(BaseTest.user, subject, body, recepient, BaseTest.driver);
        mainEmailPage.writeEmail(email);
    }

    @When("^send email in draft folder$")
    public void createDraft() {
        MainEmailPage mainEmailPage = new MainEmailPage();
        mainEmailPage.init(BaseTest.driver);
        mainEmailPage.sendToDraft(BaseTest.wait);
    }

    @When("^send draft to recepient$")
    public void sentDraft(){
        DraftEmailPage draftPage = new DraftEmailPage();
        draftPage.init(BaseTest.driver);
        BaseTest.wait.until(ExpectedConditions.visibilityOf(draftPage.getRecipient().element));
        draftPage.getRecipient().click();
        MainEmailPage mainPage = new MainEmailPage();
        mainPage.init(BaseTest.driver);
        BaseTest.wait.until(ExpectedConditions.visibilityOf(mainPage.getSent().element));
        mainPage.sent();
        BaseTest.wait.until(ExpectedConditions.visibilityOf(mainPage.getSuccessfullMsg().element));
    }

    @Then("^user should be on the page of his email$")
    public void checkLogin(){
        BaseTest.emailAssert.checkSuccessfullLogIn(BaseTest.driver, BaseTest.wait);

    }

    @Then("^there must be a letter \"(.*)\" to \"(.*)\" with subject \"(.*)\" in draft folder$")
    public void checkDraftFolder(String body, String recepient, String subject){
        BaseTest.emailAssert.checkExistanceDraft(recepient, subject, body, BaseTest.driver, BaseTest.wait);
        MainEmailPage mainEmailPage = new MainEmailPage();
        mainEmailPage.init(BaseTest.driver);
        BaseTest.wait.until(ExpectedConditions.visibilityOf(mainEmailPage.getRemove().element));
        mainEmailPage.deleteEmail();
    }


    @Then("^there should be no letters in the draft folder$")
    public void checkEmptyDraftFolder(){
        BaseTest.emailAssert.checkNonExistenceDraft(BaseTest.driver);
    }

    @Then("^there must be a letter to \"(.*)\" in sent folder$")
    public void checkSentFolder(String recepient){
        BaseTest.emailAssert.checkExistenceSentEmail(recepient, BaseTest.driver, BaseTest.wait);
        SentEmailPage sentPage = new SentEmailPage();
        sentPage.init(BaseTest.driver);
        sentPage.getBox().check();
        sentPage.getRemove().click();
    }

    @After
    public void close(){
        MainEmailPage mainPage = new MainEmailPage();
        mainPage.init(BaseTest.driver);
        mainPage.logOut(BaseTest.wait);
        BaseTest.wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

}
