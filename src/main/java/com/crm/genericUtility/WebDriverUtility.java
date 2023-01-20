package com.crm.genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility extends JavaUtility
{
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	
	public void elementToBeVisible(WebDriver driver,WebElement element, int Time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Time); 
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void select(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public void select(String visibleText, WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	public void mousehover(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}
	
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst);
	}
	
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	public void rightClick(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.contextClick().perform();
	}
	
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void enterKeyPress(WebDriver driver)
	{
		Actions act= new Actions(driver);
	}
	
	public void enterKey(WebDriver driver) throws AWTException
	{
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void enterRelease(WebDriver driver) throws AWTException
	{
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver,String nameOrlD)
	{
		driver.switchTo().frame(nameOrlD);
	}
	
	public void switchToFrame(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void cancleAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToWindow(WebDriver driver,String partialTitle)
	{
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			String wind = it.next();
			String currentWinTitle = driver.switchTo().window(wind).getTitle();
			if(currentWinTitle.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	public String getScreeShot(WebDriver driver) throws IOException
	{
		String date = getSystemDate();
		String name = "Screenshot_"+date;
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	String path = "./screenshot/"+name+".png";
	
	File dst = new File(path);
	FileUtils.copyFile(src, dst);
	return path;	
	}
	
	public void scrollBarAction(WebDriver driver, int yPixel)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,"+yPixel+")");
	}
	
	public void scrollToElement(WebDriver driver,WebElement element)
	{
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		 jse.executeScript("argument[0].scrollIntoView();",element);
	}
	
	//launching the browser
	public WebDriver launchBrowser(String BROWSER) throws Throwable
	{
		
		
		
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			return new FirefoxDriver();
		}
		
		else
		{
			return new ChromeDriver();
		}
	
		
		
	}
}
