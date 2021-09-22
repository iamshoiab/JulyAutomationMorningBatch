package com.task;
/* launchBrowser-->navigate-->login as admin-->createuser [User1,User2,User3] -->logout--->
 * login as User1--->logout-->Login as User2 --> logout -->login as User3 --> logout-->
 * login as admin [modify the password for User1,User2,User3]--> logout -->
 * login as User1--->logout-->Login as User2 --> logout -->login as User3 --> logout-->
 * login as Admin--> Delete [User1,User2,User3]-->logout -->closeApplication */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Task9 
{
	static WebDriver driver=null;
	public static void main(String[] args) 
	{
		AdminTask1();
		loginasUsers1();
		AdminTask2();
		loginasUsers2();
		AdminTask3();
		close();
	}

	static void AdminTask1()
	{
		launchBrowser();
		navigate();
		loginasAdmin();
		createUsers();	
		logout();
	}

	static void AdminTask2()
	{
		loginasAdmin();
		modifyUsersPassword();
		logout();
	}

	static void AdminTask3()
	{
		loginasAdmin();
		deleteUsers();
		logout();
	}

	static void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\ExampleAutomation\\Automation\\Web-Applicatiob\\Library\\driver\\chromedriver.exe");
		driver=new ChromeDriver();		
		
	//	System.setProperty("webdriver.gecko.driver", "G:\\ExampleAutomation\\Automation\\Web-Applicatiob\\Library\\driver\\geckodriver.exe");
	//	driver=new FirefoxDriver();
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

	static void loginasAdmin()
	{
		try
		{
			driver.findElement(By.id("username")).sendKeys("admin");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'loginFormContainer\']/tbody/tr[1]/td/table/tbody/tr[2]/td/input")).sendKeys("manager");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'loginButton\']/div")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'gettingStartedShortcutsMenuCloseId\']")).click();		//FlyWindowClose
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	static void createUsers()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a")).click(); 			//ClickUser
			driver.findElement(By.xpath("//*[@id=\'createUserDiv\']/div/div[2]")).click();				//ClickAddUser
			driver.findElement(By.id("userDataLightBox_firstNameField")).sendKeys("John");				//1FirstName
			driver.findElement(By.id("userDataLightBox_lastNameField")).sendKeys("Gill");				//1LastName
			driver.findElement(By.id("userDataLightBox_emailField")).sendKeys("johnuser1@gmail.com");	//1EmailID
			driver.findElement(By.id("userDataLightBox_usernameField")).sendKeys("User1");				//1UserName
			driver.findElement(By.id("userDataLightBox_passwordField")).sendKeys("Tiger");				//1password
			driver.findElement(By.id("userDataLightBox_passwordCopyField")).sendKeys("Tiger");			//1re-password
			driver.findElement(By.xpath("//*[@id=\'userDataLightBox_commitBtn\']/div/span")).click();	//CreateUser

			driver.findElement(By.xpath("//*[@id=\'createUserDiv\']/div/div[2]")).click();				//ClickAddUser
			driver.findElement(By.id("userDataLightBox_firstNameField")).sendKeys("Adam");				//1FirstName
			driver.findElement(By.id("userDataLightBox_lastNameField")).sendKeys("Gill");				//1LastName
			driver.findElement(By.id("userDataLightBox_emailField")).sendKeys("adamuser2@gmail.com");	//1EmailID
			driver.findElement(By.id("userDataLightBox_usernameField")).sendKeys("User2");				//1UserName
			driver.findElement(By.id("userDataLightBox_passwordField")).sendKeys("Tiger");				//1password
			driver.findElement(By.id("userDataLightBox_passwordCopyField")).sendKeys("Tiger");			//1re-password
			driver.findElement(By.xpath("//*[@id=\'userDataLightBox_commitBtn\']/div/span")).click();	//CreateUser

			driver.findElement(By.xpath("//*[@id=\'createUserDiv\']/div/div[2]")).click();				//ClickAddUser
			driver.findElement(By.id("userDataLightBox_firstNameField")).sendKeys("Simen");				//1FirstName
			driver.findElement(By.id("userDataLightBox_lastNameField")).sendKeys("Gill");				//1LastName
			driver.findElement(By.id("userDataLightBox_emailField")).sendKeys("simenuser3@gmail.com");	//1EmailID
			driver.findElement(By.id("userDataLightBox_usernameField")).sendKeys("User3");				//1UserName
			driver.findElement(By.id("userDataLightBox_passwordField")).sendKeys("Tiger");				//1password
			driver.findElement(By.id("userDataLightBox_passwordCopyField")).sendKeys("Tiger");			//1re-password
			driver.findElement(By.xpath("//*[@id=\'userDataLightBox_commitBtn\']/div/span")).click();	//CreateUser
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	static void loginasUsers1()
	{
		try
		{
			driver.findElement(By.id("username")).sendKeys("User1");
			Thread.sleep(2000);
			password();
			logout();

			driver.findElement(By.id("username")).sendKeys("User2");
			Thread.sleep(2000);
			password();
			logout();

			driver.findElement(By.id("username")).sendKeys("User3");
			Thread.sleep(2000);
			password();
			logout();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	static void password()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'loginFormContainer\']/tbody/tr[1]/td/table/tbody/tr[2]/td/input")).sendKeys("Tiger");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'loginButton\']/div")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'welcomeScreenBoxId\']/div[3]/div/span[1]")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	static void modifyUsersPassword()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a")).click(); 			//Click-Users
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[1]/td[1]/div/table/tbody/tr/td/div[1]/span[2]")).click(); 	//ClickUser1
			Thread.sleep(2000);
			modify();

			driver.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/span[2]")).click(); 	//ClickUser2
			Thread.sleep(2000);
			modify();

			driver.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[3]/td[1]/table/tbody/tr/td/div[1]/span[2]")).click(); 	//ClickUser3
			Thread.sleep(2000);
			modify();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	static void modify()
	{
		try
		{
			driver.findElement(By.id("userDataLightBox_passwordField")).sendKeys("Lion"); 					//Modify-Password
			Thread.sleep(2000);
			driver.findElement(By.id("userDataLightBox_passwordCopyField")).sendKeys("Lion"); 				//Modify-Re-Password
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'userDataLightBox_commitBtn\']/div/span")).click(); 	 	//Click-SaveChanges
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	static void loginasUsers2()
	{
		try
		{
			driver.findElement(By.id("username")).sendKeys("User1");
			Thread.sleep(2000);
			repassword();
			logout();

			driver.findElement(By.id("username")).sendKeys("User2");
			Thread.sleep(2000);
			repassword();
			logout();

			driver.findElement(By.id("username")).sendKeys("User3");
			Thread.sleep(2000);
			repassword();
			logout();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	static void repassword()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'loginFormContainer\']/tbody/tr[1]/td/table/tbody/tr[2]/td/input")).sendKeys("Lion");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'loginButton\']/div")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	static void deleteUsers()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a")).click(); 				//Click-Users
			Thread.sleep(2000);
			
			
			for(int i=1; i<=3; i++)
			{
				delete();
			}
			
		/*	driver.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[1]/td[1]/div/table/tbody/tr/td/div[1]/span[2]")).click(); 		//Click-User1
			Thread.sleep(2000);
			delete();
			
			driver.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[1]/td[1]/div/table/tbody/tr/td/div[1]/span[2]")).click(); 		//Click-User2
			Thread.sleep(2000);
			delete();
			
			driver.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[1]/td[1]/div/table/tbody/tr/td/div[1]/span[2]")).click(); 		//Click-User3
			Thread.sleep(2000);
			delete();		*/
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	static void delete()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[1]/td[1]/div/table/tbody/tr/td/div[1]/span[2]")).click(); 		//Click-User1
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\'userDataLightBox_deleteBtn\']")).click(); 				//Click-Delete
			Thread.sleep(2000);
			Alert a=driver.switchTo().alert();
			a.accept();
			Thread.sleep(2000);
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
