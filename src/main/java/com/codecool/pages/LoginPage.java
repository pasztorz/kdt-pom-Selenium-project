package com.codecool.pages;

import com.codecool.locators.LoginLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends Page {
  private static final String URL = "https://playground.qatools.dev/login";

  protected LoginLocator loginLocator;
  private final WebDriverWait wait;

  public LoginPage(WebDriver driver) {
    super(driver, URL);
    this.loginLocator = new LoginLocator(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public void clickCreateBtn() {
    wait.until(ExpectedConditions.elementToBeClickable(loginLocator.getCreateButton()));
    loginLocator.getCreateButton().click();
  }
}
