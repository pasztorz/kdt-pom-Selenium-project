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

  public String getCredentialsErrorText() {
    wait.until(ExpectedConditions.visibilityOf(loginLocator.getCredentialsError()));
    return loginLocator.getCredentialsError().getAttribute("innerText");
  }

  public String getPasswordErrorText() {
    wait.until(ExpectedConditions.visibilityOf(loginLocator.getPasswordError()));
    return loginLocator.getPasswordError().getAttribute("innerText");
  }

  public String getEmailErrorText() {
    wait.until(ExpectedConditions.visibilityOf(loginLocator.getEmailError()));
    return loginLocator.getEmailError().getAttribute("innerText");
  }

  public void clickSingIn() {
    wait.until(ExpectedConditions.elementToBeClickable(loginLocator.getSignInButton()));
    loginLocator.getSignInButton().click();
  }

  public void enterPassword(String password) {
    wait.until(ExpectedConditions.visibilityOf(loginLocator.getPasswordField()));
    loginLocator.getPasswordField().sendKeys(password);
  }

  public void enterEmail(String email) {
    wait.until(ExpectedConditions.visibilityOf(loginLocator.getEmailField()));
    loginLocator.getEmailField().sendKeys(email);
  }

  public void clickCreateBtn() {
    wait.until(ExpectedConditions.elementToBeClickable(loginLocator.getCreateButton()));
    loginLocator.getCreateButton().click();
  }
}
