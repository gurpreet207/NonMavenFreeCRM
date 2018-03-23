package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
  @BeforeMethod
  public void setUp() {
	  initialisation();
	  loginPage = new LoginPage();//To check HomePage we need to Login application.For that LoginPage object is created,so that we can
	  // login to application
	  homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	  testUtil = new TestUtil();//so as to call method switchToFrame
	  contactsPage = new ContactsPage();
  }
  
  

  @Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");//If homepage title doesn't match then 
		//"Home page title not matched" will be displayed
	}

  @Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
  
  @Test(priority=3)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
   
  @AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
