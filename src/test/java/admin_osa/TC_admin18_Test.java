package admin_osa;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.PropertyFileUtility;
import com.crm.genericUtility.WebDriverUtility;
import com.crm.objectRepo_admin.AdminHomePage;
import com.crm.objectRepo_admin.AdminLoginPage;
import com.crm.objectRepo_admin.UserLoginPage;

public class TC_admin18_Test {

	public static void main(String[] args) throws Throwable {
		
		
		PropertyFileUtility flib = new PropertyFileUtility();	
		ExcelUtility elib = new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		JavaUtility jlib = new JavaUtility();
		int random = jlib.getRandomNo();
		
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		wlib.waitForPageLoad(driver);
		
		//AdminHomePage ah =new AdminHomePage(driver);
		//AdminLoginPage al = new AdminLoginPage(driver);
		
		//fetch property data
		String aurl = flib.readDataFromPropertyFile("AUrl");
		driver.get(aurl);
		String ausername = flib.readDataFromPropertyFile("AUsername");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(ausername);
		
		String apassword = flib.readDataFromPropertyFile("APassword");
		driver.findElement(By.id("inputPassword")).sendKeys(apassword);
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		
		//create category
		driver.findElement(By.xpath("//a[text()=' Create Category ']")).click();
		driver.findElement(By.name("category")).sendKeys("Mobile"+random);
		driver.findElement(By.name("description")).sendKeys("Necessity of everyone");
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		
		
		//create sub category
		driver.findElement(By.xpath("//a[text()='Sub Category ']")).click();
		WebElement categoryDrop = driver.findElement(By.name("category"));
		wlib.select("Mobile"+random, categoryDrop);
		
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		WebElement subCatTextField = driver.findElement(By.xpath("//input[@name='subcategory']"));
		subCatTextField.sendKeys("Samsung");
		//action.sendKeys(subCatTextField, "Samsung");
		
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		
		//insert product
		//select category
		driver.findElement(By.xpath("//a[text()='Insert Product ']")).click();
		WebElement categoryDropDown = driver.findElement(By.name("category"));
		wlib.select("Mobile"+random, categoryDropDown);
		
		//select sub category
		WebElement subcategoryDrop = driver.findElement(By.id("subcategory"));
		wlib.select("Samsung", subcategoryDrop);
		
		//insert product details
		HashMap<String, String> productDetails = elib.getList("Product Details", 0, 1);
		for(Entry<String, String> e:productDetails.entrySet())
		{
			String key = e.getKey();
			String value = e.getValue();
			driver.findElement(By.name(key)).sendKeys(value+random);
		}
		
		WebElement productAval = driver.findElement(By.id("productAvailability"));
		wlib.select("In Stock", productAval);
		
		driver.findElement(By.id("productimage1")).sendKeys("C:\\Users\\CHINMAY\\Desktop\\mobile.png");
		driver.findElement(By.name("productimage2")).sendKeys("C:\\Users\\CHINMAY\\Desktop\\mobile.png");
		driver.findElement(By.name("productimage3")).sendKeys("C:\\Users\\CHINMAY\\Desktop\\mobile.png");
		
		driver.findElement(By.xpath("//button[text()='Insert']")).click();
		
		
		//logout as admin
		driver.findElement(By.xpath("//a[@href='#']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		
		//login as user
		UserLoginPage ul=new UserLoginPage(driver);
		ul.userLogin(flib);
		
		
	}

}

