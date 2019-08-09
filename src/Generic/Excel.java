package Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel {
	public static double getCellValue(String path,String sheet,int r,int c) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException {
		double d=0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			d=wb.getSheet(sheet).getRow(r).getCell(c).getNumericCellValue();
            wb.close();
		}
		catch(Exception e) {
        System.out.println("Some issue");
		}

		return d;

	}
	
	
	
	
	public static String getCellValue1(String path,String sheet,int r,int c) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException {
		String s=" ";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			s=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		    wb.close();

		}
		catch(Exception e) {
			System.out.println("Some issue");
		}

		return s;

	}
	
	
	public static void setCellValue1(String path,String sheet,int r,int c, String value) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException {

		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			FileOutputStream data =new FileOutputStream(path);
			wb.getSheet(sheet).getRow(r).getCell(c).setCellValue(value);
			wb.write(data);
			wb.close();
			data.flush();
			data.close();
			

		}
		catch(Exception e) {
			System.out.println("Some issue");
		}

	}
	
	public static void setCellValue2(String path,String sheet,int r,int c, long value) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException {

		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			FileOutputStream data =new FileOutputStream(path);
			wb.getSheet(sheet).getRow(r).getCell(c).setCellValue(value);
			wb.write(data);
			wb.close();
			data.flush();
			data.close();
			

		}
		catch(Exception e) {
			System.out.println("Some issue");
		}

	}

	public static void setCellValue3(String path,String sheet,int r,int c, String value) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException {

		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			FileOutputStream data =new FileOutputStream(path);
			wb.getSheet(sheet).createRow(r).createCell(c).setCellValue(value);
			wb.write(data);
			wb.close();
			data.flush();
			data.close();
			

		}
		catch(Exception e) {
			System.out.println("Some issue");
		}

	}
	
	
	
	public static int getRowCount(String path,String sheet) {
		int rc=0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			rc=wb.getSheet(sheet).getLastRowNum();
			wb.close();

		}
		catch(Exception e) {
			System.out.println("Some issue");
		}
		return rc;


	}
	
	
	
	
	
	
	




}
