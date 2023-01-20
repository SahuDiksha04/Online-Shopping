package admin_osa;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.crm.genericUtility.WebDriverUtility;

public class Mic_Test {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeOptions option= new ChromeOptions();
		HashMap<String,Integer> contentSetting = new HashMap<String, Integer>();
		HashMap<String,String> profile = new HashMap<String, String>();
		HashMap<String,String> prefs = new HashMap<String, String>();
		contentSetting.put("media_stream", 2);
		profile.put("managed-default-content-settings","contentSetting");
		prefs.put("profile", "profile");
		option.setExperimentalOption("prefs"," prefs");
		
		WebDriver driver=new ChromeDriver(option); 
		driver.get("https://mictests.com/");
		driver.findElement(By.xpath("//button[text()='Test my mic']")).click();
		WebDriverUtility wb = new WebDriverUtility();
		wb.elementToBeVisible(driver, null, 50);
		
		
	}

}
