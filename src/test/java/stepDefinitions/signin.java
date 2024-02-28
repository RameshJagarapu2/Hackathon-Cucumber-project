package stepDefinitions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;
import pageObjects.login;



public class signin {
	public WebDriver driver=BaseClass.getDriver();
	public homePage hp;
	public login lo;

		
	@When("user click on login\\/signin")
	public void user_click_on_login_signin() {
		homePage hp=new homePage(driver);
		hp.login();
	}

	@When("click on google")
	public void click_on_google() throws InterruptedException {
		
		Thread.sleep(7000);
		login lo=new login(driver);
		lo.google();
		
		Set <String> win=driver.getWindowHandles();
		  List<String>windows=new ArrayList<>(win);
		  driver.switchTo().window(windows.get(1));
		  
	}

	@When("user provide {string}")
	public void provide_email_id(String EmailId) {
		login lo=new login(driver);
		lo.email(EmailId);
		
	}

	@Then("click on next and get error message")
	public void click_on_next() throws InterruptedException, IOException {
		login lo=new login(driver);
		Thread.sleep(2000);
	    lo.next();
	    System.out.println("______________________________________________________________________________________________________");
		Thread.sleep(15000);
		final String ANSI_RESET = "\u001B[0m"; 
		final String ANSI_RED = "\033[1;31m";
	    System.out.println(ANSI_RED +lo.errormsg()+ ANSI_RESET);
		

	}
	
	
	@Then("excel is printed")
	public void excel_is_printed() throws IOException
	{
		FileOutputStream fp=new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\output.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet("List of newBikes");		
		
		for(int i=0;i<upcomingBikes.model.size();i++) {
				XSSFRow rows=sheet.createRow(i);			
				rows.createCell(0).setCellValue(upcomingBikes.model.get(i));
				rows.createCell(1).setCellValue(upcomingBikes.price.get(i));
				rows.createCell(2).setCellValue(upcomingBikes.launchdates.get(i));
				
			}	
		XSSFSheet sheet2=wb.createSheet("Popular Used Cars in chennai");
		for(int i=0;i<usedCars.popularmodels.size();i++) {
				XSSFRow rows=sheet2.createRow(i);			
				rows.createCell(0).setCellValue(usedCars.popularmodels.get(i));		
	}
		wb.write(fp);
		wb.close();
		fp.close();
 }
	
}

