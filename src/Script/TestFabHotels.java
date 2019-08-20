package Script;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Generic.BaseTest;
import Generic.Excel;
import Page.YatraPage;
import Page.FabHotelsPage;
import Page.WelcomePage;

public class TestFabHotels extends BaseTest {

	@Test(retryAnalyzer=Generic.RetryAnalyzer.class)
	public void testFabHotels() throws Exception {
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("OS Used is "+os);

		//Set UserName TextBox
		WelcomePage wp=new WelcomePage(driver);
		wp.homepagetime(1800);
		Thread.sleep(2000);

		FabHotelsPage rs =new FabHotelsPage(driver);
		
		
			try {
				
				rs.clickFrom();
				Thread.sleep(1000);
				rs.setDate("August 2019", "20", "August 2019", "25");
				Thread.sleep(5000);
				//click on search button
				BaseTest.driver.findElement(By.xpath("//*[@id=\"listingPageBtn\"]")).click();
				
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Oops: Some issue");
			}
		

		System.out.println("************************************TestCase is Successfully Completed****************************");		


	}


























}