package Generic;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class BaseTest implements IAutoConst{
	public static WebDriver driver;
	String baseUrl,nodeUrl;
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		//System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	@BeforeMethod()
	public void openApplication() throws Exception {
		
		MyScreenRecorder.startRecording("Video-Recording");
		//System.out.println("Starting new task");
		driver=new ChromeDriver();
		Thread.sleep(3000);
		try {
		driver.manage().window().maximize();
		}
		catch(Exception e) {
			System.out.println("Issue with window maximize.Let open browser again");
			driver.quit();
			Thread.sleep(2000);
			driver=new ChromeDriver();	
			driver.manage().window().maximize();
		}
		Thread.sleep(2000);
		String AUT = AUL.getProperty(SETTING_PATH, "AUT");
		driver.get(AUT);
		Thread.sleep(2000);
//		Robot r = new Robot();
//		r.keyPress(KeyEvent.VK_F12);
//		r.keyRelease(KeyEvent.VK_F12);
		String strITO = AUL.getProperty(SETTING_PATH, "ITO");
		long ITO = Long.parseLong(strITO);
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
                                  }
	
	@AfterMethod()
	public void afterMethod() throws Exception {
		MyScreenRecorder.stopRecording();
		//System.out.println("One task is completed");
		driver.quit();
		
	}
	
	



}
