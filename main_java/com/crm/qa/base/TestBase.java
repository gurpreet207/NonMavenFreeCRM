package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener_Gurp;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener_Gurp eventListener;

	
	
	//TestBase Class Constructor used to initialise the properties object
	//to fetch enviroment variables from config.properties file
	public TestBase() {
		try{
		prop =new Properties();
		FileInputStream ip=new FileInputStream("C:\\Selenium Testing\\Naveen AutoFramework_FreeCRM\\main_java\\com\\crm\\qa\\config\\config.properties");
		prop.load(ip);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	//reading property file
public static void initialisation()

{
	String browsername=prop.getProperty("browser");
	
	if (browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Testing\\WebDrivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	else if (browsername.equals("firefox"))
	{
		driver=new FirefoxDriver();
		
	}
	
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener_Gurp();
	e_driver.register(eventListener);
	driver = e_driver;
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	
	//Read property File
	driver.get(prop.getProperty("url"));
	
	
}


}
