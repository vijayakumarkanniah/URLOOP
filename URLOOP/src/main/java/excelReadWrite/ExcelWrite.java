package excelReadWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelWrite {
	/**
	 * This program illustrates how to update an existing Microsoft Excel document.
	 * Append new rows to an existing sheet.
	 *
	 * @author www.codejava.net
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 *
	 */
	
	/*public static void main(String[] args) throws InvalidFormatException, IOException {*/
	
	public static void ExcelWriteCell(String TestCaseName,String KeyWord,String StatusOfTheTestCase) throws InvalidFormatException, IOException {
		try{
			 FileInputStream inputStream = new FileInputStream(new File("C:/Users/VIJAY KUMAR/git/URLOOP/URLOOP/src/main/resources/dataSheet/TestDataSheet.xls"));
	         Workbook workbook = WorkbookFactory.create(inputStream);
	         
	         
	         CellStyle style = workbook.createCellStyle();
	         
	         if(StatusOfTheTestCase == "SUCCESS"){
	        	 
				    style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
				    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	         }
	         if(StatusOfTheTestCase == "FAILURE"){
	        	 
				    style.setFillForegroundColor(IndexedColors.RED.getIndex());
				    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	         }
	         if(StatusOfTheTestCase == "SKIP"){
	        	 
				    style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
				    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	         }
	         
	         
			    
			    Sheet sheet = workbook.getSheet("Login");
			    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
			    System.out.println("RowCount"+rowCount);
			    
			    /*Copy*/
			    
			    for (int i = 0; i < rowCount; i++) {
					 /*Iterating the KeyData ( Column ) of the excel*/
					 for (int j = 0; j <= sheet.getRow(0).getLastCellNum();j++){
						 /*Verifying the null cell and the blank cell*/
						 if (sheet.getRow(i).getCell(0) == null || sheet.getRow(0).getCell(j) == null 
									|| sheet.getRow(i).getCell(0).getCellType() == Cell.CELL_TYPE_BLANK
								|| sheet.getRow(0).getCell(j).getCellType() == Cell.CELL_TYPE_BLANK) {
							 System.out.println("Null");
							}
						  /*Getting the value from the excel and converting into the String Format*/
						 else if (sheet.getRow(i).getCell(0).getCellType() == Cell.CELL_TYPE_STRING)
						 {
							 if (TestCaseName.equalsIgnoreCase(sheet.getRow(i).getCell(0).getStringCellValue()) && KeyWord.equalsIgnoreCase(sheet.getRow(0).getCell(j).getStringCellValue()) ){
								 /*System.out.println("Validation Success"+getExcelSheet.getRow(i).getCell(j).toString());*/
								
								 System.out.println("Test Case Matched");
								 
								 if(/*getExcelSheet.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_BLANK ||*/
										 sheet.getRow(i).getCell(j) == null){
									 
									 System.out.println("Inside Blank");
									 /*ReturnValueOfTheExcel="";*/
								 }
								 else{
								 /*ReturnValueOfTheExcel = getExcelSheet.getRow(i).getCell(j).toString();*/
									 
									 System.out.println("Inside Else Block");
									 
									 Cell cell2Update = sheet.getRow(i).getCell(j);
										cell2Update.setCellValue(StatusOfTheTestCase);
										cell2Update.setCellStyle(style);
									
										inputStream.close();
										FileOutputStream outputStream = new FileOutputStream("C:/Users/VIJAY KUMAR/git/URLOOP/URLOOP/src/main/resources/dataSheet/TestDataSheet.xls");
							            workbook.write(outputStream);
								 }
								 }
							 /*RunTime Exception is Thrown Out*/
						 } else{
							 System.out.println("Verify the Excel of the method /readExcelByKeyWord");
							 throw new RuntimeException(
										"Cell Type is not supported ");
						 }
			    
			    
			    /*copy*/
			    
	         
			/*Sheet sheet = workbook.getSheet("Sheet3");*/
			/*Cell cell2Update = sheet.getRow(0).getCell(0);
			cell2Update.setCellValue("False");
			cell2Update.setCellStyle(style);*/
			
			
			
			
			/*inputStream.close();
			FileOutputStream outputStream = new FileOutputStream("C:/Users/VIJAY KUMAR/git/URLOOP/URLOOP/src/main/resources/dataSheet/TestDataSheet.xls");
            workbook.write(outputStream);*/
			
			
			System.out.println("Out Side");
		}}}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception");
		}
		
	}
}

