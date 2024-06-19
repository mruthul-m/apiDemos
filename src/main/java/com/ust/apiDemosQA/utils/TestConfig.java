package com.ust.apiDemosQA.utils;

import org.aeonbits.owner.Config;

@Config.Sources("file:src/test/resources/config.properties")
public interface TestConfig extends Config {

  @Key("PLATFORM_NAME")
  public String platform();

  @Key("DEVICE_NAME")
  public String deviceName();

  @Key("APPIUM_URL_PATH")
  public String appiumUrl();

  @Key("APP_PATH")
  public String appPath();
}
