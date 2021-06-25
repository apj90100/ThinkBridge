package com.tb.test;

import org.testng.annotations.Test;

import com.tb.ObjectRepo.Bean;

import static org.testng.Assert.fail;

import java.awt.Label;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestScenario {
 

	// creating WebDriver object
		public static WebDriver driver;
		
		//object creation for Bean class
		Bean bean = null;
		
		//application url is saved in a string
		private String url = "https://jt-dev.azurewebsites.net/#/SignUp";
		
		//BrowserDriver Location
		private String driverLocation= System.getProperty("user.dir") + "\\" + "browserDriver" + "\\" + "chromedriver.exe";
			
		@BeforeTest
		public void setUpStep() throws InterruptedException{
			//Set the path for ChromeDriver
			System.setProperty("webdriver.chrome.driver",driverLocation);
			//Initiate new driver
			driver = new ChromeDriver();
			bean = new Bean(driver);
			// Launch Website
			driver.get(url);
			// Maximize the browser
			driver.manage().window().maximize();
			
			
		}
		
		@AfterTest
	    public void CloseDriver(){
			//Close the browser
	        driver.close();
	    }

		
		@Test(priority = 1)
		public void Test1() throws InterruptedException{
			

			//Expected Title
			String expectedTitle = "Jabatalks";
			//Get Actual Title
			String actualTitle = driver.getTitle();
			//Verify the Website title
			Assert.assertEquals(expectedTitle, actualTitle);
			
			bean.language.click();
			
			List <WebElement> languages=driver.findElements(By.xpath("//div[contains(@id,'ui-select-choices-row-1-')]"));
			//Loop through dropdown values and verify
			for(int i=0; i<languages.size(); i++) {
				String lang=languages.get(i).getText();
				System.out.println(lang);
				if(!(lang.contains("English") || lang.contains("Dutch"))) {
					fail("Languages do not match from dropdown");
				}
			}
			
			bean.name.sendKeys("Appaji");
			bean.organisation.sendKeys("CG");
			bean.Emailid.sendKeys("apj9010@gmail.com");
			bean.label.click();
			bean.submit.click();
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			String actualmsg = bean.actualMsg.getText();
			String expectedMessage = "A welcome email has been sent. Please check your email.";
			//Validate the message
			Assert.assertEquals(expectedMessage, actualmsg);
						
			
		}	
}
			
			