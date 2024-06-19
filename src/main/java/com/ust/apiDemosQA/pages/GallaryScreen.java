package com.ust.apiDemosQA.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GallaryScreen {

  public AndroidDriver driver;

  public GallaryScreen(AndroidDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
  }

  @FindBy(xpath = "//android.widget.TextView[@content-desc=\"1. Photos\"]")
  private WebElement photos;

  public void clickPhotos() {
    photos.click();
  }

}
