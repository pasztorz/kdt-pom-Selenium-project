package com.codecool.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public abstract class Page {
  private final WebDriver driver;
  private final String url;

  public Page(WebDriver driver, String url) {
    this.driver = driver;
    this.url = url;
  }

  public boolean currentUrlContains(String uniqueUrlPart) {
    return Objects.requireNonNull(driver.getCurrentUrl()).contains(uniqueUrlPart);
  }

  public void openPage () {
    driver.get(url);
  }

  public WebDriver getDriver() {
    return driver;
  }
}
