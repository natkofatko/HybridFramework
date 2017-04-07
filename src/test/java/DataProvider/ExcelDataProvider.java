package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb; 
//Constructor 
	public ExcelDataProvider()
	{ 
File src = new File("C:\\Users\\natal\\workspace\\LearnAutomation\\com.learnautomation.hybrid\\ApplicationTestData\\AppData.xlsx");
	
try {
	FileInputStream fis = new FileInputStream(src);
	wb = new XSSFWorkbook(fis); 
	
}
catch (Exception e) {
	
	System.out.println("Exception is " + e.getMessage());
} 

	}
	
	//First Method
	public String getDataBySheetIndex(int ShettNumber, int rowNumber, int collmnNumber)
	{
		String Data = wb.getSheetAt(ShettNumber).getRow(rowNumber).getCell(collmnNumber).getStringCellValue(); 
		return Data; 
	}
	
	
	public String GetDataBySheetName(String SheetName, int rowNumber, int CellNumber)
	{
		String Data = wb.getSheet(SheetName).getRow(rowNumber).getCell(CellNumber).getStringCellValue(); 
		return Data; 
	}
	
}
