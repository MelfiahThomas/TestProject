package com.actiTime.step_defs;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Blog_steps {
    	WebDriver driver;
	@Given("Iam on the actiTime home page")
	public void iam_on_the_actiTime_home_page() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.actitime.com");
	}

	@When("I click on the Blog menu")
	public void i_click_on_the_Blog_menu() {
		driver.findElement(By.linkText("Blog")).click();
	}

	@Then("I verify blog page")
	public void i_verify_blog_page() {
		String expected_Url = "https://www.actitime.com/blog/";
		String actual_Url = driver.getCurrentUrl();

		if (!expected_Url.equals(actual_Url)) {
			fail("Not an expected page");
		}

		driver.quit();
	}

	@When("I verify blog index menu is displayed")
	public void i_verify_blog_index_menu_is_displayed() {
		driver.findElement(By.linkText("Blog")).click();
		driver.manage().window().maximize();
		
		
	boolean menu =	driver.findElement(By.xpath("//ul[@class='blog-index-menu__ul blog-index-menu__ul--lg']")).isDisplayed();

        System.out.println(menu);
	  
	}

	@Then("I collect menu list")
	public void i_collect_menu_list() {
		
		List<WebElement> menu_list = driver.findElements(By.xpath("//ul[@class='blog-index-menu__ul blog-index-menu__ul--lg']//li"));

		for (WebElement menu_lists : menu_list) {

			System.out.println(menu_lists.getText());

		}

	driver.quit();
	}

	@When("I click on read more option")
	public void i_click_on_read_more_option() {
		driver.findElement(By.linkText("Blog")).click();
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Read More")).click();
	  
	}

	@Then("I verify website navigate to next page")
	public void i_verify_website_navigate_to_next_page() {
		String expected_Url = "https://www.actitime.com/project-management/project-estimation/";
		String actual_Url = driver.getCurrentUrl();

		if (!expected_Url.equals(actual_Url)) {
			fail("Not an expected page");
		}

		driver.quit();

	   
	}

	@When("I verify article dispalyed")
	public void i_verify_article_dispalyed() {
		driver.findElement(By.linkText("Blog")).click();
		driver.manage().window().maximize();
		
		boolean articl = driver.findElement(By.tagName("article")).isDisplayed();
		System.out.println(articl);
	   
	}

	@Then("I get the count of the article")
	public void i_get_the_count_of_the_article() {
		Dimension article_count = driver.findElement(By.tagName("article")).getSize();
	   System.out.println(article_count);
	   
	   driver.quit();
	}
	
	 


}
