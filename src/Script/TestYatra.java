package Script;

import org.testng.annotations.Test;
import Generic.BaseTest;
import Generic.Excel;
import Page.YatraPage;
import Page.WelcomePage;

public class TestYatra extends BaseTest {

	@Test(retryAnalyzer=Generic.RetryAnalyzer.class)
	public void testYatra() throws Exception {
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("OS Used is "+os);

		//Set UserName TextBox
		WelcomePage wp=new WelcomePage(driver);
		wp.homepagetime(1800);
		Thread.sleep(2000);

		YatraPage rs =new YatraPage(driver);
		int rc=Excel.getRowCount(XL_PATH,"Yatra");
		System.out.println("Total Number of Rows Present in Yatra Sheet is "+rc);

		for(int i=1;i<=rc;i++) {
			try {
				String locationfrom=Excel.getCellValue1(XL_PATH,"Yatra",i,0);
				String locationto=Excel.getCellValue1(XL_PATH,"Yatra",i,1);
				
				rs.clickDepartFrom();
				Thread.sleep(3000);
				rs.setLocation(locationfrom,locationto);
				
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Oops: Some issue with input data or application, so starting same testcase with next input if present");
			}
		}

		System.out.println("************************************TestCase with Multiple Inputs is Successfully Completed****************************");		


	}


























}
