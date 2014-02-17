package com.selftechy.parameterization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AutoApplication {
	
	public static void main(String[] args) throws InterruptedException {
          AutoApplication xpanxionApp = new AutoApplication();
          WebDriver driver = new FirefoxDriver();
          
          // navigates to the application form
          xpanxionApp.Navigation(driver);
          
          // fills in and submits the form
          xpanxionApp.fillFormSubmit(driver);
    }
	
	private void Navigation(WebDriver driver) throws InterruptedException {
        
        // And now use this to visit the Xpanxion website
        driver.get("http://www.xpanxion.com");

        // Find and click on the Careers tab
        driver.findElement(By.linkText("Careers")).click();
        
        // Look for US opportunities
        driver.findElement(By.linkText("Job Opportunities – US")).click();
        
        // Wait a bit for the page to load fully
        Thread.sleep(1000);
        
        // Select the desired opportunity - Automation Developer
        driver.switchTo().frame("resumator-job-frame");
        driver.findElement(By.cssSelector("a[href*='/details/BryRgU?']")).click();
        
        // Proceed to the online application
        driver.findElement(By.linkText("Apply Now")).click(); 
	}
	
	private void fillFormSubmit(WebDriver theDriver) {
		WebElement firstName = theDriver.findElement(By.id("resumator-firstname-value"));
		firstName.sendKeys("Austin");

		WebElement lastName = theDriver.findElement(By.id("resumator-lastname-value"));
		lastName.sendKeys("Redick");
		
		WebElement emailAddr = theDriver.findElement(By.id("resumator-email-value"));
		emailAddr.sendKeys("aredick@xpanxion.com");
		
		WebElement phoneNum = theDriver.findElement(By.id("resumator-phone-value"));
		phoneNum.sendKeys("7082806832");
		
		theDriver.findElement(By.id("resumator-choose-upload")).click();
		theDriver.findElement(By.id("resumator-resume-value")).sendKeys("/home/austin/Documents/fake_resume.pdf");
		
		WebElement city = theDriver.findElement(By.id("resumator-questionnaire-q39409"));
		city.sendKeys("Grinnell");
		
		WebElement state = theDriver.findElement(By.id("resumator-questionnaire-q39410"));
		state.sendKeys("Iowa");
		
		WebElement availabilityDropDownListBox = theDriver.findElement(By.id("resumator-questionnaire-q39560"));
		Select clickThisAvailability = new Select(availabilityDropDownListBox);
		clickThisAvailability.selectByValue("Immediate");
		
		WebElement salary = theDriver.findElement(By.id("resumator-questionnaire-q39433"));
		salary.sendKeys("10000000000000000000000");
		
		WebElement relocationDropDownListBox = theDriver.findElement(By.id("resumator-questionnaire-q39435"));
		Select clickThisRelocation = new Select(relocationDropDownListBox);
		clickThisRelocation.selectByValue("Yes");
		
		WebElement eligibilityDropDownListBox = theDriver.findElement(By.id("resumator-questionnaire-q39436"));
		Select clickThisEligibility = new Select(eligibilityDropDownListBox);
		clickThisEligibility.selectByValue("I am a US citizen / permanent resident");
		
		WebElement anythingElse = theDriver.findElement(By.id("resumator-questionnaire-q39411"));
		anythingElse.sendKeys("I'm pretty awesome.");
		
		//theDriver.findElement(By.id("resumator-submit-resume")).click();
	}
}
