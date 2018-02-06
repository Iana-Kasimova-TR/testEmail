package com.epam.project.Objects;

import com.epam.project.Pages.*;
import com.epam.project.Utils.UserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Iana_Kasimova on 1/23/2018.
 */
public class Email {
   private User user;
   public String subject;
   public String bodyEmail;
   public String recepient;
   public WebDriver driver;
   public WebDriverWait wait;

    public Email(User user, String subject, String bodyEmail, String recepient, WebDriver driver){
      this.user = user;
      this.subject = subject;
      this.bodyEmail = bodyEmail;
      this.recepient = recepient;
      this.driver = driver;
      this.wait = new WebDriverWait(driver, 120);
    }


    }

