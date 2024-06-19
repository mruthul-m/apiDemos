package com.ust.apiDemosQA.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ExpandableListScreen {

  AndroidDriver driver;

  public ExpandableListScreen(AndroidDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
  }

  @AndroidFindBy(accessibility = "1. Custom Adapter")
  private WebElement customAdapter;

  public void clickCustomAdapter() {
    customAdapter.click();
  }


}
