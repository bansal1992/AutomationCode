package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	
public class AUL {
	public static String getProperty(String path,String key) {
		String v=" ";
		try {
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			v=p.getProperty(key);
		}
		catch(Exception e) {

		}

		 return v;

	}

	public static String takePhoto(String path,String testname,WebDriver driver) throws IOException {
		String datetime = new Date().toString().replaceAll(":","_");
		TakesScreenshot t=(TakesScreenshot) driver;
		File srcfile = t.getScreenshotAs(OutputType.FILE);
		String destpath = path+testname+datetime+".png";
		try {
			FileUtils.copyFile(srcfile,new File(destpath));
		}
		catch(Exception e) {

		}
		//System.out.println("Yes");
     return destpath;
	}
	
	
//	public static boolean isFileDownloaded(String downloadPath, String fileName) {
//		boolean flag = false;
//	    File dir = new File(downloadPath);
//	    File[] dir_contents = dir.listFiles();
//	  	    
//	    for (int i = 0; i < dir_contents.length; i++) {
//	    	String directoryFileName = dir_contents[i].getName();
//	    	System.out.println( ">>>>>>>>>>>>>>>>>>>>>>>>" + directoryFileName);
//	    	if (directoryFileName != null && !directoryFileName.isEmpty()) {
//	    		String[] names = directoryFileName.split(".");
//	    		System.out.println("<<<<<<<<<<<<<<<<<<<<<<" + names.length);
////		        if (names[0].equals(fileName))
////		            return flag=true;
//		    }
//	    }
//	    return flag;
//	}
	
	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().contains(fileName))
	            return flag=true;
	            }

	    return flag;
	}



}
