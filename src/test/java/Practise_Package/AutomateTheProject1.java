package Practise_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class AutomateTheProject1
{
	
	public static void main(String[] args) throws InterruptedException, SQLException 
	{
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("online shopping application");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Diksha");
		WebElement status = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select s = new Select(status);
		s.selectByVisibleText("Created");
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		Connection conn=null;
		try
		{
			Driver drive= new Driver();
			DriverManager.registerDriver(drive);
			conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement state = conn.createStatement();
			String query = "select * from project where project_name='online shopping application';";
			ResultSet result = state.executeQuery(query);	
			
			
			while(result.next())
			{
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			}
			
		}
		finally
		{
			conn.close();
		}
	

	}
}
