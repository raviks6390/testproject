package Resources;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Utilities {
	
	static WebDriver driver;
	static String url;
	
	
	
	@Test
	public static WebDriver setDriver() throws IOException
	
	{
		Properties p=new Properties();
		FileInputStream fi=new FileInputStream("C:\\Users\\rsamadap\\eclipse-workspace\\test\\src\\main\\java\\Resources\\Config.properties");
		p.load(fi);
		
		
		if(p.getProperty("Browser").equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\rsamadap\\Desktop\\Ravi_Test\\chromedriver.exe");
			 driver=new ChromeDriver();
		}
		else if(p.getProperty("Browser").equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecho.driver","C:\\Users\\rsamadap\\Desktop\\Ravi_Test\\gecho.exe");
			 driver=new FirefoxDriver();
			
		}
		
		else if(p.getProperty("Browser").equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Users\\rsamadap\\Desktop\\Ravi_Test\\ie.exe");
			 driver=new InternetExplorerDriver();
			
		}
		
		return driver;
		
		
	
	}
	
	public static String seturl() throws IOException
	{
		Properties p=new Properties();
		FileInputStream fi=new FileInputStream("C:\\Users\\rsamadap\\eclipse-workspace\\test\\src\\main\\java\\Resources\\Config.properties");
		p.load(fi);
		String url=p.getProperty("Url");
		return url;
		
	}

	
}
