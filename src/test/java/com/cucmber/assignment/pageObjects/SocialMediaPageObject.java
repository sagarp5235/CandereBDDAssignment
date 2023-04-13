package com.cucmber.assignment.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucmber.assignment.utilities.ReadConfig;


public class SocialMediaPageObject {

	private static final Logger logger = LogManager.getLogger(SocialMediaPageObject.class);
	WebDriver driver;
	WebDriverWait wait;
	ReadConfig readConfig;
	
	private By facebookPagetext = By.xpath("//h1[text()='Candere by Kalyan Jewellers']");
	private By twitterPagetext = By.xpath("//div[@data-testid='UserName']//span[text()='Candere By Kalyan Jewellers']");
	private By instagramPagetext = By.xpath("//h2[text()='canderejewellery']");
	public SocialMediaPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		readConfig = new ReadConfig();

}
	
	public void validateSocialMediaHandle(String mediaHandle) {
		wait.until(ExpectedConditions.urlContains(mediaHandle));
		logger.info("validating social media handle");
		Assert.assertTrue("test failed", driver.getCurrentUrl().contains(mediaHandle));
		
	}
	
	
	public void validateSocialMediaText(String socialMediaSite, String socialMediaText) {
		wait.until(ExpectedConditions.urlContains(socialMediaSite));
		logger.info("validating text on social media pages");
		switch(socialMediaSite.toLowerCase()) {
		case "facebook":
			wait.until(ExpectedConditions.elementToBeClickable(facebookPagetext));
			WebElement facebookPageTextElement = driver.findElement(facebookPagetext);
			Assert.assertNotEquals("Test failed",socialMediaText, facebookPageTextElement.getText());
			break;
			
		case "twitter":
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(twitterPagetext));
			WebElement twitterPageTextElement = driver.findElement(twitterPagetext);
			Assert.assertEquals(socialMediaText, twitterPageTextElement.getText());
			break;
			
		case "instagram":
			wait.until(ExpectedConditions.elementToBeClickable(instagramPagetext));
			WebElement instagramPageTextElement = driver.findElement(instagramPagetext);
			Assert.assertEquals(socialMediaText, instagramPageTextElement.getText());
			break;
			default:
				logger.info("no such website exist");
		}
	}
	
}

