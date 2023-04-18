package com.cucmber.assignment.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollOperationUtility {
	
	private WebDriver driver;
	
	public ScrollOperationUtility(WebDriver driver) {
		this.driver= driver;
	}
	
	public void scrollToOption(WebElement element) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
