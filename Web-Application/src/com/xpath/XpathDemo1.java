package com.xpath;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class XpathDemo1 {
	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		absoluteXPath();
	//	relativeXPathUsingTagNameAlone();
	//	relativeXPathUsingTagNameAndIndex();
	//	relativeXPathUsingTagNameWithAttributeNameValue();
	//	relativeXPathUsingTagNameWithMultipleAttributeNameValues();
	//	relativeXPathUsingTagNameWithMultipleAttributeNameValuesUsingAndOperator();
	//	relativeXPathUsingTagNameWithMultipleAttributeNameValuesUsingOrOperator();
	//	relativeXPathUsingAttributeNameValueCombination();
	//	relativeXPathUsingAttributeValueAlone();
	//	relativeXPathUsingTagNameAndAttributeNameAlone();
	//	relativeXPathUsingTagNameAndAttributeNameAlone2();
	//	relativeXPathUsingTagNameAndAttributeNameAlone3();
	//	relativeXPathUsingTagNameAndAttributeNameAlone4();
	//	relativeXPathUsingPartialAttributeValue();
	//	relativeXPathUsingTextContent();
	//	relativeXPathUsingPartialTextContent();
	}
	static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "G:\\ExampleAutomation\\Automation\\Web-Applicatiob\\Library\\driver\\chromedriver.exe");
			oBrowser=new ChromeDriver();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void navigate()
	{
		try
		{
			oBrowser.get("file:///G:\\SG_Notes\\HTML\\HTML NOTES\\tests_2nd_SEPT_2021\\Sample.html");
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void absoluteXPath()
	{
		try
		{
			oBrowser.findElement(By.xpath("html/body/div/form/input")).sendKeys("DemoUser1");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/*
	 * Case 1: Relative xPath using TagName alone
	 * Syntax: //<tagName>
	 */
	static void relativeXPathUsingTagNameAlone()
	{
		try
		{
			oBrowser.findElement(By.xpath("//input")).sendKeys("DemoUser1");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Case 2: Relative xPath using TagName with index
	 * Syntax: //<tagName>[index]
	 */
	static void relativeXPathUsingTagNameAndIndex()
	{
		try
		{
			oBrowser.findElement(By.xpath("//input[2]")).sendKeys("DemoUser2");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Case 3: Relative xPath using TagName with Attribute Name and value
	 * Combination
	 * Syntax: //<tagName>[@attributename='attributevalue']
	 */
	static void relativeXPathUsingTagNameWithAttributeNameValue()
	{
		try
		{
			oBrowser.findElement(By.xpath("//input[@value='Submit']")).click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Case 4: Relative xPath using TagName with 
	 * Multiple Attribute Name and value Combination
	 * Syntax: //<tagName>[@attributename='attributevalue'][@attributename='attributevalue']
	 */
	static void relativeXPathUsingTagNameWithMultipleAttributeNameValues()
	{
		try
		{
			oBrowser.findElement(By.xpath("//input[@value='Submit'][@class='submit1btn1']")).click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Case 5: Relative xPath using TagName with 
	 * Multiple Attribute Name and value Combination using and operator
	 * Syntax: //<tagName>[@attributename='attributevalue' and @attributename='attributevalue']
	 */
	static void relativeXPathUsingTagNameWithMultipleAttributeNameValuesUsingAndOperator()
	{
		try
		{
			oBrowser.findElement(By.xpath("//input[@value='Submit' and @class='submit1btn1']")).click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Case 6: Relative xPath using TagName with 
	 * Multiple Attribute Name and value Combination using or operator
	 * Syntax: //<tagName>[@attributename='attributevalue' or @attributename='attributevalue']
	 */
	static void relativeXPathUsingTagNameWithMultipleAttributeNameValuesUsingOrOperator()
	{
		try
		{
			oBrowser.findElement(By.xpath("//input[@value='Submit' or @class='submit1btn1']")).click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Case 7: Relative xPath for Irespective of TagName
	 *  with Attribute Name and value Combination
	 * Syntax: //*[@attributename='attributevalue']
	 */
	static void relativeXPathUsingAttributeNameValueCombination()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@value='Submit']")).click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/*
	 * Case 8: Relative xPath for Irespective of TagName
	 *  and  Irespective of Attribute Name only with value 
	 * Syntax: //*[@*='attributevalue']
	 */
	static void relativeXPathUsingAttributeValueAlone()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@*='Submit']")).click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Case 9: Relative xPath for TagName and Attribute Name alone
	 *  
	 * Syntax: //<tagName>[@attributename]
	 */
	static void relativeXPathUsingTagNameAndAttributeNameAlone()
	{
		try
		{
			List<WebElement> olinks=oBrowser.findElements(By.xpath("//a[@href]"));
			System.out.println("# of Links :"+olinks.size());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	// Display All Link Names
	static void relativeXPathUsingTagNameAndAttributeNameAlone2()
	{
		try
		{
			List<WebElement> olinks=oBrowser.findElements(By.xpath("//a[@href]"));
			System.out.println("# of Links :"+olinks.size());
			for(WebElement link:olinks)
			{
				String name=link.getText();
				System.out.println(name);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	// Click on a link and navigate back
		static void relativeXPathUsingTagNameAndAttributeNameAlone3()
		{
			try
			{
				List<WebElement> olinks=oBrowser.findElements(By.xpath("//a[@href]"));
				System.out.println("# of Links :"+olinks.size());
				for(WebElement link:olinks)
				{
					String name=link.getText();
					if(name.endsWith("Insitute"))
					{
						link.click();
						break;
					}
				}
				Thread.sleep(2000);
				oBrowser.navigate().back();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		// StaleElementReferenceException
		//org.openqa.selenium.StaleElementReferenceException:
		static void relativeXPathUsingTagNameAndAttributeNameAlone4()
		{
			try
			{
				List<WebElement> olinks=oBrowser.findElements(By.xpath("//a[@href]"));
				System.out.println("# of Links :"+olinks.size());
				for(int i=0;i<olinks.size();i++)
				{
					WebElement link=olinks.get(i);
					String name=link.getText();
					if(name.startsWith("Sel"))
					{
						link.click();
					}
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		/*
		 * Case 10: Relative xPath using Partial Matching of attribute values
		 * starts-with(@attributename,'partial attribute value')
		 * ends-with(@attributename,'partial attribute value')
		 * contains(@attributename,'partial attribute value')
		 * Syntax: //<tagName>[starts-with(@attributename,'partial attribute value')]
		 * Syntax: //<tagName>[ends-with(@attributename,'partial attribute value')]
		 * Syntax: //<tagName>[contains(@attributename,'partial attribute value')]
		 */
		static void relativeXPathUsingPartialAttributeValue()
		{
			try
			{
			//	oBrowser.findElement(By.xpath("//input[contains(@id,'windows')]")).click();
				oBrowser.findElement(By.xpath("//input[starts-with(@id,'rad2')]")).click();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		/*
		 * Case 11: Based on Text Content
		 * Syntax: //<tagName>[text()='text content']
		 */
		static void relativeXPathUsingTextContent()
		{
			try
			{
				String link="Eclipse";
				oBrowser.findElement(By.xpath("//a[text()='"+link+"']")).click();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		/*
		 * Case 12: Relative xPath using Partial Matching text content
		 * starts-with(text(),'partial text content')
		 * ends-with(text(),'partial text content')
		 * contains(text(),'partial text content')
		 * Syntax: //<tagName>[starts-with(text(),'partial text content')]
		 * Syntax: //<tagName>[ends-with(text(),'partial text content')]
		 * Syntax: //<tagName>[contains(text(),'partial text content')]
		 */
		static void relativeXPathUsingPartialTextContent()
		{
			try
			{
				oBrowser.findElement(By.xpath("//a[contains(text(),'Software')]")).click();
			
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}
