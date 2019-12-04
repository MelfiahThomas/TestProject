package com.actiTime.step_defs;

import static org.junit.Assert.fail;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Purchase_steps {
	WebDriver driver;

	@Given("Iam on the actiTime homepage")
	public void iam_on_the_actiTime_homepage() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/melfi/Desktop/Selenium drivers/chromedriver_win32_new/chromedriver.exe/");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.actitime.com");

	}

	@When("I click on the purchase menu")
	public void i_click_on_the_purchase_menu() {
		driver.findElement(By.linkText("Purchase")).click();

	}

	@Then("I verify purchase page gets displayed")
	public void i_verify_purchase_page_gets_displayed() {

		String expected_Url = "https://www.actitime.com/purchase";
		String actual_Url = driver.getCurrentUrl();

		if (!expected_Url.equals(actual_Url)) {
			fail("Not an expected page");
		}

		driver.quit();

	}

	@When("I set the number of users")
	public void i_set_the_number_of_users() {

		driver.findElement(By.linkText("Purchase")).click();

		String pwin = driver.getWindowHandle();
		Set<String> cwins = driver.getWindowHandles();

		for (String cwin : cwins) {
			if (!cwin.equals(pwin)) {

				driver.switchTo().window(cwin);

			}
			driver.manage().window().maximize();
			driver.findElement(By.xpath(" //a[@id='cookie-button--got-it']")).click();

			WebElement Slider = driver.findElement(
					By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[2]/span[1]/span[6]"));
			Actions action = new Actions(driver);
			action.dragAndDropBy(Slider, 200, 0).release().build().perform();
			Slider.click();

		}

	}

	@When("I set the payment period")
	public void i_set_the_payment_period() {
		String offer = driver.findElement(By.xpath("//div[@class='legends-of-disconts__item']")).getText();
		System.out.println(offer);

	}

	@Then("I verify total cost gets displayed")
	public void i_verify_total_cost_gets_displayed() {
		String cost = driver
				.findElement(By.xpath("//div[@class='purchase-result__value purchase-result__value--index']"))
				.getText();
		System.out.println(cost);

		driver.quit();
	}

	@When("I click on the  continue button")
	public void i_click_on_the_continue_button() {
		driver.findElement(By.linkText("Purchase")).click();
		driver.manage().window().maximize();
		driver.findElement(By.xpath(" //a[@id='cookie-button--got-it']")).click();

		driver.findElement(By.xpath("//button[@id='hosting-purchase-button']")).click();
	}

	@Then("I verify billing information page gets displayed")
	public void i_verify_billing_information_page_gets_displayed() {

		String act_Url = driver.getCurrentUrl();
		System.out.println(act_Url);
		String exp_Url = "https://www.actitime.com/purchase";

		if (!exp_Url.equals(act_Url)) {
			fail("Not an expected page");
		}

		driver.quit();
	}

	@When("I click number of users to {int}")
	public void i_click_number_of_users_to(Integer int1) {
		driver.findElement(By.linkText("Purchase")).click();
		driver.manage().window().maximize();
		driver.findElement(By.xpath(" //a[@id='cookie-button--got-it']")).click();

	}

	@Then("I verify limited fuctionality option get display")
	public void i_verify_limited_fuctionality_option_get_display() {
		WebElement Slider = driver.findElement(
				By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[2]/span[1]/span[6]"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(Slider, -300, 0).release().build().perform();
		Slider.click();

		driver.findElement(By.xpath(" //div[@class='limit-func']")).click();
	}

	@Then("I click on limited functionalty option")
	public void i_click_on_limited_functionalty_option() {
		boolean fun_op = driver.findElement(By.xpath("//div[@class='limit-func-popup limit-func-popup--active']"))
				.isDisplayed();
		System.out.println(fun_op);

		driver.quit();
	}

	@When("I verify actiTime support link")
	public void i_verify_actiTime_support_link() {
		driver.findElement(By.linkText("Purchase")).click();
		driver.manage().window().maximize();
		driver.findElement(By.xpath(" //a[@id='cookie-button--got-it']")).click();
		driver.findElement(By.xpath("//a[@class='purchase-faq__mail-link']")).isDisplayed();

	}

	@Then("I verify link is clickable")
	public void i_verify_link_is_clickable() {

		boolean li = driver.findElement(By.xpath("//a[@class='purchase-faq__mail-link']")).isEnabled();
		System.out.println(li);
		driver.quit();

	}

}
