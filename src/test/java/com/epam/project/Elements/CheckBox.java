package com.epam.project.Elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * Created by Iana_Kasimova on 1/25/2018.
 */
public class CheckBox extends BaseElement {
    public CheckBox(WebElement element, JavascriptExecutor js) {
        super(element, js);
    }

    public void check() {
        logger.debug("check  " + element.getText());
        highlightElement();
        element.click();
        unHighlightElement();
    }
}
