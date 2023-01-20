package Practise_Package;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/java/TestExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("Sheet1").createRow(1).createCell(1).setCellValue("writing");
		FileOutputStream fout = new FileOutputStream("./src/test/java/TestExcel.xlsx");
		wb.write(fout);
		wb.close();
		
		
		

	}

}
