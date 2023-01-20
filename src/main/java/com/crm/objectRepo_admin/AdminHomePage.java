package com.crm.objectRepo_admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	
	//declaration
	@FindBy(xpath = "//a[contains(.,'Order Management')]")
	private WebElement ordermgmt;
	
	@FindBy(xpath = "//a[@href='todays-orders.php']")
	private WebElement todayorder;
	
	@FindBy(xpath = "//a[@href='pending-orders.php']")
	private WebElement pendingorder;
	
	@FindBy(xpath = "//a[@href='delivered-orders.php']")
	private WebElement deliveredorder;
	
	@FindBy(xpath = "//a[contains(.,'Manage users')]")
	private WebElement manageuser;
	
	@FindBy(xpath = "//a[contains(.,' Create Category ')]")
	private WebElement createcategory;
	
	@FindBy(xpath = "//a[contains(.,'Sub Category ')]")
	private WebElement subcategory;
	
	@FindBy(xpath="//a[contains(.,'Insert Product ')]")
	private WebElement insertproduct;
	
	@FindBy(xpath = "//a[contains(.,'Manage Products ')]")
	private WebElement manageproducts;
	
	@FindBy(xpath = "//a[contains(.,'User Login Log ')]")
	private WebElement userloginlog;
	
	@FindBy(xpath = "//a[contains(.,'Logout')]")
	private WebElement logout;
	
	
	//initialization
	public AdminHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

    //utilization
	public WebElement getOrdermgmt() {
		return ordermgmt;
	}


	public WebElement getTodayorder() {
		return todayorder;
	}


	public WebElement getPendingorder() {
		return pendingorder;
	}


	public WebElement getDeliveredorder() {
		return deliveredorder;
	}


	public WebElement getManageuser() {
		return manageuser;
	}


	public WebElement getCreatecategory() {
		return createcategory;
	}


	public WebElement getSubcategory() {
		return subcategory;
	}


	public WebElement getInsertproduct() {
		return insertproduct;
	}


	public WebElement getManageproducts() {
		return manageproducts;
	}


	public WebElement getUserloginlog() {
		return userloginlog;
	}


	public WebElement getLogout() {
		return logout;
	}
	
	//business libraries
	public void orderMgmt()
	{
		ordermgmt.click();
		todayorder.click();
		pendingorder.click();
		deliveredorder.click();
		
	}
	
	public void manageuser()
	{
		manageuser.click();
	}
	
	public void createCategory()
	{
		createcategory.click();
	}
	
	public void subCategory()
	{
		subcategory.click();
	}
	
	public void insertProduct()
	{
		insertproduct.click();
	}
	
	public void manageProducts()
	{
		manageproducts.click();
	}
	
	public void userLoginLog()
	{
		userloginlog.click();
	}
	
	public void logoutAdmin()
	{
		logout.click();
		
	}
	
	

}
