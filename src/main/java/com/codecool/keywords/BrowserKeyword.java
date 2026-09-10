package com.codecool.keywords;

import com.codecool.service.IndifferentUrlProvider;
import org.openqa.selenium.WebDriver;

public class BrowserKeyword {
  private final WebDriver driver;

  public BrowserKeyword(WebDriver driver) {
    this.driver = driver;
  }

  public void navigateBack() {
    driver.navigate().back();
  }

  public void navigateToIndifferentWebPagesInBrowser() {
    String url = IndifferentUrlProvider.getRandomUrl();
    driver.navigate().to(url);
  }
}
