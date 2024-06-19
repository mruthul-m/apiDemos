package com.ust.apiDemosQA.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DefaultValueScreen {

  public AndroidDriver driver;

  public DefaultValueScreen(AndroidDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
  }

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android."
      + "view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget."
      + "LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget."
      + "LinearLayout[2]/android.widget.RelativeLayout")
  private WebElement editText;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout"
      + "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout"
      + "/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout"
      + "/android.widget.EditText")
  private WebElement textBox;

  @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout"
      + "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView"
      + "/android.widget.LinearLayout/android.widget.Button[2]")
  private WebElement okBtn;

  public void setText(String text) {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    editText.click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    textBox.clear();
    textBox.sendKeys(text);
    okBtn.click();

  }

  public String getText() {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    editText.click();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    return textBox.getText();
  }


}
