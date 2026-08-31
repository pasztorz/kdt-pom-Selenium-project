package com.codecool.keywords;

import com.codecool.locators.HomeLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeKeyword {
  protected HomeLocator homeLocator;
  private final WebDriverWait wait;

  public HomeKeyword(WebDriver driver) {
    this.homeLocator = new HomeLocator(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public void skipWelcome() {
    wait.until(ExpectedConditions.elementToBeClickable(homeLocator.getSkipTour()));
    homeLocator.getSkipTour().click();
  }
}
