package TestCases;

import java.awt.Robot;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;





public class test2 {
	
	
	@Test
	public void test3() throws InterruptedException
	{
		List<WebElement> priceList = null;
		List<WebElement> flightsummary=null;
		{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rsamadap\\Desktop\\Ravi_Test\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Robot robot = new Robot();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.ixigo.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());


			driver.get("https://www.ixigo.com/");
			TimeUnit.SECONDS.sleep(3);

			WebElement from=driver.findElement(By.xpath(".//div[contains(text(),'From')]//following-sibling::input"));
			//List<WebElement> cityList=driver.findElements(By.xpath("//div[@class='autocompleter-scroll-cntr']//div[@class='city']"));

			WebElement to=driver.findElement(By.xpath(".//div[contains(text(),'To')]//following-sibling::input"));
			WebElement deptDate=driver.findElement(By.xpath(".//div[contains(text(),'Departure')]//following-sibling::input"));
			WebElement retDate=driver.findElement(By.xpath(".//div[contains(text(),'Return')]//following-sibling::input"));
			WebElement pass=driver.findElement(By.xpath(".//div[contains(text(),'Travellers | Class')]//following-sibling::input"));
			WebElement searchBtn=driver.findElement(By.xpath(".//button[contains(text(),'Search')]"));
			String passCount="2";
			String date="27092020";
			String rdate="29102020";
			//WebElement departureCalander=driver.findElement(By.xpath("//div[contains(@class,'flight-dep-cal')]"));
			//WebElement retcalander=driver.findElement(By.xpath("//div[contains(@class,'flight-ret-cal')]"));
				
			WebElement calnextbutton;
			from.click();
			from.clear();
			WebDriverWait w=new WebDriverWait(driver, 10);
			w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='orgn u-ib u-v-align-bottom u-text-left']//input[@class='c-input u-v-align-middle']")));
			driver.findElement(By.xpath("//div[@class='orgn u-ib u-v-align-bottom u-text-left']//input[@class='c-input u-v-align-middle']")).click();
			from.sendKeys("Pune");
			Thread.sleep(10000);
			from.sendKeys(Keys.ENTER);

			TimeUnit.SECONDS.sleep(5);
			to.click();
			to.clear();
			to.sendKeys("HYD");
			TimeUnit.SECONDS.sleep(3);
			to.sendKeys(Keys.ENTER);


			deptDate.click();
			TimeUnit.SECONDS.sleep(3);
			WebElement monthlable=driver.findElement(By.xpath("//div[@class='rd-month-label']"));
			//calnextbutton=driver.findElement(By.xpath("//button[contains(@class,'rd-next')]"));
			while(!monthlable.getText().equalsIgnoreCase("September 2020"))
			{
				
				driver.findElement(By.xpath("//div[contains(@class,'flight-dep-cal')]//button[contains(@class,'rd-next')]")).click();
				
				
			}
			
			
			//driver.findElement(By.xpath("//td[@data-date='"+date+"']")).click();
			driver.findElement(By.xpath("//div[contains(@class,'flight-dep-cal')]//td[@data-date='27092020']")).click();
			TimeUnit.SECONDS.sleep(3);
			
			retDate.click();
			TimeUnit.SECONDS.sleep(3);
			
			/*while(!monthlable.getText().equalsIgnoreCase("October 2020"))
			{
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[contains(@class,'flight-ret-cal')]//button[contains(@class,'rd-next')]")).click();
				
				
			}*/
			
			//driver.findElement(By.xpath("//td[@data-date='"+rdate+"']")).click();
			driver.findElement(By.xpath("//div[contains(@class,'flight-ret-cal')]//td[@data-date='27102020']")).click();
			TimeUnit.SECONDS.sleep(3);

			pass.click();
			TimeUnit.SECONDS.sleep(3);
			driver.findElement(By.xpath("(//div[contains(@class,'passanger-class')]//span[@data-val='"+passCount+"'])[1]")).click();

			TimeUnit.SECONDS.sleep(3);
			searchBtn.click();

			
		//driver.findElement(By.xpath("(//div[@class='stops']/span/div[1]")).click();
			Thread.sleep(20000);
			//WebElement stopfilters=driver.findElement(By.xpath(".//span[@class='checkbox-list'] //div[contains(text(),'Non stop')]"));
			/*WebElement stops=driver.findElement(By.xpath("//div[@class='stops']//div[@data-checkboxindex='0']"));
			w.until(ExpectedConditions.elementToBeClickable(stops));
			stops.click();
			TimeUnit.SECONDS.sleep(5);*/

		
			TimeUnit.SECONDS.sleep(10);
			//driver.findElement(By.xpath("(//div[@class='stops']/span[@class='checkbox-list']//div)[1]")).click();
			
			for(int i=0;i<30;i++)
			{
				
			priceList=driver.findElements(By.xpath(".//div[@class='summary-section']//div[@class='price-section']"));
		//ist<WebElement> bookList=driver.findElements(By.xpath(".//div[@class='summary-section']//div[@class='book-cta']"));
			flightsummary=driver.findElements(By.xpath(".//div[@class='summary-section']//div[@class='flight-summary']"));
			//List<WebElement> airlinesinfo=driver.findElements(By.xpath(".//div[@class='summary-section']//div[@class='airline-info']"));
			//java.util.List<WebElement> inflights=(java.util.List<WebElement>) driver.findElements(By.xpath(".//div[@class='summary-section']//div[@class='inFlight-info']"));
			}
			
			
			System.out.println(priceList.size());
			//stem.out.println(bookList.size());
			System.out.println(flightsummary.size());
			
			
			/*for(int i=0;i<priceList.size();i++) 
			{

				
			if(Integer.parseInt(priceList.get(i).getText())<5000)
			{
				
				//System.out.println(flightsummary.get(i).getText());

				System.out.println(priceList.get(i).getText());
				
			}
			}*/

			//driver.quit();
		}
		
			//TimeUnit.SECONDS.sleep(10);
		

	}
}

