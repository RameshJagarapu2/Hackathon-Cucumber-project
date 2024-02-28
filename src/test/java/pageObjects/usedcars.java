package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class usedcars {
	public WebDriver driver;
	JavascriptExecutor executor;

	
	public usedcars (WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
	
	//locators
	
	@FindBy(xpath="//div[text()='Popular Models']")
	WebElement popular;
	
	@FindBy(xpath="//div[@class='gsc_thin_scroll']//li")
	public List<WebElement>popularmodels;
	
	
	//methods
	
	
	public List<String> popularmodels()
	{
		
		List<String> models=new ArrayList<String>();
		for(int i=0;i<popularmodels.size();i++)
		  {
		     String pmodels= popularmodels.get(i).getText();
		     models.add(pmodels);
		  }
	         return models;
		
	}
	
}
