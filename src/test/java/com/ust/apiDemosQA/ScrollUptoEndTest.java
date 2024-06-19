package com.ust.apiDemosQA;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import com.ust.apiDemosQA.pages.HomeScreen;

public class ScrollUptoEndTest extends BaseTest {

  HomeScreen homeScreen;

  @Test
  public void scrollUptoTest() {
    homeScreen = new HomeScreen(driver);
    homeScreen.clickViews();


    boolean canScrollMore;
    do {
      canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
          ImmutableMap.of("left", 0, "top", 0, "width", 800, "height", 1200, "direction", "down",
              "percent", 3.0

          ));

    } while (canScrollMore);
  }

}
