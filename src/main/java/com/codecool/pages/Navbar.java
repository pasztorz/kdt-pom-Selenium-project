package com.codecool.pages;

import com.codecool.locators.NavbarLocator;
import com.codecool.model.Visible;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Navbar implements Visible {
  private final NavbarLocator navbarLocator;
  private final WebDriverWait wait;

  public Navbar(WebDriver driver) {
    this.navbarLocator = new NavbarLocator(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  @Override
  public boolean hasButtonWithText(String buttonText) {
    return getNavbarButtonTextList().contains(buttonText);
  }

  public List<String> getNavbarButtonTextList() {
    List<WebElement> navButtonList = navbarLocator.getNavbarNavButtonList();
    List<String> buttonTextList = new ArrayList<>();

    wait.until(ExpectedConditions.visibilityOf(navbarLocator.getPrimaryNavbar()));

    for (WebElement element : navButtonList) {
      String buttonText = element.getText();
      buttonTextList.add(buttonText);
    }

    return buttonTextList;
  }

  public void clickLogOutButton() {
    wait.until(ExpectedConditions.elementToBeClickable(navbarLocator.getLogOutButton()));
    navbarLocator.getLogOutButton().click();
  }

  public boolean logOutButtonContains(String password) {
    return getLogOutButtonText().contains(password);
  }

  public String getLogOutButtonText() {
    return navbarLocator.getLogOutButton().getAttribute("innerText");
  }

  public boolean profileButtonContains(String password) {
    return getProfileButtonText().contains(password);
  }

  public String getProfileButtonText() {
    wait.until(ExpectedConditions.visibilityOf(navbarLocator.getProfileButton()));
    return navbarLocator.getProfileButton().getAttribute("innerText");
  }

  public void clickProfileButton() {
    wait.until(ExpectedConditions.elementToBeClickable(navbarLocator.getProfileButton()));
    navbarLocator.getProfileButton().click();
  }

  public boolean isProfileBtnDisplayed() {
    wait.until(ExpectedConditions.elementToBeClickable(navbarLocator.getProfileButton()));
    return navbarLocator.getProfileButton().isDisplayed();
  }

  public boolean isLogOutDisplayed() {
    wait.until(ExpectedConditions.elementToBeClickable(navbarLocator.getLogOutButton()));
    return navbarLocator.getLogOutButton().isDisplayed();
  }

  public boolean isLoginDisplayed() {
    wait.until(ExpectedConditions.elementToBeClickable(navbarLocator.getSignInButton()));
    return navbarLocator.getSignInButton().isDisplayed();
  }

  public boolean isHomeButtonDisplayed() {
    wait.until(ExpectedConditions.elementToBeClickable(navbarLocator.getHomeButton()));
    return navbarLocator.getHomeButton().isDisplayed();
  }

  public void clickNavbarSignInBtn() {
    wait.until(ExpectedConditions.elementToBeClickable(navbarLocator.getSignInButton()));
    navbarLocator.getSignInButton().click();
  }
}
