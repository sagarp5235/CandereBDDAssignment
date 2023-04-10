package com.cucmber.assignment.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	public ProductDescriptionPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		readConfig = new ReadConfig();
	}
	
	public void selectProductSize() {
		wait.until(ExpectedConditions.elementToBeClickable(sizeSelect));
		WebElement sizeSelectElement = driver.findElement(sizeSelect);
		Select size = new Select(sizeSelectElement);
		size.selectByVisibleText(readConfig.readSize());
		}
	
	public void validatePriceUpdateAlert() {
		
	}
}
