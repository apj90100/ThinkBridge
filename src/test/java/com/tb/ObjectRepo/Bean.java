package com.tb.ObjectRepo;

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
	
	
	
	@FindBy(xpath="//div[contains(@id,'ui-select-choices-row-1-')]")
	public WebElement lstLang;
	
	@FindBy(xpath="//span[@class=\"black-color ng-binding\"]")
	public WebElement label;
	
	
	@FindBy(id="language")
	public WebElement language;
	
			
	@FindBy(id="name")
	public WebElement name;
	
	
	
	@FindBy(xpath="//button[text()='Close']")
	public WebElement close;
	
	@FindBy(id="orgName")
	public WebElement organisation;
	
	
	@FindBy(id="singUpEmail")
	public WebElement Emailid;
	

	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement submit;
	
	@FindBy(xpath="//span[@class='ng-binding'][contains(text(),'A welcome email has')]")
	public WebElement actualMsg;
	
	@FindBy(xpath="//span[@class='black-color ng-binding']")
	public WebElement slabel;
	
	
	
}	
	