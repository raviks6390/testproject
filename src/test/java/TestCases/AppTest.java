package TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.expectThrows;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pageobjects.HomepageObjects;
import Resources.Utilities;

class AppTest extends Utilities {

	WebDriver driver;
	String url;
	HomepageObjects homepage;

	@BeforeTest
	public void setup() throws IOException {
		driver = Utilities.setDriver();
		url = Utilities.seturl();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homepage = new HomepageObjects(driver);

	}

	@Test
	public void validateUrl() throws AWTException, InterruptedException {

		driver.get(url);
		driver.manage().window().maximize();
		assertEquals("https://www.ixigo.com/", driver.getCurrentUrl());
		//driver.close();
	}

	@Test
	public void searchflights() throws AWTException, InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		homepage.clearfrom();
		homepage.enterfromaddress("Pune");
		homepage.enterToaddress("Hyd");
		//homepage.clickonDeparturecaltfield();
		homepage.selectdeptdate();
		homepage.clickonretcalfield();
		homepage.selectretdate();
		//homepage.clickonPassangerfield();
		homepage.selectpasscount();
		homepage.clicksearch();
		TimeUnit.SECONDS.sleep(5);
		Assert.assertTrue(true);
		

	}
	
	@Test(dependsOnMethods="searchflights")
	public void grabSearchresults()
	{

		List<WebElement> priceList = null;
		List<WebElement> flightsummary=null;
	priceList=driver.findElements(By.xpath(".//div[@class='summary-section']//div[@class='price-section']"));
	flightsummary=driver.findElements(By.xpath(".//div[@class='summary-section']//div[@class='flight-summary']"));
	System.out.println(priceList.size());
		//to grab the search results
		for(int i=0;i<priceList.size();i++) 
		{
	
		if(Integer.parseInt(priceList.get(i).getText())<5000)
		{
			
			//System.out.println(flightsummary.get(i).getText());

			System.out.println(priceList.get(i).getText());
			System.out.println(flightsummary.get(i).getText());
			
		}
		}
		
		}
		
		
		
	}
	
	


