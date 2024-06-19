package com.ust.apiDemosQA.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ViewScreen {
  public AndroidDriver driver;

  public ViewScreen(AndroidDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
  }

  @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Gallery\"]")
  private WebElement gallary;

  @AndroidFindBy(accessibility = "Expandable Lists")
  private WebElement expandableList;


  public void clickGallary() {
    gallary.click();
  }

  public void clickExpandableList() {
    expandableList.click();
  }

}
