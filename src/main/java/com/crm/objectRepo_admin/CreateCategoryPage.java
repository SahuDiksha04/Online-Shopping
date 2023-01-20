package com.crm.objectRepo_admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCategoryPage {
	@FindBy(name="category")
	private WebElement createcategory;
	
	@FindBy(name="description")
	private WebElement description;
	
	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createbutton;
	
	public CreateCategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatecategory() {
		return createcategory;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getCreatebutton() {
		return createbutton;
	}
	
	public void createcategory()
	{
		getCreatecategory().sendKeys("Mobile");
		getDescription().sendKeys("Good");
		getCreatebutton().click();
		
		
		
	}

}
