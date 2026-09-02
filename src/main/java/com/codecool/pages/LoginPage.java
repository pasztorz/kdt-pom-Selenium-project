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

  public String getInvalidCredentialErrorText() {
    wait.until(ExpectedConditions.visibilityOf(loginLocator.getInvalidCredetialError()));
    String errorInnerText = loginLocator.getInvalidCredetialError().getAttribute("innerText");
    System.out.println(errorInnerText);
    return errorInnerText;
  }

  public String getpasswordErrorText() {
    wait.until(ExpectedConditions.visibilityOf(loginLocator.getPasswordError()));
    String errorInnerText = loginLocator.getPasswordError().getAttribute("innerText");
    System.out.println(errorInnerText);
    return errorInnerText;
  }

  public String getEmailErrorText() {
    wait.until(ExpectedConditions.visibilityOf(loginLocator.getEmailError()));
    String errorInnerText = loginLocator.getEmailError().getAttribute("innerText");
    System.out.println(errorInnerText);
    return errorInnerText;
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
