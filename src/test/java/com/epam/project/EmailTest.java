package com.epam.project;

import com.epam.project.Elements.Button;
import com.epam.project.Objects.Email;
import com.epam.project.Pages.*;
import com.epam.project.Utils.BaseTest;
import com.epam.project.Utils.CustomFieldDecorator;
import io.github.bonigarcia.wdm.ChromeDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Unit test for simple App.
 */
public class EmailTest extends BaseTest{


    @Test
    public void testLogIn(){
        emailAssert.checkSuccessfullLogIn(email);
    }

    @Test
    public void draftTest(){
        email.createDraft();
        emailAssert.checkExistanceDraft(email);
        email.deleteEmail();

    }


    @Test
    public void sentTest(){
        email.createDraft();
        email.sentDraft();
        emailAssert.checkNonExistenceDraft(email);
        emailAssert.checkExistenceSentEmail(email);
        email.deleteSentEmail();
    }

}
