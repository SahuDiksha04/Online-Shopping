package com.crm.objectRepo_admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtility.PropertyFileUtility;

public class AdminLoginPage {
	//declaration
	@FindBy(id="inputEmail")
	private WebElement adminusername;
	
	@FindBy(id="inputPassword")
	private WebElement adminpassword;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement adminlogin;
	
	//initialization
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization

	public WebElement getAdminusername() {
		return adminusername;
	}

	public WebElement getAdminpassword() {
		return adminpassword;
	}

	public WebElement getAdminlogin() {
		return adminlogin;
	}
	
	//Business library
	public void adminLogin(PropertyFileUtility flib) throws Throwable
	{
		getAdminusername().sendKeys(flib.readDataFromPropertyFile("AUsername"));
		getAdminpassword().sendKeys(flib.readDataFromPropertyFile("APassword"));
		getAdminlogin().click();
	}
	
	
	
	
	
	

}
