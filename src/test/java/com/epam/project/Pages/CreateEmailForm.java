package com.epam.project.Pages;

import com.epam.project.Elements.Button;
import com.epam.project.Elements.TextBox;
import com.sun.corba.se.spi.orbutil.fsm.Action;
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
public class CreateEmailForm extends Page{

    @FindBy(xpath = "//div[@class='mail-Compose-Field-Input']/div[@name='to']")
    public TextBox recepient;

    @FindBy(xpath = "//div[@class='mail-Compose-Field-Input']/input[@name='subj']")
    public TextBox subject;

    @FindBy(xpath = "//div[@role='textbox']/div")
    public TextBox body;


    public void fillRecepient(String rec){
        recepient.sendKeys(rec);
    }

    public void fillSubject(String sub){
        subject.sendKeys(sub);
    }

    public void fillBody(Actions action, String bodyText){
        action.moveToElement(body.element);
        action.click();
        body.sendKeysUsingAction(action, bodyText);
    }


}
