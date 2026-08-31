package com.codecool.keywords;

import com.codecool.locators.LoginLocator;
import com.codecool.locators.NavbarLocator;
import com.codecool.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginKeyword {
  protected LoginLocator loginLocator;
  protected NavbarLocator navbarLocator;
  private final WebDriverWait wait;
  private final LoginPage login;

  public LoginKeyword(WebDriver driver) {
    this.loginLocator = new LoginLocator(driver);
    this.navbarLocator = new NavbarLocator(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    this.login = new LoginPage(driver);
  }

  public void clickNavbarSignInBtn() {
    wait.until(ExpectedConditions.elementToBeClickable(navbarLocator.getSignInButton()));
    navbarLocator.getSignInButton().click();
  }

  public void clickCreateBtn() {
    wait.until(ExpectedConditions.elementToBeClickable(loginLocator.getCreateButton()));
    loginLocator.getCreateButton().click();
  }
}
