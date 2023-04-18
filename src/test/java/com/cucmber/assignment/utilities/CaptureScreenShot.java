package com.cucmber.assignment.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class CaptureScreenShot {
	
	private WebDriver driver;
	
	
	
	public CaptureScreenShot(WebDriver driver) {
		this.driver=driver;
	}
	
	public void takeScreenshot(Scenario scn) {
		TakesScreenshot scrnshot = (TakesScreenshot) driver;
		byte[] data = scrnshot.getScreenshotAs(OutputType.BYTES);
		scn.attach(data, "image/png", "step name:->" + scn.getName());
	}

}
