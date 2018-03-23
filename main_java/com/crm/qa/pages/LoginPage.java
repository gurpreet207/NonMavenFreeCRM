package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class LoginPage extends TestBase{

	//PageFactory
	
	@FindBy(name="username")
	@CacheLookup//Used to increase script execution script.It saves element in cache memory,so need to search HTML DOM structure
	// for every execution of script.Disadvantage: If HTML DOM of application is updated then it create problem.But it should used with
	//only those elements in which no update is required. 
	WebElement username;
	
	@FindBy(name="password")
	WebElement pasword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement lgnbtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signupBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;

	//Initializing the Page Objects
	public LoginPage(){
		PageFactory.initElements(driver, this);// this means pointing to current class objects
		//All these variables will be initialised with driver
	}
	
	//Actions
	public String validateloginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd){
		JavascriptExecutor js = (JavascriptExecutor)driver;//JavascriptExecutor is an interface so we have to typecast it to create in object
		//username.sendKeys(un);
		js.executeScript("arguments[0].value='"+prop.getProperty("username")+"';", username);
		//password.sendKeys(pwd);
		js.executeScript("arguments[0].value='"+prop.getProperty("password")+"';", pasword);
		//lgnbtn.click();
		js.executeScript("arguments[0].click();", lgnbtn);
		
		return new HomePage(); //return homepage class object
	}
	
}
