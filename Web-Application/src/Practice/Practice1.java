package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Practice1 
{
	public static WebDriver driver=null;
	public static void main(String[] args) 
	{
		chromeDemo();
	//	firefoxDemo();
	//	login();
	//	close();
	}
	
	static void chromeDemo()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\ExampleAutomation\\Automation\\Web-Applicatiob\\Library\\driver\\chromedriver.exe");
		driver= new ChromeDriver();
	}
	
	static void firefoxDemo()
	{
		System.setProperty("webdriver.gecko.driver", "G:\\ExampleAutomation\\Automation\\Web-Applicatiob\\Library\\driver\\geckodriver.exe");
		driver=new FirefoxDriver();		
	}
	
	static void login()
	{
		try
		{
			driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fref%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
			driver.findElement(By.id("ap_email")).sendKeys("msfshoiab7@gmail.com");
			driver.findElement(By.id("continue")).click();
			driver.findElement(By.id("ap_password")).sendKeys("9845467134s");
			Thread.sleep(2000);
			driver.findElement(By.id("signInSubmit")).click();
			Thread.sleep(6000);
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
