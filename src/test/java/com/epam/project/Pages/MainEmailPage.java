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
public class MainEmailPage extends Page {

    @FindBy(xpath = "//span[text()='Написать']/..")
    private WebElement write;

    @FindBy(xpath = "//span[text()='Черновики']")
    private WebElement drafts;

    @FindBy(xpath = "//span[text()='Отправленные']")
    private WebElement sent;

    public MainEmailPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public CreateEmailPage write(){
        write.click();
        return new CreateEmailPage(driver, wait);
    }

    public DraftEmailPage getDrafts(){
        wait.until(ExpectedConditions.visibilityOf(drafts));
        drafts.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='mikkimous555@gmail.com']")));
        return new DraftEmailPage(driver, wait);
    }

    public SentEmailPage getSentEmail(){
        wait.until(ExpectedConditions.visibilityOf(sent));
        sent.click();
        return new SentEmailPage(driver, wait);
    }

    public String getUrlOfMainPage(){
        return driver.getCurrentUrl();
    }
}
