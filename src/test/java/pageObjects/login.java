package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {

	public  login (WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	
	//locators
	@FindBy(xpath="//div[@class='hidden-xs hidden-sm pull-right']")
	WebElement login;
	
	@FindBy(xpath="//div[contains(@class,'googleSignIn')]")
	WebElement google;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement email;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement next;
	
	@FindBy(xpath="//div[@class='o6cuMc Jj6Lae']")
	WebElement ErrorMSG;
   
	//methods
	public void signin()
	{
		login.click();
	}
	
	public void google()
	{
		google.click();
	}
	
	public void email(String EmailId)
	{
		email.sendKeys(EmailId);
	}
	
	public void next()
	{
		next.click();
	}
	public String errormsg()
	{
		return ErrorMSG.getText();
	}
	
}
