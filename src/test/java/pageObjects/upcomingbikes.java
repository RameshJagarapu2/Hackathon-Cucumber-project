package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class upcomingbikes {

	public upcomingbikes (WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	
	}

	//locators
	@FindBy(xpath="//select[@class='custom-select']")
	WebElement manufactures;
	
	@FindBy(xpath="//option[@data-url='honda']")
	WebElement honda;
	
	@FindBy(xpath="//span[@style='color:#000;']")
	WebElement readmore;
	
	@FindBy(xpath="//tr[@class='ml-15 ']//td[1]")
	public List<WebElement >models;
	
	@FindBy(xpath="//tr[@class='ml-15 ']//td[2]")
	public List<WebElement >prices;
	
	@FindBy(xpath="//tr[@class='ml-15 ']//td[3]")
	public List<WebElement >launchdate;
	
	@FindBy(xpath="//tr[@class='ml-15 '][3]")
	public List<WebElement >hondaBikes;
	
	
	//methods
	public void manufactures()
	{
		manufactures.click();
	}
	
	public void honda()
	{
		honda.click();
	}
	public void readmore()
	{
		readmore.click();
	}
	
	 public List<String> bikeprices()
	    {
	    	List<String> price=new ArrayList<String>();
			for(WebElement e:prices)
			{
				price.add(e.getText());
			}
	    	return price;
	    }
	 public List<String> models()
	    {
	    	List<String> model=new ArrayList<String>();
			for(WebElement e:models)
			{
				model.add(e.getText());
			}
	    	return model;
	    }
	 public List<String> launchDate()
	    {
	    	List<String> date=new ArrayList<String>();
			for(WebElement e:models)
			{
				date.add(e.getText());
			}
	    	return date;
	    }
}