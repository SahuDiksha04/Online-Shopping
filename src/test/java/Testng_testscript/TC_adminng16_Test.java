package Testng_testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;
import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.PropertyFileUtility;
import com.crm.objectRepo_admin.AdminHomePage;
import com.crm.objectRepo_admin.AdminLoginPage;

public class TC_adminng16_Test extends BaseClass {
	
	@Test
	
	public void main() throws Throwable {
		//PropertyFileUtility flib = new PropertyFileUtility();	
		//ExcelUtility elib = new ExcelUtility();
		
		//System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		AdminLoginPage al = new AdminLoginPage(driver);
		AdminHomePage ah = new AdminHomePage(driver);
		
		driver.get(fLib.readDataFromPropertyFile("AUrl"));
		
		al.adminLogin(fLib);
		ah.userLoginLog();
		
		String expectedUsername = eLib.readDataFromExcel("sheet2", 1, 0);
		
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
