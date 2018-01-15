package com.epam.project.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/**
 * Created by anakasimova on 10/01/2018.
 */
public class DraftEmailPage extends Page {

    @FindBy(xpath = "//span[text()='Черновики']")
    private WebElement drafts;


    //TODO:Custom annotation with variable xpath
    @FindAll({@FindBy(xpath = "//span[@title='mikkimous555@gmail.com']")})
    public List<WebElement> recipient;

    @FindBy(xpath = "//div[@class='mail-Compose-Field-Input']/input[@name='subj']")
    private WebElement subject;

    @FindBy(xpath = "//div[@role='textbox']/div")
    private WebElement body;

    @FindBy(xpath = "//div[contains(@title, 'Удалить')]")
    private WebElement remove;

    @FindBy(xpath = "//span[text()='Отправленные']")
    private WebElement sent;


    public DraftEmailPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    private static final String SAVE_IN_DRAFT = "//span[text()='Сохранить и перейти']";
    private static final String REMOVE = "//div[contains(@title, 'Удалить')]";
    private static final String SENT_EMAIL = "//span[text()='Отправить']";
    private static final String SENT_EMAILS = "//span[text()='Отправленные']";
    private static final String LINK_ON_INBOX = "//a[contains(text(), 'Входящие')]";


    public String getRecipient(){
        wait.until(ExpectedConditions.visibilityOf(recipient.get(0)));
        return recipient.get(0).getText();
    }

    public CreateEmailPage getDraftBody(){
        recipient.get(0).click();
        return new CreateEmailPage(driver, wait);
    }

    public SentEmailPage getSentEmails(){

        sent.click();
        return new SentEmailPage(driver, wait);
    }
}
