package com.ust.apiDemosQA;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.ust.apiDemosQA.base.AppiumServerManager;
import com.ust.apiDemosQA.utils.TestConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
  protected AndroidDriver driver;
  private final static TestConfig testConfig = ConfigFactory.create(TestConfig.class);

  @BeforeClass
  public void setUp() throws MalformedURLException {

    AppiumServerManager.startServer();
    UiAutomator2Options options = new UiAutomator2Options();
    options.setDeviceName(testConfig.deviceName());
    options.setApp(System.getProperty("user.dir") + testConfig.appPath());
    options.setPlatformName(testConfig.platform());
    driver =
        new AndroidDriver(new URL(testConfig.appiumUrl() + AppiumServerManager.getPort()), options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
    AppiumServerManager.stopServer();
  }

}
