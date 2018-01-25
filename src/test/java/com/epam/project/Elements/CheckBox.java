package com.epam.project.Elements;

import org.openqa.selenium.WebElement;

/**
 * Created by Iana_Kasimova on 1/25/2018.
 */
public class CheckBox extends BaseElement {
    public CheckBox(WebElement element) {
        super(element);
    }

    public void check(){
        logger.debug("click on " + element.getText());
        element.click();
    }
}
