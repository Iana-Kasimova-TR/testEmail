package com.epam.project.Pages;

import com.epam.project.Utils.CustomFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by anakasimova on 10/01/2018.
 */
abstract public class Page {

    public void init(WebDriver driver){
        ElementLocatorFactory factory = new DefaultElementLocatorFactory(driver);
        PageFactory.initElements(new CustomFieldDecorator(factory), this);
    }


}
