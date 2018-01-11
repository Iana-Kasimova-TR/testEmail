package com.epam.project.Pages;

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

    @FindAll({@FindBy(xpath = "//span[@title='mikkimous555@gmail.com']")})
    List<WebElement> recipient;

    @FindBy(xpath = "//div[contains(@title, 'Удалить')]")
    private WebElement remove;

    public SentEmailPage(WebDriver driver, WebDriverWait wait){
        super(driver,wait);
    }

    public  void delete(){
        remove.click();
    }

}
