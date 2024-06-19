package com.ust.apiDemosQA.base;

import java.io.File;
import java.time.Duration;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServerManager {
  private static AppiumDriverLocalService service;

  public static void startServer() {
    if (service == null) {
      AppiumServiceBuilder builder = new AppiumServiceBuilder()
          .withAppiumJS(new File("C:/Users/268877/node_modules/appium/build/lib/main.js")) // Path
                                                                                           // to
                                                                                           // appium.js
          .withTimeout(Duration.ofSeconds(60)) // Increase the timeout to 60 seconds
          .usingAnyFreePort().withArgument(GeneralServerFlag.SESSION_OVERRIDE)
          .withArgument(GeneralServerFlag.LOG_LEVEL, "error");
      service = AppiumDriverLocalService.buildService(builder);
    }
    service.start();
    System.out.println("Appium Server is Started");

  }

  public static void stopServer() {
    if (service != null && service.isRunning()) {
      service.stop();
      System.out.println("Appium Server is Stopped");
    }
  }

  public static int getPort() {
    if (service != null && service.isRunning()) {
      return service.getUrl().getPort();
    }
    return 0;
  }



}
