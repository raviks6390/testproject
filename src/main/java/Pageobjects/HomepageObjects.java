package Pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomepageObjects {

	WebDriver driver;
	WebDriverWait w;
	Robot robot;
	String passCount="2";
	//String depdate = "27102020";
	//String retdate = "27102020";

	@FindBy(xpath = ".//div[contains(text(),'From')]//following-sibling::input")
	WebElement From;
	@FindBy(xpath = ".//div[contains(text(),'To')]//following-sibling::input")
	WebElement To;
	@FindBy(xpath = ".//div[contains(text(),'Departure')]//following-sibling::input")
	WebElement deptDatefield;
	@FindBy(xpath = ".//div[contains(text(),'Return')]//following-sibling::input")
	WebElement retDatefield;
	@FindBy(xpath = ".//div[contains(text(),'Travellers | Class')]//following-sibling::input")
	WebElement passfield;
	@FindBy(xpath = ".//button[contains(text(),'Search')]")
	WebElement searchBtn;
	@FindBy(xpath = "//div[@class='rd-month-label']")
	WebElement monthlable;
	@FindBy(xpath = ".//div[contains(@class,'flight-dep-cal')]//td[@data-date='" +27092020+"']")
	WebElement selectDeptDt;
	@FindBy(xpath = ".//div[contains(@class,'flight-ret-cal')]//td[@data-date='" +27102020+"']")
	WebElement selectReturnDt;
	@FindBy(xpath = ".//div[contains(@class,'passanger-class')]//span[@data-val='"+2+"'])[1]")
	WebElement passcount;

	public HomepageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clearfrom() {
		From.clear();
	}

	public void enterfromaddress(String frm) throws AWTException, InterruptedException {
		From.click();
		From.clear();
		WebDriverWait w=new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='orgn u-ib u-v-align-bottom u-text-left']//input[@class='c-input u-v-align-middle']")));
		driver.findElement(By.xpath("//div[@class='orgn u-ib u-v-align-bottom u-text-left']//input[@class='c-input u-v-align-middle']")).click();
		From.sendKeys("Pune");
		Thread.sleep(10000);
		From.sendKeys(Keys.ENTER);
	}

	public void enterToaddress(String to) throws InterruptedException, AWTException {

		TimeUnit.SECONDS.sleep(5);
		To.click();
		To.clear();
		To.sendKeys("HYD");
		TimeUnit.SECONDS.sleep(3);
		To.sendKeys(Keys.ENTER);
	}

	/*public void clickonDeparturecaltfield() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		
		deptDatefield.click();
		TimeUnit.SECONDS.sleep(3);
		
	}*/

	public void selectdeptdate() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		
		deptDatefield.click();
		TimeUnit.SECONDS.sleep(3);
		
		//TimeUnit.SECONDS.sleep(3);
		//w.until(ExpectedConditions.visibilityOf(monthlable));

		while (!monthlable.getText().equalsIgnoreCase("September 2020")) {

			driver.findElement(By.xpath("//div[contains(@class,'flight-dep-cal')]//button[contains(@class,'rd-next')]"))
					.click();

		}
		selectDeptDt.click();
	}

	public void clickonretcalfield() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		retDatefield.click();
	}

	public void selectretdate() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		selectReturnDt.click();
	}

	public void clickonPassangerfield() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		passfield.click();

	}

	public void selectpasscount() throws InterruptedException {
		String passcount="2";
		passfield.click();
		TimeUnit.SECONDS.sleep(6);
		driver.findElement(By.xpath("(//div[contains(@class,'passanger-class')]//span[@data-val='"+passcount+"'])[1]")).click();

		TimeUnit.SECONDS.sleep(5);
						
	}

	public void clicksearch() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		searchBtn.click();
	}
}
