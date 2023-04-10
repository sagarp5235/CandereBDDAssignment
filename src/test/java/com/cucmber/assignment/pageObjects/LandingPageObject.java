package com.cucmber.assignment.pageObjects;

		import org.apache.logging.log4j.LogManager;
		import org.apache.logging.log4j.Logger;
		import org.junit.Assert;
		import org.openqa.selenium.By;
		import org.openqa.selenium.JavascriptExecutor;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucmber.assignment.utilities.ReadConfig;

		public class LandingPageObject {

			private static final Logger logger = LogManager.getLogger(LandingPageObject.class);

			private WebDriver driver;
			private WebDriverWait wait;
			ReadConfig readConfig;

			
			private By searchBox = By.xpath("//input[@id='search']"); // locator for search box on home page
			
			private By searchButton = By.xpath("//button[@type='submit' and @title='Search']"); // locator for search button.
			
			private By searchResult = By.xpath("//div[contains(text(),'Majestic')]");
			
			public LandingPageObject(WebDriver driver, WebDriverWait wait) {
				this.driver = driver;
				this.wait = wait;
				readConfig = new ReadConfig();
			}

			public void navigateTolandingPage() {
				driver.get(readConfig.read_URL());
				logger.info("driver got invoked for URL->");
			}
		
			public void validateLandingPageTitle() {
				Assert.assertEquals(readConfig.readPageTitle(), driver.getTitle());
			}
			
			public void searchBoxOperation() throws InterruptedException {
				WebElement searchBoxElement = driver.findElement(searchBox);
				wait.until(ExpectedConditions.elementToBeClickable(searchBoxElement));
				searchBoxElement.sendKeys(readConfig.readSearchkeyword());
				Thread.sleep(4000);
			}
			
			
			public void validateSearchResult() {
				WebElement searchResultElement = driver.findElement(searchResult);
				Assert.assertEquals(readConfig.readSearchkeyword(), searchResultElement.getText());
			}
			
			public void searchOperation() {
				WebElement searchResultLink = driver.findElement(searchResult);
				searchResultLink.click();
			}
}
