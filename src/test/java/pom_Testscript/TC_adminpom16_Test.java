package pom_Testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.PropertyFileUtility;
import com.crm.objectRepo_admin.AdminHomePage;
import com.crm.objectRepo_admin.AdminLoginPage;

public class TC_adminpom16_Test {

	public static void main(String[] args) throws Throwable {
		PropertyFileUtility flib = new PropertyFileUtility();	
		ExcelUtility elib = new ExcelUtility();
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		AdminLoginPage al = new AdminLoginPage(driver);
		AdminHomePage ah = new AdminHomePage(driver);
		
		driver.get(flib.readDataFromPropertyFile("AUrl"));
		
		al.adminLogin(flib);
		ah.userLoginLog();
		
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
