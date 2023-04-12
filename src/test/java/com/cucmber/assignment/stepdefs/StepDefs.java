package com.cucmber.assignment.stepdefs;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucmber.assignment.driverFactory.WebDriverFactory;
import com.cucmber.assignment.pageObjects.LandingPageObject;
import com.cucmber.assignment.pageObjects.ProductDescriptionPageObject;
import com.cucmber.assignment.pageObjects.SocialMediaPageObject;
import com.cucmber.assignment.utilities.ReadConfig;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {

	Scenario scn;
	private static final Logger logger = LogManager.getLogger(StepDefs.class);
	WebDriver driver;
	WebDriverWait wait;
	String base_URL; // base url getting passed as argument to LandingPageObject for
						// landingPageValidation()

	LandingPageObject landingPageObject;
	ProductDescriptionPageObject productDescriptionPageObject;
	SocialMediaPageObject socialMediaPageObject;
	ReadConfig readConfig;

	@Before
	public void setup(Scenario scn) throws Exception {
		this.scn = scn;

		String browserName = WebDriverFactory.getBrowserName();
		driver = WebDriverFactory.getWebDriverForBrowser(browserName);
		wait = new WebDriverWait(driver, 20);
		landingPageObject = new LandingPageObject(driver, wait);
		productDescriptionPageObject = new ProductDescriptionPageObject(driver, wait);
		socialMediaPageObject = new SocialMediaPageObject(driver, wait);
		readConfig = new ReadConfig();
	}

	@Given("user navigate to landing page")
	public void user_navigate_to_landing_page() {
		logger.info("navigating to landing page URL");
		landingPageObject.navigateTolandingPage();
		scn.log("navigating to landing page");
	}

	@Given("user validate page title")
	public void user_validate_page_title() {
		logger.info("validating title of landing page");
		landingPageObject.validateLandingPageTitle();
		scn.log("Validating landing page");
	}

	// implementation for test Scenario Search product

	@Given("user enter product name")
	public void user_enter_product_name() throws InterruptedException {
		landingPageObject.searchBoxOperation();
	}

	@Then("search result is validated")
	public void search_result_is_validated() {
		landingPageObject.validateSearchResult();
		scn.log("validating search result");
	}

	// implementation for Scenario 3 product description operations

	@Given("user input product name")
	public void user_input_product_name() throws InterruptedException {
		landingPageObject.searchBoxOperation();
	}

	@When("user click on product link")
	public void user_click_on_product_link() {
		landingPageObject.searchOperation();
	}

	@Then("product descrption is opened")
	public void product_descrption_is_opened() {
		logger.info("Validating product descrption page");
		scn.log("validating product description");
	}

	@When("product size is selected")
	public void product_size_is_selected() {
		logger.info("selecting the size for the ring");
		productDescriptionPageObject.selectProductSize();
		scn.log("select size of product");
	}

	@Then("price update is validated")
	public void price_update_is_validated() {
		productDescriptionPageObject.validatePriceUpdateAlert();
		scn.log("validating price update promp is shown");
	}

	// Implementation for scenario 4 footer options check

	@Given("user scroll to bottom of landing page")
	public void user_scroll_to_bottom_of_landing_page() {
		landingPageObject.scrollToBottomOfPage();
		scn.log("Scrolling to bottom of page");
	}

	@When("user is able to see About Us section")
	public void user_is_able_to_see_about_us_section() {
		landingPageObject.aboutUSVisibilityCheck();
		scn.log("check visibility of about us section");
	}

	@Then("under About Us section below options are visible")
	public void under_about_us_section_below_options_are_visible(List<String> expectedAboutUSOptions) {
		landingPageObject.aboutUsOptionsCheck(expectedAboutUSOptions);
		scn.log("validate about us options");
	}

	// Implementation for scenario 5 social media handle check with scenario outline
	// examples

	@Given("user scroll down to bottom of landing page")
	public void user_scroll_down_to_bottom_of_landing_page() {
		landingPageObject.scrollToFollowUS();
		scn.log("scrolling to bottom of page");
	}

	@Given("user is able to see follow us section")
	public void user_is_able_to_see_follow_us_section() {
		landingPageObject.followUsVisibilityCheck();
		scn.log("check follow us section is available");
	}

	@When("user click for {string}")
	public void user_click_for(String socialMediaSite) {
		landingPageObject.clickOnSocialMediaLink(socialMediaSite);
		scn.log("open social media site");
	}

	@Then("url should contain {string}")
	public void url_should_contain(String mediaHandle) {
		socialMediaPageObject.validateSocialMediaHandle(mediaHandle);
		scn.log("validate social media handle in URL");
	}

	@Then("social media page contain {string} {string}")
	public void social_media_page_contain(String socialMediaSite, String socialMediaText) throws InterruptedException {
		socialMediaPageObject.validateSocialMediaText(socialMediaSite, socialMediaText);
		scn.log("validating social media handle on webpages");
	}

	@After(order = 0)
	public void closeBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void takeScreenshot(Scenario scn) {
		if (scn.isFailed()) {
			TakesScreenshot scrnshot = (TakesScreenshot) driver;
			byte[] data = scrnshot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png", "failed step name:->" + scn.getName());
		} else {
			scn.log("No error, no screenshot captured");
		}
	}
}
