package com.crm.genericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.crm.objectRepo_admin.AdminHomePage;
import com.crm.objectRepo_admin.AdminLoginPage;

public class BaseClass {
	public int rand;
	public WebDriver driver;
	public static WebDriver edriver;
	
	public DatabaseUtility dLib=new DatabaseUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public PropertyFileUtility fLib = new PropertyFileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	
	@BeforeSuite//(groups = {"Smoke","Regression"})
	
	public void configDB() throws Throwable
	{
		//dLib.connectToDB();
		System.out.println("connect to db");
	}
	//@Parameters("BROWSER")
	@BeforeClass//(groups = {"Smoke","Regression"})
	
	public void configBC(/*String BROWSER*/) throws Throwable
	{  
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		driver = wLib.launchBrowser(BROWSER);
//		if(BROWSER.equalsIgnoreCase("firefox"))
//		{
//			driver= new FirefoxDriver();
//		}
//		
//		else if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			driver=new ChromeDriver();
//		}
		edriver=driver;
		driver.get(fLib.readDataFromPropertyFile("AUrl"));	
		rand = jLib.getRandomNo();
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		System.out.println("launch the browser");
	}
	
	
	@BeforeMethod//(groups = {"Smoke","Regression"})
	
	public void configBM() throws Throwable
	{
		//String USERNAME = fLib.readDataFromPropertyFile("AUsername");
		//String PASSWORD = fLib.readDataFromPropertyFile("APassword");
		
		AdminLoginPage lp = new AdminLoginPage(driver);
		lp.adminLogin(fLib);
		System.out.println("login to application");
	}	

	@AfterMethod//(groups = {"Smoke","Regression"})
	public void configAF()
	{
		AdminHomePage hp = new AdminHomePage(driver);
		hp.logoutAdmin();
		System.out.println("logout from the application");
	}
	@AfterClass//(groups = {"Smoke","Regression"})
	
	public void configAC()
	{
		driver.quit();
		System.out.println("close the browser");
	}
	@AfterSuite//(groups = {"Smoke","Regression"})
	
	public void disconnectDB() throws Throwable
	{
		//dLib.closeDB();
		System.out.println("disconnect from database");
	}
	
	

}
