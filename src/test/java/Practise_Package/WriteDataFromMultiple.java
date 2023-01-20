package Practise_Package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataFromMultiple {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/java/TestExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int count = sheet.getLastRowNum();
		for(int i=0;i<=count;i++)
		{
			Row row = sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				String cellvalue = row.getCell(j).toString();
				System.out.print(cellvalue+"  ");

			}

           System.out.println();
		}

	}
}
