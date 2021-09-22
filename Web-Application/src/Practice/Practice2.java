package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice2 {
	
	public static void main(String[] args) 
	{
		launch();
		login();
	}
	
	static WebDriver driver=null;
	static void launch()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\ExampleAutomation\\Automation\\Web-Applicatiob\\Library\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	static void login()
	{
		try
		{
			driver.get("http://localhost:82/login.do");
			Thread.sleep(2000);
			driver.findElement(By.id("username")).sendKeys("admin");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'loginFormContainer\']/tbody/tr[1]/td/table/tbody/tr[2]/td/input")).sendKeys("manager");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'loginButton\']/div")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
