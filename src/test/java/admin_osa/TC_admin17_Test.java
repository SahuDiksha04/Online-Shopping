package admin_osa;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_admin17_Test {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		FileInputStream fis = new FileInputStream("./src/test/java/CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String aurl = p.getProperty("AUrl");
		driver.get(aurl);
		String ausername = p.getProperty("AUsername");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(ausername);
		String apwd = p.getProperty("APassword");
		driver.findElement(By.id("inputPassword")).sendKeys(apwd);
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
