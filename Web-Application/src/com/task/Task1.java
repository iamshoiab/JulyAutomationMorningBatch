package com.task;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//launchBrowser-->navigate-->login-->createUser-->deleteUser-->logout -->closeApplication

public class Task1 {
	static WebDriver driver=null;
	public static void main(String[] args) 
	{
		launchBrowser();
		navigate();
		login();
		createUser();
		deleteUser();
		logout();
		close();
	}
	static void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\ExampleAutomation\\Automation\\Web-Applicatiob\\Library\\driver\\chromedriver.exe");
		driver=new ChromeDriver();		
	}
	
	static void navigate()
	{
		try
		{
			driver.get("http://localhost:82/login.do");
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void login()
	{
		try
		{
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
	
	static void createUser()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'gettingStartedShortcutsMenuCloseId\']")).click();		//FlyWindowClose
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a/div[2]")).click();			//Click-Users
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'createUserDiv\']/div/div[2]")).click();					//Click-AddUsers
			Thread.sleep(2000);
			driver.findElement(By.id("userDataLightBox_firstNameField")).sendKeys("AB"); 					//Enter-FirstName
			Thread.sleep(2000);
			driver.findElement(By.id("userDataLightBox_lastNameField")).sendKeys("Deviliers");				//Enter-LastName	
			Thread.sleep(2000);
			driver.findElement(By.id("userDataLightBox_emailField")).sendKeys("abdeviliers@gmail.com");		//Enter-Email
			Thread.sleep(2000);
			driver.findElement(By.id("userDataLightBox_usernameField")).sendKeys("User1");     				//Enter-UserName
			Thread.sleep(2000);
			driver.findElement(By.id("userDataLightBox_passwordField")).sendKeys("Tiger@123");				//Enter-Password
			Thread.sleep(2000);
			driver.findElement(By.id("userDataLightBox_passwordCopyField")).sendKeys("Tiger@123");			//Enter-Password
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'userDataLightBox_commitBtn\']/div/span")).click();		//Click-Submit
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void deleteUser() 
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[2]/td[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(2000);
			Alert o=driver.switchTo().alert();
			String display=o.getText();
			System.out.println(display);
			o.accept();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void logout()
	{
		try
		{
			driver.findElement(By.id("logoutLink")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void close()
	{
		driver.close();
	}
}
