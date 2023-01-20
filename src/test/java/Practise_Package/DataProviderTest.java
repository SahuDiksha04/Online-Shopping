package Practise_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test(dataProvider="data")
	public void category(String brand,String price)
	{
		System.out.println("brand is"  +brand+"--->"+price);
	}

	@DataProvider
	public Object[][] data()
	{
		Object[][] objarr = new Object[2][3];

		objarr[0][0]="samsung";
		objarr[0][1]="50000";

		objarr[1][0]="realme";
		objarr[1][1]="30000";

		objarr[2][0]="vivo";
		objarr[2][1]="40000";
		
		return objarr;


	}


}
