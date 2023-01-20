package generic_testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.PropertyFileUtility;

public class TC_admingeneric16_Test {

	public static void main(String[] args) throws Throwable {
		PropertyFileUtility flib = new PropertyFileUtility();	
		ExcelUtility elib = new ExcelUtility();
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		
		String aurl = flib.readDataFromPropertyFile("AUrl");
		driver.get(aurl);
		String ausername = flib.readDataFromPropertyFile("AUsername");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(ausername);
		
		String apassword = flib.readDataFromPropertyFile("APassword");
		driver.findElement(By.id("inputPassword")).sendKeys(apassword);
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
        driver.findElement(By.xpath("//a[text()='User Login Log ']")).click();
		
        
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
