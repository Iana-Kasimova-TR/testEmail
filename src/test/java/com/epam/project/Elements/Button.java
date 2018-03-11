package com.epam.project.Elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Iana_Kasimova on 1/22/2018.
 */
public class Button extends BaseElement {
    public Button(WebElement element, JavascriptExecutor js) {
        super(element, js);
    }

    public void click() {
        logger.info("click on " + element.getText());
        highlightElement();
        element.click();
        unHighlightElement();
    }

    public void clickUsingActions(Actions actions) {
        logger.info("click on " + element.getText());
        highlightElement();
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();
        unHighlightElement();
    }


}
