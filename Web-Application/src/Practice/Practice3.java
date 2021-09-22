package Practice;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

// Get Page Source using Selenium Java Webdriver
public class Practice3 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", "G:\\ExampleAutomation\\Automation\\Web-Applicatiob\\Library\\driver\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		//	driver=new FirefoxDriver();
		driver.get("Example.com");
		String pagesource=driver.getPageSource();
		System.out.println(pagesource);
		driver.close();
	}

}
