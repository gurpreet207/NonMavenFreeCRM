package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ContactsPageTest extends TestBase{
  
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;	
	String sheetName = "contacts";
		
	public ContactsPageTest(){
		super();
		
}


@BeforeMethod
public void setUp() {
	
	initialisation();
	testUtil = new TestUtil();
	contactsPage = new ContactsPage();
	loginPage = new LoginPage();
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	testUtil.switchToFrame();//After login to Home page ,change frame and then click on contacts
	contactsPage = homePage.clickOnContactsLink();
	//testUtil.switchToFrame();
}

@Test(priority=1)
public void verifyContactsPageLabel(){
	Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
}

//Not returning anything .just clicking,so it is void method
@Test(priority=2,enabled=false)
public void selectSingleContactsTest(){
	contactsPage.selectContactsByName("Aamy Aadams");
}

@Test(priority=3,enabled=false)
public void selectMultipleContactsTest(){
	contactsPage.selectContactsByName("Aamy Aadams");
	contactsPage.selectContactsByName("abc abc");
}


@DataProvider
public Object[][] getCRMTestData(){
	Object data1[][] = TestUtil.getTestData(sheetName);
	return data1;
}

@Test(priority=4, dataProvider="getCRMTestData",enabled=false)
public void validateCreateNewContact(String title, String firstName, String lastName, String company) {
	//testUtil.switchToFrame();
	homePage.clickOnNewContactLink();
	//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");//pass parameters from here to contactsPage class method
	contactsPage.createNewContact(title, firstName, lastName, company);
	
}


  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
