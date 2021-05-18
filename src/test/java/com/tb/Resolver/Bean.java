package com.tb.Resolver;

import static org.junit.Assert.fail;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Bean {

	private WebDriver driver;
	 
	//This initElements method will create all WebElements
	public Bean(WebDriver driver){
        this.driver = driver;
        
        PageFactory.initElements(driver, this);
    }  
	
	@FindBy(xpath="//span[@class='black-color ng-binding']")
	public WebElement TCs;
	
	
	
	@FindBy(xpath="//button[text()='Open Modal']")
	public WebElement openModel;
	
	@FindBy(id="name")
	public WebElement name;
	
	
	@FindBy(id="city")
	public WebElement city;
	
			
	@FindBy(id="enter")
	public WebElement enter;
	
	@FindBy(xpath="//button[text()='Close']")
	public WebElement close;
	
	@FindBy(id="nameVal")
	public WebElement nameVerify;
	
	@FindBy(id="cityVal")
	public WebElement cityVerify;
	
	
	//Test2
	
	@FindBy(xpath="//button[contains(text(),\"Click Me!\")]")
	public WebElement clickme;
	
	
	public void wait1()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@FindBy(xpath="//li[text()='Angular 2']")
	public WebElement angular2;
	
	@FindBy(xpath="//li[text()='Angular']")
	public WebElement angular;
	
	@FindBy(xpath="//li[text()='Angular']")
	public WebElement reactJs;
	
	 
	 @FindBy(id="myInput")
	 public WebElement searchBox;
	
	 public void dropdown() {
		 
		 String arr[] = {"Java", "C#", "Python", "Angular 2", "Angular"};
		 clickme.click();
		
		 List s = driver.findElements(By.xpath("//input[@class=\"form-control\"]//following::li"));
	     int size = s.size();
	     for(int i =0; i<size ; i++){
	     String options = ((WebElement) s.get(i)).getText();
	     System.out.println(options);
	      
	      Assert.assertEquals(arr[i], ((WebElement) s.get(i)).getText());
	 } 
	      
	  
	 }
	 
	 public void angular() {
		  
		 searchBox.sendKeys("Angular");
		 angular2.isDisplayed();
		 angular.isDisplayed();
		 
		searchBox.clear();
		searchBox.sendKeys("ReactJs");
		
		String ReactJs = "ReactJs";
		List s = driver.findElements(By.xpath("//input[@class=\"form-control\"]//following::li"));
	     int size = s.size();
	     for(int i =0; i<size ; i++){
	     String options = ((WebElement) s.get(i)).getText();
	     
	     if(ReactJs.equalsIgnoreCase(options))
	     {
	    	 System.out.println("Option Available");
	     }
	    
	     }  
	     
	     System.out.println("ReactJs option is not avaialble");
	  }
	 
	 
	
	 //Test3
	 
	 @FindBy(id="searchMe")
		public WebElement searchMe;
	 
	 @FindBy(xpath="//table/tbody/tr")
		public WebElement table;
	 
	 @FindBy(xpath="//table//tr[1]/td[3]")
		public WebElement USA1;
	 
	 @FindBy(xpath="//table//tr[2]/td[3]")
		public WebElement USA2;
	 
	 @FindBy(xpath="//table[@class=\"table table-bordered table-striped\"]/tbody/tr")
		public WebElement table4;
	 
	 public void USA() {
		 
		searchMe.sendKeys("USA");
		
		
		
	    USA1.isDisplayed();
	    USA2.isDisplayed();
	    
	    searchMe.clear();
	    
	    List rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr"));
	    
	    System.out.println("No of rows =" + rows.size());
	    
	    Assert.assertEquals(4, rows.size());
	   
	 }
		
	
	 //Test4
	 
	 @FindBy(xpath="//button[text()='Drag Me']")
	 public WebElement dragMe;
	 
	 @FindBy(id="div1")
		public WebElement dramBox;
	 
	 
	 public void DragMe() throws InterruptedException
	
	 {
		 Actions action = new Actions(driver);
		 driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		 //action.dragAndDrop(drag,drop).perform();
		 action.clickAndHold(dragMe).moveToElement(dramBox).release().build().perform();
		 
	 }
	 
	 
	 
	 
		}

