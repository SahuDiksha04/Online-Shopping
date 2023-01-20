package Testng_testscript;


import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;
import com.crm.objectRepo_admin.AdminHomePage;
import com.crm.objectRepo_admin.CreateCategoryPage;
import com.crm.objectRepo_admin.InsertProductPage;
import com.crm.objectRepo_admin.SubCategoryPage;


@Listeners(com.crm.genericUtility.ListenerImplementationClass.class)	
public class TC_admincng_Test extends BaseClass{

	
	
@Test(retryAnalyzer  = com.crm.genericUtility.RetryImplementationClass.class)
   public  void main() throws Throwable {
		
		AdminHomePage ah = new AdminHomePage(driver);
		//driver.get(fLib.readDataFromPropertyFile("AUrl"));
		//al.adminLogin(fLib);
		ah.createCategory();
		Assert.fail();
		
		CreateCategoryPage cc = new CreateCategoryPage(driver);
		cc.createcategory();
		
		ah.subCategory();
		SubCategoryPage sc = new SubCategoryPage(driver);
		
		Thread.sleep(2000);
		
		sc.createsubcategory(wLib, eLib.readDataFromExcel("Sheet4", 0, 1), eLib.readDataFromExcel("Sheet4", 2, 1));
		ah.insertProduct();
		InsertProductPage ipp = new InsertProductPage(driver);
		ipp.insertProduct(driver, "Mobile", "Samsung", eLib.getList("Product Details", 0, 1), rand);
}

 //@Test
      public void sample()
   {
	 System.out.println("exclude the method");
   }
}
