package com.cucmber.assignment.stepdefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucmber.assignment.driverFactory.WebDriverFactory;
import com.cucmber.assignment.pageObjects.LandingPageObject;
import com.cucmber.assignment.pageObjects.ProductDescriptionPageObject;
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
	ReadConfig readConfig;


	@Before
	public void setup(Scenario scn) throws Exception {
		this.scn = scn;

		String browserName = WebDriverFactory.getBrowserName();
		driver = WebDriverFactory.getWebDriverForBrowser(browserName);
		wait = new WebDriverWait(driver, 20);
		landingPageObject = new LandingPageObject(driver, wait);
		productDescriptionPageObject = new ProductDescriptionPageObject(driver, wait);
		readConfig= new ReadConfig();
	}
	
	@Given("user navigate to landing page")
	public void user_navigate_to_landing_page() {
		logger.info("navigating to landing page URL");
	    landingPageObject.navigateTolandingPage();
	}


	@Given("user validate page title")
	public void user_validate_page_title() {
		logger.info("validating title of landing page");
		landingPageObject.validateLandingPageTitle();
	}
	
	//implementation for test Scenario Search product
	
	@Given("user enter product name")
	public void user_enter_product_name() throws InterruptedException {
	landingPageObject.searchBoxOperation();
	}

	
	@Then("search result is validated")
	public void search_result_is_validated() {
		landingPageObject.validateSearchResult();
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
	    Assert.assertEquals(readConfig.readPageTitle(), driver.getTitle());
	}
	@When("product size is selected")
	public void product_size_is_selected() {
		logger.info("selecting the size for the ring");
	   productDescriptionPageObject.selectProductSize();
	}
	@Then("price update is validated")
	public void price_update_is_validated() {
	  
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}
}
