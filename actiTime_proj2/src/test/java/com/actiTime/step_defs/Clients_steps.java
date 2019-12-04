package com.actiTime.step_defs;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Clients_steps {
	  WebDriver driver;

	@Given("I am on actiTime home page")
	public void i_am_on_actiTime_home_page() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.actitime.com");

	}

	@When("I click on the clients menu")
	public void i_click_on_the_clients_menu() {
		driver.findElement(By.linkText("Clients")).click();
	}

	@Then("I verify clients page")
	public void i_verify_clients_page() {
		String expected_Url = "https://www.actitime.com/testimonials";
		String actual_Url = driver.getCurrentUrl();

		if (!expected_Url.equals(actual_Url)) {
			fail("Not an expected page");
		}

		driver.quit();

	}

	@When("I click on {string} tool link")
	public void i_click_on_tool_link(String string) {
		
		driver.findElement(By.linkText("Clients")).click();

		String pwin = driver.getWindowHandle();
		Set<String> cwins = driver.getWindowHandles();

			driver.manage().window().maximize();
			driver.findElement(By.xpath(" //a[@id='cookie-button--got-it']")).click();
			driver.findElement(By.linkText("Clients")).click();

		
	    
		if(string.equalsIgnoreCase("Architecture")) {
			   driver.findElement(By.linkText("Architecture")).click();
		   }else if(string.equalsIgnoreCase("Consulting")) {
			   driver.findElement(By.linkText("Consulting")).click();
		   }else if(string.equalsIgnoreCase("Design")) {
			   driver.findElement(By.linkText("Design")).click();
		   }else if(string.equalsIgnoreCase("Education")) {
			   driver.findElement(By.linkText("Education")).click();
			   
		   }else if(string.equalsIgnoreCase("Engineering")) {
			   driver.findElement(By.linkText("Engineering")).click();
		   }else if(string.equalsIgnoreCase("HealthCare")) {
			   driver.findElement(By.linkText("Healthсare")).click();
		   }else if(string.equalsIgnoreCase("IT")) {
			   driver.findElement(By.linkText("IT")).click();
		   }else if(string.equalsIgnoreCase("Small Business")) {
			   driver.findElement(By.linkText("Small Business")).click();
		   }
	}

	@Then("I verify that website navigates to {string} page")
	public void i_verify_that_website_navigates_to_page(String string) {
		
		String expected = "";
		if(string.equalsIgnoreCase("Architecture")){
	    	 expected = "https://www.actitime.com/testimonials/timesheet-for-architects";
	    }else if (string.equalsIgnoreCase("Consulting")) {
	    	expected = "https://www.actitime.com/testimonials/consultant-time-tracking";
	    }else if (string.equalsIgnoreCase("Design")) {
	    	expected = "https://www.actitime.com/testimonials/timesheet-for-designers";
	    }else if (string.equalsIgnoreCase("Education")) {
		    	expected = "https://www.actitime.com/testimonials/education-time-tracking";
	    }else if (string.equalsIgnoreCase("Engineering")) {
	    	expected = "https://www.actitime.com/testimonials/engineering-timesheet";  
	    }else if (string.equalsIgnoreCase("HealthCare")) {
	    	expected = "https://www.actitime.com/testimonials/time-tracking-for-healthcare";  	
	    }else if (string.equalsIgnoreCase("IT")) {
	    	expected = "https://www.actitime.com/testimonials/it-time-tracking";  	
	    }else if (string.equalsIgnoreCase("Small Business")) {
	    	expected = "https://www.actitime.com/testimonials/timesheet-software-for-small-business";  
		String actual = driver.getCurrentUrl();
	    if (!expected.equals(actual)) {
	    	fail("Website does not navigate to arts page.");
	    }
	  
	}
		 driver.quit();
	}
	
	@Then("I collect all the reviewers logo")
	public void i_collect_all_the_reviewers_logo() {
		
		

			driver.manage().window().maximize();
			driver.findElement(By.xpath(" //a[@id='cookie-button--got-it']")).click();
			
			List<WebElement> review = driver.findElements(By.tagName("h3"));

			for (WebElement reviews : review) {

				System.out.println(reviews.getText());

			}
			
			
       
	    
	    driver.quit();
	}

	
}
