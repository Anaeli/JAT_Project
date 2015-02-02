package framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	@SuppressWarnings("resource")
	public Object[][] readExcel(String filePath,String fileName,String sheetName) throws IOException{

		//Create a object of File class to open xlsx file
		File file =    new File(filePath+"\\"+fileName);
		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook jatWorkbook = null;
		//Find the file extension by spliting file name in substring and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		//Check condition if the file is xlsx file
		if(fileExtensionName.equals(".xlsx")){
			//If it is xlsx file then create object of XSSFWorkbook class
			jatWorkbook = new XSSFWorkbook(inputStream);
		}
		//Check condition if the file is xls file
		else if(fileExtensionName.equals(".xls")){
			//If it is xls file then create object of XSSFWorkbook class
			jatWorkbook = new HSSFWorkbook(inputStream);
		}
		//Read sheet inside the workbook by its name
		Sheet jatSheet = jatWorkbook.getSheet(sheetName);
		//Find number of rows in excel file
		int rowCount = jatSheet.getLastRowNum()-jatSheet.getFirstRowNum();
		//Create a loop over all the rows of excel file to read it
		Object[][] data = new Object[rowCount+1][jatSheet.getLastRowNum()+1];
		for (int i = 0; i < rowCount+1; i++) {
			Row row = jatSheet.getRow(i);
			//Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
				//Print excel data in console
				data[i][j] = row.getCell(j).getStringCellValue();
				//System.out.println(row.getCell(j).getStringCellValue());
			}
		}
		return data;
	}
} 

