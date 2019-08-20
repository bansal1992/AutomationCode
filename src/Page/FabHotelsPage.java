package Page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseTest;

public class FabHotelsPage {

	@FindBy(xpath="//*[@id=\"datepicker\"]/div[1]/div/input")
	private WebElement From;



	public FabHotelsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}




	public void clickFrom() throws InterruptedException {
		From.click();
	}


	public void setLocation(String locationfrom,String locationto) throws InterruptedException {
		try {
			BaseTest.driver.findElement(By.xpath("//div[@class='ac_results origin_ac']/ul/div/div/div/li/div/p[contains(text(),'"+locationfrom+"')]")).click();
		}
		catch(Exception e) {
			System.out.println("Oops: Depart From City is not present in drop down");
		}
		Thread.sleep(2000);
		try {
			BaseTest.driver.findElement(By.xpath("//div[@class='ac_results dest_ac']/ul/div/div/div/li/div/p[contains(text(),'"+locationto+"')]")).click();
		}
		catch(Exception e) {
			System.out.println("Oops: Going To City is not present in drop down");
		}
		Thread.sleep(3000);
	}
	
	
	
	public void setDate(String monthyearfrom, String datefrom,String monthyearto, String dateto ) throws InterruptedException {
		
		String actual = BaseTest.driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr[2]//th[2]")).getText();
		String actual1 = BaseTest.driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr[2]//th[2]")).getText();
		
		System.out.println(actual);
		System.out.println(actual1);
		
		while( !actual.contains(monthyearfrom)) {
			BaseTest.driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr[2]//th[3]")).click();
			Thread.sleep(2000);
			actual = BaseTest.driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr[2]//th[2]")).getText();
		}
		
		try {
			BaseTest.driver.findElement(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td[contains(text(),'"+datefrom+"') and (@class='day' or @class='today day' or @class='selected range-end day' or @class='active selected range-start day' or @class='today active selected range-start day')]")).click();
		}
		catch(Exception e){
			System.out.println("Required from date is not present in required month");
		}
		
		Thread.sleep(2000);
		
		while(! actual1.contains(monthyearto)) {
			BaseTest.driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr[2]//th[3]")).click();
			Thread.sleep(2000);
			actual1 = BaseTest.driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr[2]//th[2]")).getText();
		}
		
		try {
			BaseTest.driver.findElement(By.xpath("//div[@class='datepicker-days']/table/tbody/tr/td[contains(text(),'"+dateto+"') and (@class='day' or @class='today day' or @class='selected range-end day' or @class='active selected range-start day' or @class='today active selected range-start day')]")).click();
		}
		catch(Exception e){
			System.out.println("Required to date is not present in required month");
		}
		
		
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

