package com.epam.project.Pages;

import com.epam.project.Elements.Button;
import com.epam.project.Elements.Image;
import com.epam.project.Objects.Email;
import com.sun.corba.se.spi.orbutil.fsm.Action;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by anakasimova on 10/01/2018.
 */
@Data
public class MainEmailPage extends Page{

    @FindBy(xpath = "//span[text()='Написать']/..")
    private Button write;

    @FindBy(xpath = "//a[@href='https://yandex.ru']")
    private Image logoYandex;

    @FindBy(xpath = "//div[@title='Закрыть']")
    private Button reject;

    @FindBy(xpath = "//span[text()='Сохранить и перейти']")
    private Button saveInDraft;

    @FindBy(xpath = "//div[contains(@title,'Удалить')]")
    private Button remove;

    @FindBy(xpath = "//span[text()='Отправить']")
    private Button sent;

    @FindBy(xpath = "//span[text()='Черновики']")
    private Button drafts;

    @FindBy(xpath = "//span[text()='Отправленные']")
    private Button sentEmails;

    @FindBy(xpath = "//div[text()='Письмо отправлено']")
    private Image successfullMsg;

    @FindBy(xpath = "//div[@title='janekasimova@yandex.ru']")
    private Button profile;

    @FindBy(xpath = "//a[text()='Выход']")
    private Button exit;

    public void writeEmail(Email email){
       write.click();
       CreateEmailForm form = new CreateEmailForm();
       form.init(email.driver);
       email.wait.until(ExpectedConditions.visibilityOf(form.getRecepient().element));
       form.fillRecepient(email.recepient);
       email.wait.until(ExpectedConditions.visibilityOf(form.getSubject().element));
       form.fillSubject(email.subject);
       email.wait.until(ExpectedConditions.visibilityOf(form.getBody().element));
       form.fillBody(new Actions(email.driver), email.bodyEmail);
    }

    public void sendToDraft(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(reject.element));
        reject.click();
        wait.until(ExpectedConditions.visibilityOf(saveInDraft.element));
        saveInDraft.click();
        wait.until(ExpectedConditions.visibilityOf(drafts.element));
        drafts.click();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'mail-MessageSnippet')]")));
        }catch(Exception e){
            drafts.logger.error("there is no drafts");
        }
    }

    public void deleteEmail(){
        remove.click();
    }

    public void sent(){
        sent.click();
    }

    public void logOut(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(profile.element));
        profile.click();
        wait.until(ExpectedConditions.visibilityOf(exit.element));
        exit.click();
    }
}
