package com.ust.apiDemosQA;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.ust.apiDemosQA.pages.HomeScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class ScrollUptoAnElementTest extends BaseTest {

  HomeScreen homeScreen;

  @Test
  public void scrollUptoAnElement() throws InterruptedException {
    homeScreen = new HomeScreen(driver);
    homeScreen.clickViews();
    String text = "Spinner";
    // Spinner
    driver.findElement(AppiumBy.androidUIAutomator(
        "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));


    ((AppiumDriver) driver).findElement(AppiumBy.accessibilityId("Spinner")).click();
    driver.findElement(By.xpath(
        "//android.widget.TextView[@content-desc='Color:']//following-sibling::android.widget.Spinner[1]"))
        .click();
    driver.findElement(By.xpath("//android.widget.CheckedTextView[4]")).click();
    driver.findElement(By.xpath(
        "//android.widget.TextView[@content-desc='Color:']//following-sibling::android.widget.Spinner[1]"))
        .click();
    assertEquals(driver.findElement(By.xpath("//android.widget.CheckedTextView[4]")).getText(),
        "green");

  }


}
