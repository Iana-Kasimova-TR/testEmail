package com.epam.project.Pages;

import com.epam.project.Elements.Button;
import com.epam.project.Elements.Image;
import com.epam.project.Objects.Email;
import com.sun.corba.se.spi.orbutil.fsm.Action;
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
public class MainEmailPage extends Page{

    @FindBy(xpath = "//span[text()='Написать']/..")
    public Button write;

    @FindBy(xpath = "//a[@href='https://yandex.ru']")
    public Image logoYandex;

    @FindBy(xpath = "//div[@title='Закрыть']")
    public Button reject;

    @FindBy(xpath = "//span[text()='Сохранить и перейти']")
    public Button saveInDraft;

    @FindBy(xpath = "//div[contains(@title,'Удалить')]")
    public Button remove;

    @FindBy(xpath = "//span[text()='Отправить']")
    public Button sent;

    @FindBy(xpath = "//span[text()='Черновики']")
    public Button drafts;

    @FindBy(xpath = "//span[text()='Отправленные']")
    public Button sentEmails;

    @FindBy(xpath = "//div[text()='Письмо отправлено']")
    public Image successfullMsg;

    public void writeEmail(Email email){
       write.click();
       CreateEmailForm form = new CreateEmailForm();
       form.init(email.driver);
       email.wait.until(ExpectedConditions.visibilityOf(form.recepient.element));
       form.fillRecepient(email.recepient);
       email.wait.until(ExpectedConditions.visibilityOf(form.subject.element));
       form.fillSubject(email.subject);
       email.wait.until(ExpectedConditions.visibilityOf(form.body.element));
       form.fillBody(new Actions(email.driver), email.bodyEmail);
    }

    public void sendToDraft(Email email){
        email.wait.until(ExpectedConditions.visibilityOf(reject.element));
        reject.click();
        email.wait.until(ExpectedConditions.visibilityOf(saveInDraft.element));
        saveInDraft.click();
        email.wait.until(ExpectedConditions.visibilityOf(drafts.element));
        drafts.click();
        try {
            email.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='" + email.recepient + "']")));
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


}
