package com.selftechy.parameterization;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class AdvancedSearch  {
    public static void main(String[] args) {
        // Create a new instance of the html unit driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.cssSelector("input.gbqfif"));
        
        // Enter something to search for
        element.sendKeys("Hello World!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the window handle of the page
        System.out.println("Page title is: " + driver.getTitle());
    }
}