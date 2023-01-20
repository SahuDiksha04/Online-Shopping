package Practise_Package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PractiseXpath {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//h2[text()='Shop & Pay | Earn rewards daily']/../..//a[text()='See more']")).click();
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.switchToWindow(driver, "Amazon Pay");
		List<WebElement> value = driver.findElements(By.xpath("//div[@class='a-section regular-slot-header-desktop']/..//span[@class='image-footer-text-desktop']"));
	    for (WebElement val : value) 
	    {
			String text = val.getText();
			System.out.println(text);
		}
	
	
	
	}

}
