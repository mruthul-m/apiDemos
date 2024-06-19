package com.ust.apiDemosQA.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen {
  public AndroidDriver driver;

  public HomeScreen(AndroidDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
  }

  @AndroidFindBy(accessibility = "Preference")
  private WebElement preferenceLink;

  @AndroidFindBy(accessibility = "Views")
  private WebElement views;


  public void clickPreference() {
    preferenceLink.click();
  }

  public void clickViews() {
    views.click();
  }



}
