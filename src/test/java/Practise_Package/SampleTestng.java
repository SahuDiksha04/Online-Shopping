package Practise_Package;



import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SampleTestng {
    
	
	
	@BeforeMethod
	public void configBM()
	{
		System.out.println("login the appl");
	}
	
	
	@Test()
	public void createCategory()
	{
		System.out.println("create");
	}
	
	
	@AfterMethod
	public void conBCfigAM()
	{
		System.out.println("logout the app");
	}
	
	
	@Test(priority=1,invocationCount=2)
	public void createdSubCategory()
	{
		System.out.println("subcategory");
	}
	
	@Test(priority=3,dependsOnMethods = "createCategory")
	public void insertCategory()
	{
		System.out.println("insertcategory");
	}
	
	@Test()
	public void manageProduct()
	{
	   System.out.println("manageproduct");	
	}
	
	@Test()
	public void purchaseProduct()
	{
		System.out.println("purchaseproduct");
	}
	
	@Test()
	public void manageOrder()
	{
		System.out.println("manageorder");
	}
	
	@BeforeClass
	public void configBC()
	{
		System.out.println("launch the browser");
	}
	
	@AfterClass
	public void configAC() 
	{
		System.out.println("close the browser");
	}
	
	@BeforeSuite
	public void configBS()
	{
		System.out.println("connect to database");
	}
	
	@AfterSuite
	public void configAS()
	{
		System.out.println("disconnect to database");
	}
	
	
	
	
}
