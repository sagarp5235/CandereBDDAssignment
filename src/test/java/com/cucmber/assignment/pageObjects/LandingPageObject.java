package com.cucmber.assignment.pageObjects;

		import java.util.List;

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
			private By searchResult = By.xpath("//div[contains(text(),'Majestic')]"); //locator for search result link containing keyword 
			private By aboutUs = By.xpath("//p[text()='ABOUT US']");
			private By aboutUsOptions = By.xpath("//p[text()='ABOUT US']//parent::nav//a[text()]");
			private By followUs = By.xpath("//p[text()='FOLLOW US']");
			private By followUsOptions = By.xpath("//p[text()='FOLLOW US']//parent::nav//div/a");
			public LandingPageObject(WebDriver driver, WebDriverWait wait) {
				this.driver = driver;
				this.wait = wait;
				readConfig = new ReadConfig();
			}

			public void navigateTolandingPage() {
				driver.get(readConfig.prop.getProperty("base_URL"));
				logger.info("driver got invoked for URL->");
			}
		
			public void validateLandingPageTitle() {
				Assert.assertEquals(readConfig.prop.getProperty("pageTitle"), driver.getTitle());
			}
			
			public void searchBoxOperation() throws InterruptedException {
				WebElement searchBoxElement = driver.findElement(searchBox);
				wait.until(ExpectedConditions.elementToBeClickable(searchBoxElement));
				searchBoxElement.sendKeys(readConfig.prop.getProperty("searchKeyword"));
				Thread.sleep(4000);
			}
			
			
			public void validateSearchResult() {
				WebElement searchResultElement = driver.findElement(searchResult);
				wait.until(ExpectedConditions.elementToBeClickable(searchResult));
				Assert.assertEquals(readConfig.prop.getProperty("expectedResultName"), searchResultElement.getText());
			}
			
			public void searchOperation() {
				WebElement searchResultLink = driver.findElement(searchResult);
				searchResultLink.click();
			}
			
			public void scrollToBottomOfPage() {
				WebElement aboutUSElement = driver.findElement(aboutUs);
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				logger.info("Scrolling to bottom of page to search for options");
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", aboutUSElement);
			}
			
			public void aboutUSVisibilityCheck() {
				WebElement aboutUSElement = driver.findElement(aboutUs);
				Assert.assertEquals(readConfig.prop.getProperty("footerOption"), aboutUSElement.getText());
			}
			
			public void aboutUsOptionsCheck(List<String> expectedAboutUsOptions) {
				List<WebElement> aboutUsOptionsElement = driver.findElements(aboutUsOptions);
				logger.info("validating options under About us category");
				for (int i = 0; i < expectedAboutUsOptions.size(); i++) {
					if (expectedAboutUsOptions.get(i).equals(aboutUsOptionsElement.get(i).getText())) {
						Assert.assertTrue(true);
						logger.info("validation passed for :->" + aboutUsOptionsElement.get(i).getText());
					} else {
						Assert.fail();

					}

				}

			}
			
			public void scrollToFollowUS() {
				WebElement followUSElement = driver.findElement(followUs);
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				logger.info("Scrolling to bottom of page to search for options");
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", followUSElement);
			}
			
			public void followUsVisibilityCheck() {
				WebElement followUSElement = driver.findElement(followUs);
				Assert.assertEquals(readConfig.prop.getProperty("socialMedia"), followUSElement.getText());
			}
			
			public void clickOnSocialMediaLink(String socialMediaSite) {
				List<WebElement> SocialMediaOptions=driver.findElements(followUsOptions);

				//now traverse over the list and check
				for(int i=0 ; i<SocialMediaOptions.size() ; i++)
				{
				    if(SocialMediaOptions.get(i).getAttribute("href").contains(socialMediaSite))
				    {
				    	SocialMediaOptions.get(i).click();
				        break;
				    }
				} 
				
		
			}
}
