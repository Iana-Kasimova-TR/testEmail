package com.epam.project.Elements;


import com.epam.project.Pages.Page;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * Created by Iana_Kasimova on 1/23/2018.
 */
public abstract class BaseElement {
    public WebElement element;
    public JavascriptExecutor js;
    public final static Logger logger = Logger.getLogger(Page.class);

    public BaseElement(WebElement element, JavascriptExecutor js) {
        this.element = element;
        this.js = js;
    }

    public boolean isDisplayed() {
        logger.info(element.getText() + " is displayed " + element.isDisplayed());
        return element.isDisplayed();
    }

    public String getText() {
        logger.info("Reading text " + this.element.getText());
        return this.element.getText();
    }


    protected void highlightElement() {
        js.executeScript("arguments[0].style.border='5px solid green'", element);
    }

    protected void unHighlightElement() {
        try {
            js.executeScript("arguments[0].style.border='0px'", element);
        } catch (Exception e) {
            logger.warn("cannot unhighlight element");
        }
    }


}
