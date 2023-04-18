package com.cucmber.assignment.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucmber.assignment.utilities.ReadConfig;

public class ProductDescriptionPageObject {

	private static final Logger logger = LogManager.getLogger(LandingPageObject.class);

	private WebDriver driver;
	private WebDriverWait wait;
	ReadConfig readConfig;
	
	private By sizeSelect = By.xpath("//select[@id='mt_size']");
	private By priceupdateText = By.xpath("//div[contains(text(),'Price updated')]");
	public ProductDescriptionPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		readConfig = new ReadConfig();
	}
	
	
	public void selectProductSize(String productSize) {
		wait.until(ExpectedConditions.elementToBeClickable(sizeSelect));
		WebElement sizeSelectElement = driver.findElement(sizeSelect);
		Select size = new Select(sizeSelectElement);
		size.selectByVisibleText(productSize);
		}
	
	public void validateProductDesciption(String productName) {
		wait.until(ExpectedConditions.titleContains(productName));
		Assert.assertEquals(productName, driver.getTitle());
	}
	
	public void validatePriceUpdateAlert(String priceUpdatedText) {
		WebElement priceupdateTextElement = driver.findElement(priceupdateText);
		wait.until(ExpectedConditions.visibilityOf(priceupdateTextElement));
		Assert.assertEquals(priceUpdatedText, priceupdateTextElement.getText());
	}
}
