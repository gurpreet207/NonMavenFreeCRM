package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest(){
	//Compulsory to call Test Base Class Constructor,becasue we have to initialise prop in Test Base Class constructor before using 
	// initialisation() method
		
		super();//calling Test Base Class Constructor.Constructor call must be first statement in constructor
		
	}
	@BeforeMethod
	  public void setup() {
		initialisation();
		loginPage = new LoginPage();
	  }

	
    @Test(priority=1)
    public void logipagetitleTest() {
    	String title=loginPage.validateloginPageTitle();
    	Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
  }
 
    @Test(priority=2)
    public void crmLogoImgTest() {
    	boolean flag=loginPage.validateCRMImage();
    	Assert.assertTrue(flag);
  }
  
    @Test(priority=3)
    public void loginTest()  {
    	homepage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
   
  }
  
  @AfterMethod
  public void teardown() {
  driver.quit();
  }
  

}
