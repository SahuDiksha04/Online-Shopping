package com.crm.objectRepo_admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtility.WebDriverUtility;

public class SubCategoryPage {
	
	@FindBy(name="category")
	private WebElement selectcategoryDD;
	
	@FindBy(xpath = "//input[@name='subcategory']")
	private WebElement createsubcategory;
	
	@FindBy(xpath = "//button[text()='Create']")
	private WebElement subcatbutton;
	
	public SubCategoryPage(WebDriver driver)
	{
	 PageFactory.initElements(driver, this);
	}

	public WebElement getSelectcategoryDD() {
		return selectcategoryDD;
	}

	public WebElement getCreatesubcategory() {
		return createsubcategory;
	}

	public WebElement getSubcatbutton() {
		return subcatbutton;
	}
	
	public void createsubcategory( WebDriverUtility wlib,String visibletext,String subcatname)
	{
		wlib.select(visibletext, selectcategoryDD);
		getCreatesubcategory().sendKeys(subcatname);
		getSubcatbutton().click();
		
	}

}
