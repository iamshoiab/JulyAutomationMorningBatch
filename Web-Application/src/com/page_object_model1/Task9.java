package com.page_object_model1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

/* task1 ==launchBrowser-->navigate-->login as admin-->createuser [User1,User2,User3] -->logout--->

 * task2 ==login as User1--->logout-->Login as User2 --> logout -->login as User3 --> logout-->
 * task3 ==login as admin [modify the password for User1,User2,User3]--> logout -->
 * task4 ==login as User1--->logout-->Login as User2 --> logout -->login as User3 --> logout-->
 * task5 ==login as Admin--> Delete [User1,User2,User3]-->logout -->closeApplication */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task9 {

	public static void main(String[] args)  
	{
		launch();
		browse();
		task1();
		task2();
		task3();
		task4();
		task5();
		close();
		
	}
	static WebDriver driver=null;
	static ActiPage2 oPagenew=null;
	
	static void task1()
	{	
		login("admin","manager");	
		oPagenew.minimize().click();
		oPagenew.clickUsers().click();
		createUsers("John","Gill","johngill@gmail.com","User1","Tiger","Tiger");
		createUsers("Abraham","Gill","abrahamgill@gmail.com","User2","Tiger","Tiger");
		createUsers("Simen","Gill","simengill@gmail.com","User3","Tiger","Tiger");
		oPagenew.oLogout().click();
	}
	
	static void task2()
	{	try {
		login("User1","Tiger");
		Thread.sleep(2000);
		oPagenew.oLogout().click();
		login("User2","Tiger");
		Thread.sleep(2000);
		oPagenew.oLogout().click();
		login("User3","Tiger");
		Thread.sleep(2000);
		oPagenew.oLogout().click();
		}catch(Exception e)
		{
		e.printStackTrace();
		}
	}
	
	static void task3()
	{	try	{
		login("admin","manager");
		Thread.sleep(2000);
		oPagenew.clickUsers().click();
		Thread.sleep(2000);
		oPagenew.oAbrahamgill().click();
		modifyPassword();
		oPagenew.oJohngill().click();
		modifyPassword();
		oPagenew.oSimengill().click();
		modifyPassword();
		Thread.sleep(5000);
		oPagenew.oLogout();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
	
	static void task4()
	{	try {
		login("User1","Lion");
		Thread.sleep(3000);
		oPagenew.oLogout().click();
		login("User2","Lion");
		Thread.sleep(3000);
		oPagenew.oLogout().click();
		login("User3","Lion");
		Thread.sleep(3000);
		oPagenew.oLogout().click();
		}catch(Exception e)
		{
		e.printStackTrace();
		}
	}
	
	static void task5()
	{	try {
		Thread.sleep(3000);
		login("admin","manager");
		Thread.sleep(3000);
		oPagenew.clickUsers().click();
		Thread.sleep(3000);
		oPagenew.oAbrahamgill().click();
		deleteUsers();
		oPagenew.oJohngill().click();
		deleteUsers();
		oPagenew.oSimengill().click();
		deleteUsers();
		Thread.sleep(3000);
		oPagenew.oLogout();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void launch()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\ExampleAutomation\\Automation\\Web-Applicatiob\\Library\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		oPagenew= new ActiPage2(driver);
	}
	
	static void browse()
	{
		driver.get("http://localhost:82/login.do");
	}
	
	static void login(String x, String y)
	{	try {
		oPagenew.getUserName().sendKeys(x);
		Thread.sleep(2000);
		oPagenew.getPassword().sendKeys(y);
		Thread.sleep(2000);
		oPagenew.clicklogin().click();
		if(y=="Tiger")
		{
			oPagenew.oSkipWelcome().click();
		}
		Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void minimize()
	{
		oPagenew.minimize().click();
	}
	
	static void createUsers(String fn,String ln,String email,String un,String pwd, String repwd)
	{	try {
		Thread.sleep(2000);
		oPagenew.clickAddUsers().click();
		Thread.sleep(2000);
		oPagenew.oFirstName().sendKeys(fn);
		oPagenew.oLastName().sendKeys(ln);
		oPagenew.oEmail().sendKeys(email);
		oPagenew.getUserName().sendKeys(un);
		oPagenew.oPassword().sendKeys(pwd);
		oPagenew.oRePassword().sendKeys(repwd);
		Thread.sleep(2000);
		oPagenew.oCreateUser().click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void modifyPassword()
	{	try	{
		Thread.sleep(2000);
		oPagenew.oPassword().sendKeys("Lion");
		oPagenew.oRePassword().sendKeys("Lion");
		Thread.sleep(2000);
		oPagenew.oCreateUser().click();
		Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void deleteUsers()
	{	try {
		Thread.sleep(2000);
		oPagenew.deleteUser().click();
		Thread.sleep(2000);
		Alert a=driver.switchTo().alert();
		a.accept();
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