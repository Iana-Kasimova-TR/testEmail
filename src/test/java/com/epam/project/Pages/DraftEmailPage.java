package com.epam.project.Pages;

import com.epam.project.Elements.Button;
import com.epam.project.Elements.Image;
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

    @FindBy(xpath = "//span[@title='mikkimous555@gmail.com']")
    public Button recipient;

    @FindBy(xpath = "//div[text()='В папке «Черновики» нет писем.']")
    public Image emptyDraftFolder;

}