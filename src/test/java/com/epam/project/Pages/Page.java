package com.epam.project.Pages;

import com.epam.project.Utils.CustomFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

/**
 * Created by anakasimova on 10/01/2018.
 */
abstract public class Page {

    public void init(WebDriver driver){
        ElementLocatorFactory factory = new DefaultElementLocatorFactory(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        PageFactory.initElements(new CustomFieldDecorator(factory, js), this);
    }


}
