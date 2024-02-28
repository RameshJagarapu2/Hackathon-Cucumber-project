package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;
import pageObjects.upcomingbikes;

public class upcomingBikes {
	public WebDriver driver=BaseClass.getDriver();
	public	homePage hp;
public upcomingbikes ub;
	
	
	public static List<String>model=new ArrayList<String>();
	public static List<String>price=new ArrayList<String>();
	public static List<String>launchdates=new ArrayList<String>();
	
	
	@When("user hoveron newBikes")
	public void user_hoveron_new_bikes() 
	{
		hp=new homePage(driver);
		hp.hovernewBikes();
	}

	@When("click on upcomping bikes")
	public void click_on_upcomping_bikes() throws InterruptedException
	{
		Thread.sleep(5000);
		hp.upcomingbikes();	
	}

	@When("click on manufacture")
	public void click_on_manufacture()
	{
		upcomingbikes ub = new upcomingbikes(driver);
	   		ub.manufactures();
	}

	@When("select honda")
	public void select_honda() 
	{
		ub = new upcomingbikes(driver);
		ub.honda();
	}

	@When("click on readmore")
	public void click_on_readmore() throws InterruptedException, IOException 
	{
	    ub.readmore();
	    scroll();
	}

	@Then("get all the deatils of upcoming bikes")
	public void get_all_the_deatils_of_upcoming_bikes() throws IOException
	{
		pricesIndex(ub.bikeprices());
		System.out.println("List of upcoming bikes less than 4 lakhs");
		System.out.println("______________________________________________________________________________________________________");
		convert(ub.models(),ub.bikeprices(),ub.launchDate());
		System.out.println("______________________________________________________________________________________________________");
	}
public static List<Integer>index=new ArrayList<Integer>();
	
	public static void pricesIndex(List<String>price) 
	{
		for(int i=0;i<price.size();i++) 
		{
			String  value=price.get(i).replaceAll("[^0-9]","");			
			if(Integer.parseInt(value)*1000<400000 &&  !(price.get(i).contains("crore"))) 
			{
				index.add(i);
			
			}
			else if(!(price.get(i).contains(" Lakh"))){
				index.add(i);
			}
		}
	}
	
	public static void convert(List<String>models,List<String>prices,List<String>launchdate) {
		for(int i=0;i<models.size();i++) {
			if(index.contains(i)) {
			System.out.println(models.get(i)+"----"+prices.get(i)+"----"+launchdate.get(i));
			model.add(models.get(i));
			price.add(prices.get(i));
			launchdates.add(launchdate.get(i));
			}
		}
	}
	public void scroll() throws InterruptedException, IOException
	{  
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(5000);
	    
		
	}
	
	
}
