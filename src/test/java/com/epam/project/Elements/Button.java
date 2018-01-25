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
public class Button extends BaseElement{
    public Button(WebElement element){
        super(element);
    }

    public void click(){
        logger.debug("click on " + element.getText());
        element.click();
    }

    public void clickUsingActions(Actions actions){
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();
    }

    public void clickUsingExecutor(JavascriptExecutor executor){
        logger.debug("Clicking on element with using java script click");
        executor.executeScript("arguments[0].click();", element);
    }

}
