package Practice;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeXPath {
	static WebDriver driver=null;
	public static void main(String[] args) throws Throwable {
		launch();
		navigate();
	//	absolutePath();
		tagnameAlone();
		tagnameandIndex();
	//	tagname_AttributeAndValue();
	//	tagname_AttributeAndValue();
	//	tagname_AttributeAndValueUsingAnd();
	//	tagname_AttributeAndValueUsingOr();
	//	UsingAttributeNameValueCombination();
	//	UsingAttributevalueAlone();
		UsinTagname_Attributealone();
	}

	static void launch()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\ExampleAutomation\\Automation\\Web-Applicatiob\\Library\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	static void navigate() throws Throwable
	{
		driver.get("file:///G:\\SG_Notes\\HTML\\HTML NOTES\\tests_2nd_SEPT_2021\\Sample.html");
		Thread.sleep(1000);
	}
	static void absolutePath() throws Throwable
	{
		driver.findElement(By.xpath("html/body/div/form/input")).sendKeys("User1");
		Thread.sleep(1000);
	} 
	
	static void tagnameAlone() throws Throwable
	{
		driver.findElement(By.xpath("//input")).sendKeys("User1");
		Thread.sleep(1000);
	}
	
	static void tagnameandIndex() throws Throwable
	{
		driver.findElement(By.xpath("//input[2]")).sendKeys("Tiger");
		Thread.sleep(1000);
	}
	
	static void tagname_AttributeAndValue() throws Throwable
	{
		driver.findElement(By.xpath("//input[@type='text'][@class='pass1word1']")).sendKeys("Tiger");
		Thread.sleep(1000);
	}
	
	static void tagname_AttributeAndValueUsingAnd() throws Throwable
	{
		driver.findElement(By.xpath("//input[@type='text' and @class='pass1word1']")).sendKeys("Tiger");
		Thread.sleep(1000);
	}
	
	static void tagname_AttributeAndValueUsingOr() throws Throwable
	{
		driver.findElement(By.xpath("//input[@type='button' or @name='submit1btn1' ]")).click();
		Alert a=driver.switchTo().alert();
		a.accept();
	}
	
	static void UsingAttributeNameValueCombination() throws Throwable
	{
		driver.findElement(By.xpath("//*[@type='checkbox']")).click();
	}
	
	static void UsingAttributevalueAlone() throws Throwable
	{
		driver.findElement(By.xpath("//*[@*='checkbox']")).click();
	}
	
	static void UsinTagname_Attributealone() throws Throwable
	{
		List<WebElement> oList=driver.findElements(By.xpath("//*[@*='checkbox']"));
		System.out.println(oList.size());
	}
}
