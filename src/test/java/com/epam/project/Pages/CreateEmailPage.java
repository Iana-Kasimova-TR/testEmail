package com.epam.project.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by anakasimova on 10/01/2018.
 */
public class CreateEmailPage extends Page {

   @FindBy(xpath = "//div[@class='mail-Compose-Field-Input']/div[@name='to']")
    private WebElement recepient;

   @FindBy(xpath = "//div[@class='mail-Compose-Field-Input']/input[@name='subj']")
    private WebElement subject;

   @FindBy(xpath = "//div[@role='textbox']/div")
    private WebElement body;

    @FindBy(xpath = "//div[@title='Закрыть']")
    private WebElement reject;

    @FindBy(xpath = "//span[text()='Сохранить и перейти']")
    private WebElement saveInDraft;

    @FindBy(xpath = "//div[contains(@title, 'Удалить')]")
    private WebElement remove;

    private static final String EMAIL = "mikkimous555@gmail.com";
    private static final String SUBJ = "hello";
    private static final String BODY_TEXT = "hello!";

    public CreateEmailPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void createEmail(){
        wait.until(ExpectedConditions.visibilityOf(recepient));
        recepient.sendKeys(EMAIL);
        subject.sendKeys(SUBJ);
        Actions actions = new Actions(driver);
        actions.moveToElement(body);
        actions.click();
        actions.sendKeys(BODY_TEXT);
        actions.build().perform();
    }

    public MainEmailPage createDraft(){
        createEmail();
        wait.until(ExpectedConditions.visibilityOf(reject));
        reject.click();
        wait.until(ExpectedConditions.visibilityOf(saveInDraft));
        saveInDraft.click();
        return new MainEmailPage(driver, wait);
    }

    public String getValueOfSubject(){
        wait.until(ExpectedConditions.visibilityOf(subject));
        return subject.getAttribute("value");
    }

    public String getTextBody(){
        return body.getText();
    }

    public  void delete(){
        remove.click();
    }
}
