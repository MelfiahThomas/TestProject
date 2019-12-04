package com.actiTime.step_defs;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Features_steps {

	WebDriver driver;

	@Given("Iam on actiTime home page")
	public void iam_on_actiTime_home_page() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.actitime.com");

	}

	@When("I click on the Features menu")
	public void i_click_on_the_Features_menu() {

		driver.findElement(By.xpath("//a[contains(text(),'Features')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Then("I verify features page")
	public void i_verify_features_page() {
		String actual = "https://www.actitime.com/features";
		String expected = driver.getCurrentUrl();
		if (!expected.equals(actual)) {
			fail("Wrong Page");
		}

		driver.quit();	

	}

	@Given("Iam on the Features  Page")
	public void iam_on_the_Features_Page() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/melfi/Desktop/Selenium drivers/chromedriver_win32_new/chromedriver.exe/");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.actitime.com");

		driver.findElement(By.xpath("//a[contains(text(),'Features')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String ParentWin = driver.getWindowHandle();
		Set<String> Wind = driver.getWindowHandles();
		for (String Win : Wind) {
			if (!Win.equals(ParentWin)) {
				driver.switchTo().window(Win);
			}
		}

	}

	@When("I collect the features list displayed in the features page")
	public void i_collect_the_features_list_displayed_in_the_features_page() {

		List<WebElement> flist = driver.findElements(By.xpath("//div[@class = 'key-feature-adapt-list__title']"));

		for (WebElement fli : flist) {

			System.out.println(fli.getText());

		}

	}

	@Then("I verify all the feature list  are collected")
	public void i_verify_all_the_feature_list_are_collected() {

		System.out.println("completed");

		driver.quit();
	}

	@When("I verify cookie alert is displayed")

	public void i_verify_cookie_alert_is_displayed() {

		boolean cookiedisplayed;
		cookiedisplayed = driver.findElement(By.xpath("//div[@class='cookie-consent__middle']")).isDisplayed();

		System.out.println(cookiedisplayed);

	}

	@When("I click on Got it button")
	public void i_click_on_Got_it_button() {

		driver.findElement(By.xpath(" //a[@id='cookie-button--got-it']")).click();

	}

	@Then("I verify alert box get cancelled")
	public void i_verify_alert_box_get_cancelled() {
		boolean cookiedisplayed;
		cookiedisplayed = driver.findElement(By.xpath("//div[@class='cookie-consent__middle']")).isDisplayed();

		System.out.println(cookiedisplayed);

		driver.quit();

	}

	@When("I click on help symbol")
	public void i_click_on_help_symbol() {
		driver.findElement(
				By.xpath("//div[@class='call-back-app__question-button call-back-app__animation-first-step']")).click();

	}

	@Then("I verify help pop-up gets displayed")
	public void i_verify_help_pop_up_gets_displayed() {
		boolean helppg = driver.findElement(By.xpath("//div[@class='call-back-app__body']")).isDisplayed();
		System.out.println(helppg);

		driver.quit();
	}

	@When("I enter {string} and {string} with invalid creds")
	public void i_enter_and_with_invalid_creds(String string, String string2) {

		driver.findElement(By.xpath("//div[@class='call-back-app__body']"));

		String ParentWin = driver.getWindowHandle();
		Set<String> window = driver.getWindowHandles();

		for (String windows : window) {

			if (!windows.equals(ParentWin)) {

				driver.switchTo().window(windows);
			}
		}

		driver.findElement(By.id("first-name-call-back")).sendKeys(string);
		driver.findElement(By.id("email-call-back")).sendKeys(string2);

	}

	@When("I select Request a demo option and click submit")
	public void i_select_Request_a_demo_option_and_click_submit() throws InterruptedException {

		Actions action = new Actions(driver);

		driver.findElement(By.xpath("//i[@class='open-indicator']")).click();

		action.sendKeys(Keys.ENTER).perform();

		Thread.sleep(10000);

	}

	@Then("I verify submit is not enabled")
	public void i_verify_submit_is_not_enabled() {
		boolean sub = driver.findElement(By.xpath("//button[@class='call-back-app__button']")).isEnabled();
		System.out.println(sub);
		driver.quit();

	}

}
