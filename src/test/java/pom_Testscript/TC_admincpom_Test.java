package pom_Testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.PropertyFileUtility;
import com.crm.genericUtility.WebDriverUtility;
import com.crm.objectRepo_admin.AdminHomePage;
import com.crm.objectRepo_admin.AdminLoginPage;
import com.crm.objectRepo_admin.CreateCategoryPage;
import com.crm.objectRepo_admin.InsertProductPage;
import com.crm.objectRepo_admin.SubCategoryPage;

public class TC_admincpom_Test {

	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		ExcelUtility eLib = new ExcelUtility();
		PropertyFileUtility fLib = new PropertyFileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		int rand = jLib.getRandomNo();
		
		AdminLoginPage al = new AdminLoginPage(driver);
		AdminHomePage ah = new AdminHomePage(driver);
		
		driver.get(fLib.readDataFromPropertyFile("AUrl"));
		al.adminLogin(fLib);
		ah.createCategory();
		
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

}
