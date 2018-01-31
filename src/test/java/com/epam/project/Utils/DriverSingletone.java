package com.epam.project.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Iana_Kasimova on 31-Jan-18.
 */
public class DriverSingletone {
    private static WebDriver driver;

    private DriverSingletone(){

    }

    public static WebDriver getWebDriverInstance(){
        if(driver == null){
           driver = new ChromeDriver();
        }

        return driver;
    }
}
