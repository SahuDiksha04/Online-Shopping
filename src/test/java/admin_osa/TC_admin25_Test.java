package admin_osa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_admin25_Test {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		driver.findElement(By.id("inputEmail")).sendKeys("admin");
		driver.findElement(By.id("inputPassword")).sendKeys("Test@123");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Sub Category ')]")).click();
		driver.findElement(By.name("category")).sendKeys("Mobile");
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Insert Product ')]")).click();
		driver.findElement(By.xpath(""));
		
		
		
	}

}

