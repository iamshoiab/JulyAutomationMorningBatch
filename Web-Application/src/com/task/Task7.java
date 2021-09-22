package com.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//launchBrowser-->navigate-->login-->createCustomer-->CreateProject-->Create Tasks -->Delete Tasks -->DeleteProject-->deleteCustomer-->logout -->closeApplication
public class Task7 {
	static WebDriver driver=null;
	public static void main(String[] args) 
	{
		launchBrowser();
		navigate();
		login();
		createCustomer();
		createProject();
		createTask();
		deleteTask();
		deleteProject();
		deleteCustomer();
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
			driver.findElement(By.xpath("//*[@id=\'gettingStartedShortcutsMenuCloseId\']")).click();		//FlyWindowClose
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void createCustomer()
	{
		try
		{
		driver.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr/td[3]/a/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[1]/div[2]/div/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[14]/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("customerLightBox_nameField")).sendKeys("NOMAD");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'customerLightBox_commitBtn\']/div/span")).click();
		Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void createProject()		
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[1]/div[2]/div/div[2]")).click();		//Add-New
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[14]/div[2]")).click(); 										//New-Project
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'projectPopup_projectNameField\']")).sendKeys("DigitalWelbeing");		//Add-NameofProject
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'projectPopup_projectDescriptionField\']")).sendKeys("This Application shows the total duration of Mobile Used"); //description
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"projectPopup_commitBtn\"]/div/span")).click();					//Create Project
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void modifyProject()
	{
		try
		{
		driver.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div[3]")).click();	//Edit-click
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[4]/div[1]/div[2]/div[2]/div/div[1]")).click();		//Name-Edit
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[4]/div[1]/div[2]/div[2]/div/div[2]/input")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[4]/div[1]/div[2]/div[2]/div/div[2]/input")).sendKeys("Digi WelBeing"); 	//Rename
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[4]/div[1]/div[1]")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void createTask()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[1]/div[1]/div[3]/div/div[2]")).click();		//Add-newTask
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div[13]/div[1]")).click();		//Create new Task
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'createTasksPopup_createTasksTableContainer\']/table/tbody/tr[1]/td[1]/input")).sendKeys("Check Login - Logout");	//1-Taskname
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'createTasksPopup_createTasksTableContainer\']/table/tbody/tr[1]/td[5]/div/input")).click();		//1-checkbox
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'createTasksPopup_createTasksTableContainer\']/table/tbody/tr[2]/td[1]/input")).sendKeys("Check time recording of applications");		//2- Taskname
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"createTasksPopup_createTasksTableContainer\"]/table/tbody/tr[2]/td[5]/div/input")).click();		//2-checkbox
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'createTasksPopup_commitBtn\']/div/span")).click();		//Create Task
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void deleteTask()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[1]/table/tbody/tr/td[1]/div/div")).click();		//SelectallTasks
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[1]/div[3]/div/div/div[4]/span")).click();		//Delete-Task
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'deleteTaskPopup_deleteConfirm_submitTitle\']")).click();		//Confirm-Delete
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void deleteProject()
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div[3]")).click(); //Edit-button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[4]/div[1]/div[2]/div[3]/div/div")).click();		//Action-click
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[4]/div[4]/div/div[3]/div")).click();		//Delete-Button
			Thread.sleep(2000);
			driver.findElement(By.id("projectPanel_deleteConfirm_submitTitle")).click(); 				//Delete-Permanently
			Thread.sleep(2000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void deleteCustomer()
	{
		try
		{
		driver.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[4]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[1]/div[4]/div/div/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[4]/div/div[3]/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("customerPanel_deleteConfirm_submitTitle")).click();
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
