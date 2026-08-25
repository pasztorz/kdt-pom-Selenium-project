package com.codecool.pages;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class Page {
  private final WebDriver driver;
  private final String url;

  public Page(WebDriver driver, String url) {
    this.driver = driver;
    this.url = url;
  }

  public boolean isPageOpen (String uniqueUrlPart) {
    return Objects.requireNonNull(driver.getCurrentUrl()).contains(uniqueUrlPart);
  }

  public void openPage () {
    driver.get(url);
  }

  public String getUrl() {
    return url;
  }
}
