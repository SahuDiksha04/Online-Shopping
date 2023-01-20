package Practise_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/java/TestExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String cellvalue = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		System.out.println(cellvalue);
		
		
	}

}
