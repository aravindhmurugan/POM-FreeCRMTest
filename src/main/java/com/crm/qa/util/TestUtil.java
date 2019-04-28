package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public TestUtil() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
	}

	public static long IMPLICITWAIT = 20;
	public static long PAGELOADTIMEOUT = 30;
	
	public static String TestData_Sheet_Path="E:\\Selenium\\Workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public void switchtoframemain() {
		driver.switchTo().frame("mainpanel");
		
	}
	
	public void switchtoframeleft() {
		driver.switchTo().frame("leftpanel");
		
	}
	
	public static Object[][] gettestdata (String sheetName) throws InvalidFormatException {
		
		FileInputStream file = null;
		
		try {
		    file = new FileInputStream(TestData_Sheet_Path);
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} 
		
		try {
			book = WorkbookFactory.create(file);
		}
		
		catch (IOException e) {
			e.printStackTrace();		 
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i = 0;i<sheet.getLastRowNum();i++) {
			for(int k = 0;k<sheet.getRow(0).getLastCellNum();k++) {
				
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
				
				return data;
			}
		
	

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
//		  String currentDir = System.getProperty("user.dir"); 
//		  FileHandler.copy(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		 
		
	FileHandler.copy(scrFile, new File("\\E:\\Selenium\\Workspace\\FreeCRMTest\\" + System.currentTimeMillis() +".png"));
	}

	
	
	
		
	
	
}
	
	
	
	
	

