package Practise_Package;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.PropertyFileUtility;
import com.crm.genericUtility.WebDriverUtility;

public class Vtiger_01 {

	public static void main(String[] args) throws Throwable {
		
		PropertyFileUtility flib = new PropertyFileUtility();
		ExcelUtility elib = new ExcelUtility();
		//JavaUtility ulib = new JavaUtility();
		//WebDriverUtility wlib = new WebDriverUtility();
		
		
		Random r=new Random();
		int random = r.nextInt();
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		
		//fetch data from property file
		
		/*FileInputStream fis = new FileInputStream("./src/test/java/CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String vurl = p.getProperty("Vurl");
		
		String vun = p.getProperty("Vusername");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(vun);
		String vpwd = p.getProperty("Vpassword");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(vpwd);
		driver.findElement(By.id("submitButton")).click();*/
		
		String vurl = flib.readDataFromPropertyFile("Vurl");
		String vusername = flib.readDataFromPropertyFile("Vusername");
		String vpassword = flib.readDataFromPropertyFile("Vpassword");
		
		
		
		driver.get(vurl);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(vusername);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(vpassword);
		driver.findElement(By.id("submitButton")).click();
		
	
		
		
		//fetch data from excel
		FileInputStream f = new FileInputStream("./src/test/java/TestExcel.xlsx");
		Workbook wb = WorkbookFactory.create(f);
		Sheet sheet = wb.getSheet("Sheet3");
		String lastname = sheet.getRow(1).getCell(0).getStringCellValue()+random;
		String orgname = sheet.getRow(1).getCell(1).getStringCellValue()+random;
		String leadsource = sheet.getRow(1).getCell(2).getStringCellValue();
		
		
		
		//click on organization
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")))).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		//click on contacts
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Contacts']")))).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//driver.switchTo().alert().accept();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")))).click();
	    
		//handle window
	     Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String wind=it.next();
			String currentTitle = driver.switchTo().window(wind).getTitle();
			if(currentTitle.contains("Accounts&action"))
			{
				break;
			}
		}
		
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
		
		
		 Set<String> pwindow = driver.getWindowHandles();
			Iterator<String> pit = pwindow.iterator();
			while(pit.hasNext())
			{
				String pwind=pit.next();
				String currentTitle1 = driver.switchTo().window(pwind).getTitle();
				if(currentTitle1.contains("Contacts"))
				{
					break;
				}
			}
			
						
			//handle lead source drop down
			WebElement element = driver.findElement(By.xpath("//select[@name='leadsource']"));
			wait.until(ExpectedConditions.visibilityOf(element));
			Select s = new Select(element);
			s.selectByVisibleText(leadsource);
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
			
			//sign out
			WebElement icon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions a = new Actions(driver);
			a.moveToElement(icon).perform();
			WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
			signout.click();
			
			
		
	}

}
