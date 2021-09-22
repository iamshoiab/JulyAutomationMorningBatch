package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticeTest
{
	public static WebDriver driver=null;
	public static void main(String[] args) 
	{
		chromeDemo();
		login();
	//	close();
	}
	
	static void chromeDemo()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\ExampleAutomation\\Automation\\Web-Applicatiob\\Library\\driver\\chromedriver.exe");
		driver= new ChromeDriver();
	}
	
	static void login()
	{
		try
		{
			driver.get("http://testboxigo.in/contact-us");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void close()
	{
		try
		{
			driver.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
