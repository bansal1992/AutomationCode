package Page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseTest;

public class YatraPage {

	@FindBy(xpath="//*[@id=\"BE_flight_origin_city\"]")
	private WebElement departFrom;



	public YatraPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}




	public void clickDepartFrom() throws InterruptedException {
		departFrom.click();
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
}


