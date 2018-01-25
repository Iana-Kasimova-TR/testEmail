package com.epam.project.Elements;

import com.epam.project.Pages.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

/**
 * Created by Iana_Kasimova on 1/23/2018.
 */
public abstract class BaseElement{
    public WebElement element;
    public final static Logger logger = Logger.getLogger(Page.class);

    public BaseElement(WebElement element){
        this.element = element;
    }

    public boolean isDisplayed(){
        logger.debug(element.getTagName() + " is displayed " + element.isDisplayed());
        return element.isDisplayed();
    }

    public String getText(){
        return this.element.getText();
    }

}
