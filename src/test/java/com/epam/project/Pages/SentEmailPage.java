package com.epam.project.Pages;

import com.epam.project.Elements.Button;
import com.epam.project.Elements.CheckBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by anakasimova on 10/01/2018.
 */
public class SentEmailPage extends Page {

   @FindBy(xpath = "//span[@title='mikkimous555@gmail.com']")
    public Button recipient;

    @FindBy(xpath = "//div[contains(@title,'Удалить')]")
    public Button remove;

    @FindBy(xpath = "//span[contains(@class, 'checkbox')]")
    public CheckBox box;

}
