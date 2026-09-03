package com.codecool.pages;

import com.codecool.locators.HomeLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Page {
  private static final String URL = "https://playground.qatools.dev";

  private final HomeLocator homeLocator;
  private final WebDriverWait wait;

  public HomePage(WebDriver driver) {
    super(driver, URL);
    this.homeLocator = new HomeLocator(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public void skipWelcome() {
    wait.until(ExpectedConditions.elementToBeClickable(homeLocator.getSkipTourButton()));
    homeLocator.getSkipTourButton().click();
  }
}
