package Practise_Package;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.genericUtility.ExcelUtility;

public class ReadDataFromDP {
	
	@Test(dataProvider="getData")
	
		public void readData(String from,String to)
		{
			System.out.println(from+  "   "  +to);
		}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelUtility eLib = new ExcelUtility();
		Object[][] value = eLib.readFromExcelSerOfData("Product Details");
		return value;
	}

}
