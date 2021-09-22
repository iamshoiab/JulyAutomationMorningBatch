package com.page_object_model1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiPage2 
{
	public ActiPage2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//UserName Field
	private WebElement username;
	public WebElement getUserName()
	{
		return username;
	}
	
	//Password Field
	private WebElement pwd;
	public WebElement getPassword()
	{
		return pwd;
	}
	
	//Login Field
	@FindBy(xpath="//*[@id=\'loginButton\']/div")
	private WebElement oLogin;
	public WebElement clicklogin()
	{
		return oLogin;
	}
	
	//Flyover tab
	private WebElement gettingStartedShortcutsMenuCloseId;
	public WebElement minimize()
	{
		return gettingStartedShortcutsMenuCloseId;
	}
	
	//Click Users
	@FindBy(xpath="//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a")
	private WebElement oUsers;
	public WebElement clickUsers()
	{
		return oUsers;
	}
	
	//Click Add-Users
	@FindBy(xpath="//*[@id=\'createUserDiv\']/div/div[2]")
	private WebElement oAddUsers;
	public WebElement clickAddUsers()
	{
		return oAddUsers;
	}
	
	//FirstName Field
	private WebElement userDataLightBox_firstNameField;
	public WebElement oFirstName()
	{
		return userDataLightBox_firstNameField;
	}
	
	//LastName Field
	private WebElement lastName;
	public WebElement oLastName()
	{
		return lastName;
	}
	
	//Email Field
	private WebElement email;
	public WebElement oEmail()
	{
		return email;
	}
	
	//password Field
	private WebElement password;
	public WebElement oPassword()
	{
		return password;
	}
	
	//re-password Field
	private WebElement passwordCopy;
	public WebElement oRePassword()
	{
		return passwordCopy;
	}
	
	//createUser click
	@FindBy(xpath="//*[@id=\'userDataLightBox_commitBtn\']/div")
	private WebElement createUser;
	public WebElement oCreateUser()
	{
		return createUser;
	}
	
	//Welcome-popup 
	@FindBy(xpath="//span[@class='startExploringText']")
	private WebElement skip;
	public WebElement oSkipWelcome()
	{
		return skip;
	}
	
	//Userlist Fields
	@FindBy(xpath="//span[contains(text(),'Gill, Abraham')]")
	private WebElement abgill;
	public WebElement oAbrahamgill()
	{
		return abgill;
	}
	
	@FindBy(xpath="//span[contains(text(),'Gill, John')]")
	private WebElement johngill;
	public WebElement oJohngill()
	{
		return johngill;
	}
	
	@FindBy(xpath="//span[contains(text(),'Gill, Simen')]")
	private WebElement simengill;
	public WebElement oSimengill()
	{
		return simengill;
	}
	
	//deleteUsers
	private WebElement userDataLightBox_deleteBtn;
	public WebElement deleteUser()
	{
		return userDataLightBox_deleteBtn;
	}
	
	//Logout Field
	private WebElement logoutLink;
	public WebElement oLogout()
	{
		return logoutLink;
	}
	
	
}
