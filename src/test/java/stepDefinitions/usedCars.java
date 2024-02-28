package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;
import pageObjects.usedcars;

public class usedCars {
	public WebDriver driver=Hooks.driver;
	public static List<String>popularmodels=new ArrayList<String>();

	public homePage hp;
	public usedcars uc;
	
	
	@When("user hoveron usedCars")
	public void user_hoveron_used_cars() throws InterruptedException 
	{
	    hp=new homePage(driver);
		hp.zigwheels();
		Thread.sleep(3000);
		hp.hoverusedCars();
	}

	@When("click on Chennai")
	public void click_on_chennai() throws InterruptedException 
	{
	 
		Thread.sleep(3000);
		hp.chennai();
	}

	@Then("get all popular models")
	public void get_all_popular_models() throws IOException
	{
	    
		System.out.println("popular bikes in chennai");	
		System.out.println("______________________________________________________________________________________________________");

		 uc=new usedcars(driver);
		for(String Pmodels:uc.popularmodels())
		{
			System.out.println(Pmodels);
			popularmodels.add(Pmodels);
		
		}
		hp.zigwheels();
	}		


	
}
