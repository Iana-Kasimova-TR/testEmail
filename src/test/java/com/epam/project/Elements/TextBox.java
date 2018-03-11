package com.epam.project.Elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Iana_Kasimova on 1/22/2018.
 */
public class TextBox extends BaseElement {

    public TextBox(WebElement element, JavascriptExecutor js) {
        super(element, js);
    }

    public void sendKeys(String text) {
        highlightElement();
        this.element.sendKeys(text);
        unHighlightElement();
        logger.info("input " + text);
    }

    public void sendKeysUsingAction(Actions actions, String text) {
        highlightElement();
        actions.sendKeys(text);
        actions.build().perform();
        unHighlightElement();
        logger.info("input " + text);
    }

    public String getValue() {
        logger.info("read from this element" + element.toString());
        return this.element.getAttribute("value");
    }

    public void clear() {
        this.element.clear();
    }

}
