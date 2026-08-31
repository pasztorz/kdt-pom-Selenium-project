package com.codecool.keywords;

import com.codecool.locators.HomeLocator;
import com.codecool.pages.Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeKeyword {
  protected HomeLocator homeLocator;
  private final WebDriverWait wait;
  private final Home home;

  public HomeKeyword(WebDriver driver) {
    this.homeLocator = new HomeLocator(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    this.home = new Home(driver);
  }

  public void open() {
    home.openPage();
    skipWelcome();
  }

  public void skipWelcome() {
    wait.until(ExpectedConditions.elementToBeClickable(homeLocator.getSkipTour()));
    homeLocator.getSkipTour().click();
  }
}
