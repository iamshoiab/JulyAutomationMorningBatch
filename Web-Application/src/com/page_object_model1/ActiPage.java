package com.page_object_model1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiPage {
	public ActiPage(WebDriver oBrowser)
	{
		PageFactory.initElements(oBrowser, this);
	}

	//User Name Text Field
	private WebElement username;
	public WebElement getUserName()
	{
		return username;
	}
	
	//Password Text Field
	private WebElement pwd;
	public WebElement getPassword()
	{
		return pwd;
	}
	
	//Login button Field
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement oLogin;
	public WebElement getLoginButton()
	{
		return oLogin;
	}
	
	//Fly Out Window Field
	private WebElement gettingStartedShortcutsPanelId;
	public WebElement getFlyOutWin()
	{
		return gettingStartedShortcutsPanelId;
	}
	
	//Logout Link Field
	@FindBy(linkText="Logout")
	private WebElement oLogout;
	public WebElement getLogout()
	{
		return oLogout;
	}
}
