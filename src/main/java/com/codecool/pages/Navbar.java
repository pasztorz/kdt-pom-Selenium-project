package com.codecool.pages;

import com.codecool.locators.NavbarLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Navbar {
  protected NavbarLocator navbarLocator;
  private final WebDriverWait wait;

  public Navbar(WebDriver driver) {
    this.navbarLocator = new NavbarLocator(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public boolean isProfileBtnDisplayed() {
    wait.until(ExpectedConditions.elementToBeClickable(navbarLocator.getProfileBtn()));
    return navbarLocator.getProfileBtn().isDisplayed();
  }

  public boolean isLogoutDisplayed() {
    wait.until(ExpectedConditions.elementToBeClickable(navbarLocator.getLogOutButton()));
    return navbarLocator.getLogOutButton().isDisplayed();
  }

  public void clickNavbarSignInBtn() {
    wait.until(ExpectedConditions.elementToBeClickable(navbarLocator.getSignInButton()));
    navbarLocator.getSignInButton().click();
  }
}
