package com.codecool.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavbarLocator {

  @FindBy(css = ".btn.nav-cta")
  private WebElement signInButton;

  @FindBy(css = ".nav-link[data-testid='nav-profile']")
  private WebDriver profileButton;

  @FindBy(css = "button[class='btn-secondary']")
  private WebElement logOutButton;

  public NavbarLocator(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public WebElement getSignInButton() {
    return signInButton;
  }

  public WebDriver getProfileButton() {
    return profileButton;
  }

  public WebElement getLogOutButton() {
    return logOutButton;
  }
}
