package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ReadAndWriteToExcel {
	public static WebDriver driver;
   public static String excelPath ="src\\com\\test.xls";
    Workbook wb ;
    File file;
    FileInputStream fis;
    String fileExtn = null;
	public static void setup() {
	System.setProperty("webdriver.chrome.driver","G:/java/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		Action a =null;
		Actions a1 = null
	}
	public String readDataFroExcel(String sheetName,int rowNo ,int colNo) throws IOException{
		file = new File(excelPath);
		fis = new FileInputStream(file);
        fileExtn = excelPath.substring(excelPath.indexOf("."));
		if(fileExtn.contains("xlsx")){
			//wb = new HSSFWorkbook(fis);
		}else if(fileExtn.contains("xls")){
			wb = new HSSFWorkbook(fis);
		}
		Sheet s1 = wb.getSheet(sheetName);
	//	int rowCount = s1.getLastRowNum()-s1.getFirstRowNum();
		//Row row;
		/*for(int i=0;i<rowCount;i++){
			 row = s1.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++){
				String data = row.getCell(j).getStringCellValue();
			}
		}*/
		
		String data = s1.getRow(rowNo).getCell(colNo).getStringCellValue();
		return data;
	}
	public void writeDataToExcel(String sheetName , int rowNo , int ColNo ,String data) throws IOException{
		file = new File(excelPath);
		fis = new FileInputStream(file);
		fileExtn = excelPath.substring(excelPath.indexOf("."));
		if(fileExtn.contains("xlsx")){
			wb = new HSSFWorkbook(fis);
		}else if (fileExtn.contains("xls")){
			wb = new HSSFWorkbook(fis);
		}
		Sheet s1 = wb.getSheet(sheetName);
	//	int rowCount = s1.getLastRowNum() - s1.getFirstRowNum();
		Row row ;
		row = s1.getRow(rowNo);
		//to craete new row and append it 
		//Row newRow = s1.createRow(rowNo);
		s1.getRow(rowNo).createCell(ColNo).setCellValue(data);
		//if want to create new row 
	//	Cell c1 = row.createCell(ColNo);
	//	c1.setCellValue(data);
		fis.close();
		
		FileOutputStream fos = new FileOutputStream(excelPath);
		wb.write(fos);
		fos.close();
		
	}
	@Test
	public void test() throws IOException, FilloException{
		//setup();
		//driver.findElement(By.name("q")).sendKeys(readDataFroExcel("sheet1", 1, 0));
		//driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		//writeDataToExcel("sheet1", 1, 1, driver.findElement(By.id("resultStats")).getText());
		//System.out.println(readDataFroExcel("sheet1", 1, 0));
		//System.out.println(readDataFroExcel("sheet1", 2, 0));
		//System.out.println(readDataFroExcel("sheet1", 3, 0));
		//System.out.println(readDataFroExcel("sheet1", 4, 0));
		//writeDataToExcel("sheet1", 4, 1, "test4");
		System.out.println( getDataFromExcel("Sheet2", "name", "test"));
		System.out.println( getDataFromExcel("Sheet2", "name", "test1"));
		updateIntoExcel("Sheet2", "name", "test1", "sdfhsd");
	}
	public static String getDataFromExcel(String sheetName , String fieldName ,String testCaseName) throws FilloException{
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(excelPath);
		String strQuery="Select * from "+sheetName+" where testCaseName='"+testCaseName+"'";
		Recordset recordset=connection.executeQuery(strQuery);
		 String filedNmaeValue = null;
		while(recordset.next()){
			filedNmaeValue=  recordset.getField(""+fieldName+"");
			System.out.println("sjdeb hb "+filedNmaeValue);
		}
		 
		recordset.close();
		connection.close();
		return filedNmaeValue;}
	public static void updateIntoExcel (String sheetName , String fieldName ,String testCaseName,  String data) throws FilloException{
		Fillo fillo=new Fillo();
		Connection connection = fillo.getConnection(excelPath);
		//String strQuery = "update "+sheetName+" set "+fieldName+" = "+data+" where testCaseName= "+testCaseName+"";
		String strQuery = "update "+sheetName+" set "+fieldName+" = '"+data+"' where testCaseName= '"+testCaseName+"'";
		System.out.println(strQuery);
		connection.executeQuery(strQuery);
		connection.close();
	//	return excelPath;
		
	}
}
