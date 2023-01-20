package generic_testscript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.PropertyFileUtility;

public class TC_admingeneric17_Test {


	public static void main(String[] args) throws Throwable {
		PropertyFileUtility flib = new PropertyFileUtility();	
		//ExcelUtility elib = new ExcelUtility();

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver= new ChromeDriver();


		String aurl = flib.readDataFromPropertyFile("AUrl");
		driver.get(aurl);
		String ausername = flib.readDataFromPropertyFile("AUsername");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(ausername);

		String apassword = flib.readDataFromPropertyFile("APassword");
		driver.findElement(By.id("inputPassword")).sendKeys(apassword);

		driver.findElement(By.xpath("//button[text()='Login']")).click();


		driver.findElement(By.xpath("//a[@class='collapsed']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(.,'Pending Orders')]")).click();
		List<WebElement> pods = driver.findElements(By.xpath("(//tr[@class='odd'])[1]/td"));
		for (WebElement pod : pods) 
		{
			System.out.println(pod.getText());


		}

	}
}
