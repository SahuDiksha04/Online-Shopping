package admin_osa;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.PropertyFileUtility;

public class TC_admin16_Test {

	public static void main(String[] args) throws Throwable {
		
		PropertyFileUtility flib = new PropertyFileUtility();	
		ExcelUtility elib = new ExcelUtility();
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		
		//fetch data from property file.
		/*FileInputStream fis = new FileInputStream("./src/test/java/CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String aurl = p.getProperty("AUrl");
		driver.get(aurl);
		String aUsername = p.getProperty("AUsername");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(aUsername);
		String aPwd = p.getProperty("APassword");
		driver.findElement(By.id("inputPassword")).sendKeys(aPwd);
		driver.findElement(By.xpath("//button[text()='Login']")).click();*/
		
		String aurl = flib.readDataFromPropertyFile("AUrl");
		driver.get(aurl);
		String ausername = flib.readDataFromPropertyFile("AUsername");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(ausername);
		
		String apassword = flib.readDataFromPropertyFile("APassword");
		driver.findElement(By.id("inputPassword")).sendKeys(apassword);
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
        driver.findElement(By.xpath("//a[text()='User Login Log ']")).click();
		
        
        
        
		//fetch data from excel file
		/*FileInputStream f = new FileInputStream("./src/test/java/TestExcel.xlsx");
		Workbook wb = WorkbookFactory.create(f);
		Sheet sheet = wb.getSheet("sheet2");
		String expectedusername = sheet.getRow(1).getCell(0).getStringCellValue();*/
        
       String expectedUsername = elib.readDataFromExcel("sheet2", 1, 0);
		
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(expectedUsername);
		String actualusername = driver.findElement(By.xpath("//tbody[@role='alert']//td[text()='"+expectedUsername+"']")).getText();
		if(actualusername.equals(expectedUsername))
		{
			System.out.println("status is successful");
		}
		else
		{
			System.out.println("status is not successful");
		}
		driver.quit();
		
	}

}
