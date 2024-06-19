package com.ust.apiDemosQA;

import org.testng.annotations.Test;
import com.ust.apiDemosQA.pages.CustomAdapterScreen;
import com.ust.apiDemosQA.pages.ExpandableListScreen;
import com.ust.apiDemosQA.pages.HomeScreen;
import com.ust.apiDemosQA.pages.ViewScreen;

public class LongPressTest extends BaseTest {

  HomeScreen homeScreen;
  ViewScreen viewScreen;
  ExpandableListScreen expandableListScreen;
  CustomAdapterScreen customAdapterScreen;

  @Test
  public void longPressTest() {
    homeScreen = new HomeScreen(driver);
    homeScreen.clickViews();

    viewScreen = new ViewScreen(driver);
    viewScreen.clickExpandableList();

    expandableListScreen = new ExpandableListScreen(driver);
    expandableListScreen.clickCustomAdapter();

    customAdapterScreen = new CustomAdapterScreen(driver);
    // customAdapterScreen.longClickPeopleNames();
    customAdapterScreen.longClickPeopleName();


  }

}
