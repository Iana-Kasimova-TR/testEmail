package com.epam.project.Elements;

import com.epam.project.Pages.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Iana_Kasimova on 1/22/2018.
 */
public class TextBox extends BaseElement{

    public TextBox(WebElement element){
       super(element);
    }

    public void sendKeys(String text){
        this.element.sendKeys(text);
        logger.debug("send " + text);
    }

    public void sendKeysUsingAction(Actions actions, String text){
        actions.sendKeys(text);
        actions.build().perform();
    }

    public String getValue(){
        return this.element.getAttribute("value");
    }

    public void sendKeysByUsingJavascript(JavascriptExecutor executor){
        executor.executeScript("arguments[0].value='Kirtesh';", element);
    }

    public void clear(){
        this.element.clear();
    }

}
