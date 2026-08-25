package com.codecool.pages;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class Page {
  private final String url;
  private final WebDriver driver;

  public Page(String url, WebDriver driver) {
    this.url = url;
    this.driver = driver;
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
