package com.ust.apiDemosQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import com.ust.apiDemosQA.pages.GallaryScreen;
import com.ust.apiDemosQA.pages.HomeScreen;
import com.ust.apiDemosQA.pages.ViewScreen;

public class SwipeImagesTest extends BaseTest {

  HomeScreen homeScreen;
  ViewScreen viewScreen;
  GallaryScreen gallaryScreen;

  @Test
  public void gotoPhotos() {
    homeScreen = new HomeScreen(driver);
    homeScreen.clickViews();

    viewScreen = new ViewScreen(driver);
    viewScreen.clickGallary();

    gallaryScreen = new GallaryScreen(driver);
    gallaryScreen.clickPhotos();

    ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
        ((RemoteWebElement) driver
            .findElement(By.xpath("//android.widget.Gallery/android.widget.ImageView[1]"))).getId(),
        "direction", "left", "percent", 0.7));

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
        ImmutableMap.of("elementId",
            ((RemoteWebElement) driver.findElement(
                By.xpath("//android.widget.Gallery//android.widget.ImageView[last()]"))).getId(),
            "direction", "right", "percent", 0.7));

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
