package com.ust.apiDemosQA;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.ust.apiDemosQA.pages.DefaultValueScreen;
import com.ust.apiDemosQA.pages.HomeScreen;
import com.ust.apiDemosQA.pages.PreferenceScreen;

public class SetDefaultValueTest extends BaseTest {

  HomeScreen homeScreen;
  PreferenceScreen preferenceScreen;
  DefaultValueScreen defaultValueScreen;

  @Test(priority = 1)
  public void clickPrefernce() {
    homeScreen = new HomeScreen(driver);
    homeScreen.clickPreference();
  }

  @Test(priority = 2)
  public void clickDefaultVales() {
    preferenceScreen = new PreferenceScreen(driver);
    preferenceScreen.clickDefaultValues();
  }

  @Test(priority = 3)
  public void setTextAsDefaultValue() {
    defaultValueScreen = new DefaultValueScreen(driver);
    defaultValueScreen.setText("Testing Text");
    assertEquals("Testing Text", defaultValueScreen.getText());
  }



}
