package admin_osa;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.PropertyFileUtility;
import com.crm.genericUtility.WebDriverUtility;

public class TC_adminC_Test {

public static void main(String[] args) throws Throwable
	{
	ExcelUtility eLib = new ExcelUtility();
	PropertyFileUtility fLib = new PropertyFileUtility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	int rand = jLib.getRandomNo();
	String adminUrl = fLib.readDataFromPropertyFile("AUrl");
	String adminUsername = fLib.readDataFromPropertyFile("AUsername");
	String adminPassword = fLib.readDataFromPropertyFile("APassword");


	System.setProperty("webdriver", "./chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get(adminUrl);
	wLib.waitForPageLoad(driver);
	wLib.maximizeWindow(driver);
	 driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys(adminUsername);
	 driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(adminPassword);
	 driver.findElement(By.xpath("//button")).click();
	 
	 driver.findElement(By.xpath("//a[contains(.,'Create')]")).click();
	 String categoryName = eLib.readDataFromExcel("Sheet4", 0, 1)+rand;
	 String categorydescription = eLib.readDataFromExcel("Sheet4", 1, 1);
	 
	 driver.findElement(By.name("category")).sendKeys(categoryName);
	 driver.findElement(By.name("description")).sendKeys(categorydescription);
	 driver.findElement(By.name("submit")).click();
	 
	 driver.findElement(By.xpath("//a[contains(.,'Sub Category ')]")).click();
	 WebElement catDrop =driver.findElement(By.xpath("//select[@name='category']"));
	 wLib.select(categoryName, catDrop);
	 Thread.sleep(500);
	 String subcategoryName = eLib.readDataFromExcel("Sheet4", 2, 1)+rand;
	 driver.findElement(By.xpath("//input[@name='subcategory']")).sendKeys(subcategoryName);
	 
	 driver.findElement(By.xpath("//button[.='Create']")).click();  
	 driver.findElement(By.xpath("//a[contains(.,'Insert Product ')]")).click();
	 Thread.sleep(500);
	 WebElement catDrop1 =driver.findElement(By.xpath("//select[@name='category']"));
	wLib.select(categoryName, catDrop1);  
	Thread.sleep(3000);
	 WebElement subcatDrop =driver.findElement(By.xpath("//select[@name='subcategory']"));
	wLib.select(subcategoryName, subcatDrop);
	  HashMap<String, String> prodData = eLib.getList("Product Details", 0, 1);
	  String expectedresult="";
	
	
	
	for (Entry<String, String> e:prodData.entrySet())
	{
	String key = e.getKey();
	String value = e.getValue();
	driver.findElement(By.name(key)).sendKeys(value+rand);
	if(key.equals("productName"))
	{
	expectedresult = value+rand;
	}
	}
	 
	 WebElement productavailability = driver.findElement(By.xpath("//select[@name='productAvailability']"));
	wLib.select("In Stock", productavailability);
	 driver.findElement(By.name("productimage1")).sendKeys("C:\\Users\\CHINMAY\\Desktop\\mobile.png");
	 driver.findElement(By.name("productimage2")).sendKeys("C:\\Users\\CHINMAY\\Desktop\\mobile.png");
	 driver.findElement(By.name("productimage3")).sendKeys("C:\\Users\\CHINMAY\\Desktop\\mobile.png");
	 driver.findElement(By.xpath("//button[.='Insert']")).click();

	driver.findElement(By.xpath("//a[contains(.,'Manage Products ')]")).click();
	driver.findElement(By.xpath("//input")).sendKeys(expectedresult);



	String ActualResult = driver.findElement(By.xpath("//td[text() ='"+expectedresult+"']")).getText();


	if(ActualResult.equals(expectedresult))
	{
	System.out.println(ActualResult+" is successfully created.");
	}
	else
	{
	System.out.println("failed");
	}
	driver.quit();
	}

	}


