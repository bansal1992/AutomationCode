package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.BaseTest;


public class WelcomePage {
	
	@FindBy(xpath="//*[@id=\"app\"]/div/div[2]/div/div/div/div/div/div/div/input[1]")
	private WebElement userTB;
	
	
	
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setUser(String username) throws InterruptedException {
		userTB.sendKeys(username);
	}
	

	
	public void verifyTime(int time,String xpath) {
	WebDriverWait wait=new WebDriverWait(BaseTest.driver,time);
	try {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	System.out.println("Successfull:Page is taking less than "+time+" seconds to open");
	}
	catch(Exception e) {
		System.out.println("Failure:Page is taking more than "+time+" seconds to open");
	}
	}
	
	public void alertAtPresent(int time) {
		  WebDriverWait wait = new WebDriverWait(BaseTest.driver,time);
		  try {
			  wait.until(ExpectedConditions.alertIsPresent());
			  System.out.println("Alert is present while loging the Application");
			  BaseTest.driver.switchTo().alert().accept();
			  }
		  catch(Exception e) {
			  System.out.println("Alert is not present at starting");
			  
		  }
	  }
	
	public void alertAtPresentRemote(int time) {
		  WebDriverWait wait = new WebDriverWait(BaseTest.driver,time);
		  try {
			  wait.until(ExpectedConditions.alertIsPresent());
			  System.out.println("Alert is present while loging the Application");
			  BaseTest.driver.switchTo().alert().accept();
			  }
		  catch(Exception e) {
			  System.out.println("Alert is not present at starting");
			  
		  }
	  }
	public void homepagetime(int time) throws InterruptedException {
		long starttime = System.currentTimeMillis();
		try {
		WebDriverWait wait = new WebDriverWait(BaseTest.driver,time);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='listingPageBtn']")));
				long endtime = System.currentTimeMillis();
				long finaltime=endtime-starttime;
				System.out.println("Success: Home Page is taking "+finaltime+" ms to open");
		         
		}
		catch(Exception e) {
			long endtime = System.currentTimeMillis();
			long finaltime=endtime-starttime;
			System.out.println("Failure:Test Case Failed Because Home Page is taking more than "+finaltime+" ms to open");
			
		}
		
	}
	

}
