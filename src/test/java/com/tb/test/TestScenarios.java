package com.tb.test;

import org.testng.annotations.Test;

import com.tb.Resolver.Bean;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestScenarios {
 

	// creating WebDriver object
		public static WebDriver driver;
		
		//object creation for Bean class
		Bean bean = null;
		
		//application url is saved in a string
		private String url = "file:///C:/Users/apj007/Downloads/AutomationChallengeIDC/index.html";
		
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

		
		@Test(enabled = false)
		public void Test1() throws InterruptedException{
			
			bean.openModel.click();
			bean.wait1();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			bean.name.sendKeys("Resolver");
			bean.city.sendKeys("Hyderabad");
			bean.enter.click();
			bean.close.click();
			
		   //Expected name
			String nameVerifyExpected = "Resolver";
			//Get Actual name
			String nameVerifyActual = bean.nameVerify.getText();
			Assert.assertEquals(nameVerifyActual, nameVerifyExpected);
			
			//Expected city
			String cityVerifyExpected = "Hyderabad";
			//Get Actual city
			String cityVerifyActual = bean.cityVerify.getText();
			//Verify 
			Assert.assertEquals(cityVerifyActual, cityVerifyExpected);
			
			
		}
		
		@Test(enabled = false)
		public void Test2() throws InterruptedException{
			
			bean.dropdown(); 
			bean.angular();		
		}
		
		
		@Test(enabled = false)
		public void Test3() throws InterruptedException{
			
		bean.USA();
				
		}
		
		@Test(enabled = false)
		public void Test4() throws InterruptedException{
			
		bean.DragMe();
					
		}
		
		@Test(enabled = false)
		public void Test5() throws InterruptedException{
			
		bean.print();
					
		}
		
		
		@Test(priority = 1)
		public void Test6() throws InterruptedException{
			
		bean.print();
					
		}
		
}
		
