package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(),'User: gurpreet singh chawla')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickOnContactsLink(){
		contactsLink.click(); //after clicking on contacts link it will return Contacts Page object
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click(); //after clicking on Deals link it will return Deals Page object
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}

	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		//driver.switchTo().frame("mainpanel");
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
}
