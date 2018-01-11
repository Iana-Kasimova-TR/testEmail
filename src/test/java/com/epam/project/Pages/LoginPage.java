package com.epam.project.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by anakasimova on 10/01/2018.
 */
public class LoginPage extends Page {

    @FindBy(xpath = "//input[@placeholder='Логин']")
    private WebElement fieldForLogin;

    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private WebElement fieldForPassword;

    @FindBy(xpath = "//span[text()='Войти']/..")
    private WebElement buttonLogin;

    @FindBy(xpath = "//a[@href='https://yandex.ru']")
    private WebElement logoYandex;

    private static final String USERNAME = "janekasimova";
    private static final String PASSWORD = "Qwerty123456";

    public LoginPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public MainEmailPage logIn(){
        fieldForLogin.sendKeys(USERNAME);
        fieldForPassword.sendKeys(PASSWORD);
        buttonLogin.click();
        wait.until(ExpectedConditions.visibilityOf(logoYandex));
        return new MainEmailPage(driver, wait);
    }
}
