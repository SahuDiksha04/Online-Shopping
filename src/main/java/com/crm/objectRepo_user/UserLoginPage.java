package com.crm.objectRepo_user;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.PropertyFileUtility;

public class UserLoginPage {
	//declaration for login
	@FindBy(id="exampleInputEmail1")
	private WebElement usermail;

	@FindBy(id="exampleInputPassword1")
	private WebElement userpassword;

	@FindBy(xpath="//button[text()='Login']")
	private WebElement userlogin;

	//declaration for create account
	@FindBy(name="fullname")
	private WebElement username;

	@FindBy(name="emailid")
	private WebElement usermailid;

	@FindBy(name="contactno")
	private WebElement usercontact;

	@FindBy(name="password")
	private WebElement usercreatepassword;

	@FindBy(name="confirmpassword")
	private WebElement userconfirmpassword;

	@FindBy(xpath="//button[text()='Sign Up']")
	private WebElement usersignin;

	//initialization
	public UserLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//utilization
	public WebElement getUsermail() {
		return usermail;
	}

	public WebElement getUserpassword() {
		return userpassword;
	}

	public WebElement getUserlogin() {
		return userlogin;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getUsermailid() {
		return usermailid;
	}

	public WebElement getUsercontact() {
		return usercontact;
	}

	public WebElement getUsercreatepassword() {
		return usercreatepassword;
	}

	public WebElement getUserconfirmpassword() {
		return userconfirmpassword;
	}

	public WebElement getUsersignin() {
		return usersignin;
	}

	//business library
	public void userLogin(PropertyFileUtility flib) throws Throwable
	{
		usermail.sendKeys(flib.readDataFromPropertyFile("Uusername"));
		userpassword.sendKeys(flib.readDataFromPropertyFile("Upassword"));
		userlogin.click();


	}

	public void createAccount(HashMap<String,String>fields,WebDriver driver,JavaUtility jlib)
	{
		for ( Entry<String, String> set : fields.entrySet()) 
		{
			if(set.getKey().contains("Full Name"))
			{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jlib.getRandomNo());				
			}
			else{

				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
		}

	}
}
