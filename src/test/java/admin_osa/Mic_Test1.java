package admin_osa;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mic_Test1 {

	public static void main(String[] args) throws AWTException {
		WebDriverUtility wlib = new WebDriverUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		wlib.maximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		
		WebDriverWait wait=new WebDriverWait(driver,60);
		driver.get("https://mictests.com/");
		driver.findElement(By.xpath("//button[.='Click here to allow access to microphone identifiers']"));
		
		
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_TAB);
		robo.keyRelease(KeyEvent.VK_TAB);
		robo.keyPress(KeyEvent.VK_TAB);
		robo.keyRelease(KeyEvent.VK_TAB);
		robo.keyPress(KeyEvent.VK_TAB);
		robo.keyRelease(KeyEvent.VK_TAB);
		
		 WebElement foundText = driver.findElement(By.xpath("//li[contains(text(),'Several microphones were detected')]"));
		 wait.until(ExpectedConditions.visibilityOf(foundText));
		 
		 driver.findElement(By.xpath("//button[text()='Test my mic']")).click();
		 
		 WebElement successText = driver.findElement(By.xpath("//li[contains(text(),'Testing was completed successfully ')]"));
		 if(wait.until(ExpectedConditions.visibilityOf(successText)).isDisplayed())
		 {
			 System.out.println("mic test pass");
			 driver.quit();
		 }
		 else
		 {
			 System.out.println("mic test not  pass"); 
		 }
		
	}
}
