package com.crm.objectRepo_admin;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtility.WebDriverUtility;

public class InsertProductPage {

	//declaration
	@FindBy(xpath = "//select[@name='category']")
	private WebElement createcategoryp;

	@FindBy(xpath = "//select[@name='subcategory']")
	private WebElement subcategoryp;

	@FindBy(xpath = "//input[@name='productName']")
	private WebElement productname;

	@FindBy(xpath = "//input[@name='productCompany']")
	private WebElement productcompany;

	@FindBy(xpath = "//input[@name='productpricebd']")
	private WebElement productpricebd;

	@FindBy(xpath = "//input[@name='productprice']")
	private WebElement productpricead;

	@FindBy(xpath = "//textarea[@name='productDescription']")
	private WebElement productdescription;

	@FindBy(xpath = "//input[@name='productShippingcharge']")
	private WebElement productshipping;

	@FindBy(xpath = "//select[@name='productAvailability']")
	private WebElement productavalDD;


	@FindBy(xpath = "//input[@name='productimage1']")
	private WebElement productimage1;

	@FindBy(xpath = "//input[@name='productimage2']")
	private WebElement productimage2;

	@FindBy(xpath = "//input[@name='productimage3']")
	private WebElement productimage3;

	@FindBy(xpath = "//button[text()='Insert']")
	private WebElement productinsertbutton;

	//initialization
	public InsertProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getCreatecategoryp() {
		return createcategoryp;
	}

	public WebElement getSubcategoryp() {
		return subcategoryp;
	}

	public WebElement getProductname() {
		return productname;
	}

	public WebElement getProductcompany() {
		return productcompany;
	}

	public WebElement getProductpricebd() {
		return productpricebd;
	}

	public WebElement getProductpricead() {
		return productpricead;
	}

	public WebElement getProductdescription() {
		return productdescription;
	}

	public WebElement getProductshipping() {
		return productshipping;
	}

	public WebElement getProductavalDD() {
		return productavalDD;
	}

	public WebElement getProductimage1() {
		return productimage1;
	}

	public WebElement getProductimage2() {
		return productimage2;
	}

	public WebElement getProductimage3() {
		return productimage3;
	}

	public WebElement getProductinsertbutton() {
		return productinsertbutton;
	}

	public String insertProduct(WebDriver driver,String categoryName,String subCategoryName,HashMap<String, String> prodData,int rand)
	{
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.select(categoryName, getCreatecategoryp()); 
		wLib.select(subCategoryName,getSubcategoryp());
		String expectedresult="";


		for (Entry<String, String> e:prodData.entrySet())
		{
			String key = e.getKey();
			String value = e.getValue();

			driver.findElement(By.name(key)).sendKeys(value+rand);
			if(key.equals("productName"))
			{
				expectedresult = value+rand;
			}
		}

		wLib.select("In Stock", getProductavalDD());
		
		getProductimage1().sendKeys("C:\\Users\\CHINMAY\\Desktop\\mobile.png");
		getProductimage2().sendKeys("C:\\Users\\CHINMAY\\Desktop\\mobile.png");
		getProductimage3().sendKeys("C:\\Users\\CHINMAY\\Desktop\\mobile.png");
		getProductinsertbutton().click();
		return expectedresult;


	}






}
