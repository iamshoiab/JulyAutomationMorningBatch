package com.task;
/*PART 1===launchBrowser-->navigate-->login as admin-->createuser [User1] -->logout ->login as User1-->createUser [User2] -->logout -->

 *login as User2 --> createUser [User3]--> logout-->login as User3 --> logout --> 

 *PART 2===login as User2 -->modify password for User3-->logout --> login as User3 --> logout-->
 *PART 3===login as User1 -->modify password for User2 --> logout -->login as User2 --> logout-->
 *PART 4===login as admin--> modify password for User1 --> logout -->login as User1 --> logout -->
 *PART 5===login as User2 --> Delete User3--> logout --> login as User1 --> delete USer2 --> logout --> login as Admin --> delete User1 --> logout --> 
 *PART 6===closeApplication */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Task10 
{	static WebDriver driver=null;
public static void main(String args[])
{
	createUsers();
	modifychecks1();
	modifychecks2();
	modifychecks3();
	deleteUsers();
	close();	
}

static void createUsers()
{
	try
	{
	launchBrowser();
	navigate();
	loginasAdmin();
	createUser("John", "Gill", "johngill@gmail.com", "User1", "Tiger", "Tiger");
	logout();
	loginasUser("User1","Tiger");
	minimizeWelcome();
	createUser("Adam", "Gill", "adamgill@gmail.com", "User2", "Tiger", "Tiger");
	logout();
	loginasUser("User2","Tiger");
	minimizeWelcome();
	createUser("Simen", "Gill", "simengill@gmail.com", "User3", "Tiger", "Tiger");
	logout();
	loginasUser("User3","Tiger");
	minimizeWelcome();
	logout();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}

static void modifychecks1()
{
	try
	{
	loginasUser("User2","Tiger");
	ModifyUser3password();
	logout();
	loginasUser("User3","Lion");
	logout();		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}

static void modifychecks2()
{
	try
	{
	loginasUser("User1","Tiger");
	ModifyUser2password();
	logout();
	loginasUser("User2","Lion");
	logout();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}

static void modifychecks3()
{
	try
	{
	loginasAdmin();
	ModifyUser1password();
	logout();
	loginasUser("User1","Lion");
	logout();	
	}catch(Exception e)
	{
	e.printStackTrace();
	}
}

static void deleteUsers()
{
	try
	{
	loginasUser("User2","Lion");
	deleteUser3();
	logout();
	loginasUser("User1","Lion");
	deleteUser2();
	logout();
	loginasAdmin();
	deleteUser1();
	logout();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}

static void launchBrowser()
{
	System.setProperty("webdriver.chrome.driver", "G:\\ExampleAutomation\\Automation\\Web-Applicatiob\\Library\\driver\\chromedriver.exe");
	driver=new ChromeDriver();	

//	System.setProperty("webdriver.gecko.driver", "G:\\ExampleAutomation\\Automation\\Web-Applicatiob\\Library\\driver\\geckodriver.exe");
// 	driver=new FirefoxDriver();
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

static void createUser(String fn, String ln, String email, String un, String pw, String repw)
{
	try
	{
		driver.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a")).click(); 			//ClickUser
		driver.findElement(By.xpath("//*[@id=\'createUserDiv\']/div/div[2]")).click();				//ClickAddUser
		Thread.sleep(2000);
		driver.findElement(By.id("userDataLightBox_firstNameField")).sendKeys(fn);					//1FirstName
		driver.findElement(By.id("userDataLightBox_lastNameField")).sendKeys(ln);					//1LastName
		driver.findElement(By.id("userDataLightBox_emailField")).sendKeys(email);					//1EmailID
		driver.findElement(By.id("userDataLightBox_usernameField")).sendKeys(un);					//1UserName
		driver.findElement(By.id("userDataLightBox_passwordField")).sendKeys(pw);					//1password
		driver.findElement(By.id("userDataLightBox_passwordCopyField")).sendKeys(repw);				//1re-password
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'userDataLightBox_commitBtn\']/div/span")).click();	//CreateUser
		Thread.sleep(2000);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}

static void loginasUser(String x, String y)
{
	try
	{
		driver.findElement(By.id("username")).sendKeys(x);
		driver.findElement(By.xpath("//*[@id=\'loginFormContainer\']/tbody/tr[1]/td/table/tbody/tr[2]/td/input")).sendKeys(y);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'loginButton\']/div")).click();
		Thread.sleep(2000);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}

static void minimizeWelcome()
{
	driver.findElement(By.xpath("//*[@id=\'welcomeScreenBoxId\']/div[3]/div/span[1]")).click();
}

static void ModifyUser1password()
{
	try
	{
	driver.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a")).click(); 					//ClickUser
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[1]/td[1]/div/table/tbody/tr/td/div[1]/span[2]")).click(); 	//click-User1
	Thread.sleep(2000);
	modify();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}

static void ModifyUser2password()
{
	try
	{
	driver.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a")).click(); 					//ClickUser
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/span[2]")).click(); 	//click-User2
	Thread.sleep(2000);
	modify();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}

static void ModifyUser3password()
{
	try
	{
	driver.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a")).click(); 					//ClickUser
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[3]/td[1]/table/tbody/tr/td/div[1]/span[2]")).click(); 	//click-User3
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
		Thread.sleep(2000);
		driver.findElement(By.id("userDataLightBox_passwordField")).sendKeys("Lion"); 					//Modify-Password
		driver.findElement(By.id("userDataLightBox_passwordCopyField")).sendKeys("Lion"); 				//Modify-Re-Password
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'userDataLightBox_commitBtn\']/div/span")).click(); 	 	//Click-SaveChanges
		Thread.sleep(2000);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}

static void deleteUser3()
{
	driver.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a/div[1]")).click();
	driver.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[3]/td[1]/table/tbody/tr/td/div[1]/span[2]")).click();
	delete();
}
static void deleteUser2()
{
	driver.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a/div[1]")).click();
	driver.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/span[2]")).click();
	delete();
}
static void deleteUser1()
{
	driver.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a/div[1]")).click();
	driver.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[1]/td[1]/div/table/tbody/tr/td/div[1]/span[2]")).click();
	delete();
}

static void delete()
{
	try
	{
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
