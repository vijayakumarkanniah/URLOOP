package excelReadWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelRead {
	
	static String ReturnValueOfTheExcel;

	
	 public static Sheet readExcel(String filePath,String fileName,String sheetName) throws IOException{
		    //Create a object of File class to open xlsx file
		    File file = new File(filePath+"\\"+fileName);
		    //Create an object of FileInputStream class to read excel file
		    FileInputStream inputStream = new FileInputStream(file);
		    Workbook workBookOfExccel = null;
		    //Find the file extension by spliting file name in substing and getting only extension name
		    String fileExtensionName = fileName.substring(fileName.indexOf("."));
		    //Check condition if the file is xlsx file
		    if(fileExtensionName.equals(".xlsx")){
		    //If it is xlsx file then create object of XSSFWorkbook class
		    workBookOfExccel = new XSSFWorkbook(inputStream);
		    }
		    //Check condition if the file is xls file
		    else if(fileExtensionName.equals(".xls")){
		        //If it is xls file then create object of XSSFWorkbook class
		        workBookOfExccel = new HSSFWorkbook(inputStream);
		    }
		    //Read sheet inside the workbook by its name
		    Sheet sheetOfExcel = workBookOfExccel.getSheet(sheetName);
		     return sheetOfExcel;    
		    }
	 
	 
	/* @Test(priority=1)*/
	 public static String readExcelByKeyWord(String FilePath,String FileName,String Sheet,String TestCase,String KeyWord) throws IOException{
		 
/*String TestCase = "Invite_Members_Dynamic";
		 
		 String KeyWord = "EmailID";*/
		 
		 /*Getting Sheet Name and the format*/
		 /*Sheet getExcelSheet =readExcel("src//main//resources//dataSheet//","TestDataSheet.xls","People");*/
		 Sheet getExcelSheet =readExcel(FilePath,FileName,Sheet);
		 /*Getting the row count of the excel*/
		 int rowCount = getExcelSheet.getLastRowNum()-getExcelSheet.getFirstRowNum();
		 /*Iterating the TestCase ( Row ) of the excel*/
		 for (int i = 0; i < rowCount; i++) {
			 /*Iterating the KeyData ( Column ) of the excel*/
			 for (int j = 0; j <= getExcelSheet.getRow(0).getLastCellNum();j++){
				 /*Verifying the null cell and the blank cell*/
				 if (getExcelSheet.getRow(i).getCell(0) == null || getExcelSheet.getRow(0).getCell(j) == null 
							|| getExcelSheet.getRow(i).getCell(0).getCellType() == Cell.CELL_TYPE_BLANK
						|| getExcelSheet.getRow(0).getCell(j).getCellType() == Cell.CELL_TYPE_BLANK) {
					 System.out.println("Null");
					}
				  /*Getting the value from the excel and converting into the String Format*/
				 else if (getExcelSheet.getRow(i).getCell(0).getCellType() == Cell.CELL_TYPE_STRING)
				 {
					 if (TestCase.equalsIgnoreCase(getExcelSheet.getRow(i).getCell(0).getStringCellValue()) && KeyWord.equalsIgnoreCase(getExcelSheet.getRow(0).getCell(j).getStringCellValue()) ){
						 System.out.println("Validation Success"+getExcelSheet.getRow(i).getCell(j).toString());
						 
						 ReturnValueOfTheExcel = getExcelSheet.getRow(i).getCell(j).toString();
						 }
					 /*RunTime Exception is Thrown Out*/
				 } else{
					 System.out.println("Verify the Excel of the method /readExcelByKeyWord");
					 throw new RuntimeException(
								"Cell Type is not supported ");
				 }
				 
				 
				 
				 }
			 }
		 return ReturnValueOfTheExcel;
		 }
	 }
