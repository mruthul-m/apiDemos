package com.ust.apiDemosQA.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferenceScreen {
	
	public AndroidDriver driver;
	public PreferenceScreen(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(10)),this);
	}
	
	@AndroidFindBy(accessibility = "4. Default values")
	private WebElement defaultValues;
	
	public void clickDefaultValues() {
		defaultValues.click();
	}

}
