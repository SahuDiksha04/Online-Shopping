package com.crm.objectRepo_admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginLogPage {

	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchbox;
	
	public UserLoginLogPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
}
