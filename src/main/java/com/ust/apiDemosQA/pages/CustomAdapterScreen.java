package com.ust.apiDemosQA.pages;

import java.time.Duration;
import java.util.Collections;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CustomAdapterScreen {

  AndroidDriver driver;

  public CustomAdapterScreen(AndroidDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
  }

  @FindBy(xpath = "//android.widget.ExpandableListView/android.widget.TextView[1]")
  private WebElement peopleNames;

  public void longClickPeopleNames() {
    ((JavascriptExecutor) driver).executeScript("mobile:longClickGesture",
        ImmutableMap.of("elementId", ((RemoteWebElement) peopleNames).getId(), "duration", 2000));
  }

  public void longClickPeopleName() {
    Point location = peopleNames.getLocation();
    Dimension size = peopleNames.getSize();
    Point centerOfElement = getCenterOfElement(location, size);
    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
    Sequence sequence = new Sequence(finger1, 1)
        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),
            centerOfElement))
        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        // waiting for 2 seconds for longPress on the Element
        .addAction(new Pause(finger1, Duration.ofSeconds(2)))
        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    driver.perform(Collections.singletonList(sequence));
  }

  private Point getCenterOfElement(Point location, Dimension size) {
    return new Point(location.getX() + size.getWidth() / 2, location.getY() + size.getHeight() / 2);
  }

}
