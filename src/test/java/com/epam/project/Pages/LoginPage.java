package com.epam.project.Pages;

import com.epam.project.Elements.Button;
import com.epam.project.Elements.TextBox;
import com.epam.project.Objects.User;
import lombok.Data;
import org.openqa.selenium.support.FindBy;

/**
 * Created by anakasimova on 10/01/2018.
 */
@Data
public class LoginPage extends Page{

    @FindBy(xpath = "//input[@placeholder='Логин']")
    private TextBox fieldForLogin;

    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private TextBox fieldForPassword;

    @FindBy(xpath = "//span[text()='Войти']/..")
    private Button buttonLogin;

    public void logIn(User user){
        fieldForLogin.sendKeys(user.getUsername());
        fieldForPassword.sendKeys(user.getPassword());
        buttonLogin.click();
    }



}
